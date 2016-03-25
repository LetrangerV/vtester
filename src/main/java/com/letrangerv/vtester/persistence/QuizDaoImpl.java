package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;
import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
@Component
@SuppressWarnings("unused")
public class QuizDaoImpl implements QuizDao {
    public static final String INSERT_QUIZ_SQL = "quiz.insert";
    public static final String SELECT_QUIZZES_BY_USER = "assignedQuiz.select.by.user";

    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    @Qualifier("quiz")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insert(QuizImpl quiz) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                queries.getProperty(INSERT_QUIZ_SQL),
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, quiz.getTitle());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<AssignedQuiz> findQuizzesByUser(String userName) {
        return jdbcTemplate.query(
            queries.getProperty(SELECT_QUIZZES_BY_USER),
            (resultSet, i) -> {
                QuizImpl quiz = new QuizImpl(resultSet.getString("title"));
                quiz.setId(resultSet.getInt("quiz_id"));
                AssignedQuiz assignedQuiz = new AssignedQuiz();
                assignedQuiz.setQuiz(quiz);
                assignedQuiz.setId(resultSet.getInt("assigned_quiz_id"));
                assignedQuiz.setMark(resultSet.getInt("mark"));
                assignedQuiz.setPassed(resultSet.getBoolean("is_passed"));
                return assignedQuiz;
            },
            userName
        );
    }
}
