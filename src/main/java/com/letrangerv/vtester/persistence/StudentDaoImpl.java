package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.domain.Student;
import com.letrangerv.vtester.domain.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/23/16
 */
@Component
public class StudentDaoImpl implements StudentDao {
    public static final String SELECT_CLASS_BY_SUPERVISOR = "class.select.by.supervisor";
    public static final String SELECT_STUDENTS_MARKS_BY_CLASS = "students.marks.select.by.class";
    public static final String SELECT_QUIZZES_BY_CLASS = "quiz.select.by.class";

    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    @Qualifier("student")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Student> findByClass(final String className) {
        Map<Integer, Student> students = new HashMap<>();
        jdbcTemplate.query(queries.getProperty(SELECT_STUDENTS_MARKS_BY_CLASS), new StudentRowCallbackHandler(students), className);
         //todo order by quizAssignment date
        return new ArrayList<>(students.values());
    }

    @Override
    public List<StudentClass> findBySupervisor(final String email) {
        return jdbcTemplate.query(
            queries.getProperty(SELECT_CLASS_BY_SUPERVISOR),
            (rs, i) -> {
                StudentClass studentClass = new StudentClass();
                studentClass.setName(rs.getString("name"));
                return studentClass;
            },
            email
        );
    }

    @Override
    public List<AssignedQuiz> findQuizzesByClass(final String className) {
        return jdbcTemplate.query(
            queries.getProperty(SELECT_QUIZZES_BY_CLASS),
            (rs, i) -> {
                AssignedQuiz aQuiz = new AssignedQuiz();
                QuizImpl quiz = new QuizImpl(rs.getString("title"));
                aQuiz.setQuiz(quiz);
                return aQuiz;
            },
            className);
    }

    private class StudentRowCallbackHandler implements RowCallbackHandler {
        private final Map<Integer, Student> students;

        private StudentRowCallbackHandler(Map<Integer, Student> students) {
            this.students = students;
        }

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            Integer id = rs.getInt("student_id");
            Student student = students.get(id);

            if (student == null) {
                student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                students.put(id, student);
            }

            List<AssignedQuiz> assignedQuizzes = student.getAssignedQuizzes();
            if (assignedQuizzes == null) {
                assignedQuizzes = new ArrayList<>();
                student.setAssignedQuizzes(assignedQuizzes);
            }
            AssignedQuiz quiz = new AssignedQuiz();
            quiz.setMark(rs.getInt("mark"));
            quiz.setQuiz(new QuizImpl(rs.getString("title")));
            assignedQuizzes.add(quiz);
        }
    }
}
