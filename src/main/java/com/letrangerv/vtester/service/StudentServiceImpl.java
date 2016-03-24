package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.domain.Student;
import com.letrangerv.vtester.domain.StudentClass;
import com.letrangerv.vtester.persistence.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@Component
@SuppressWarnings("unused")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public final List<QuizImpl> findAssignedQuizzes(final String userName) {
        return null;
    }

    @Override
    public final List<Student> findByClass(final String className) {
        return studentDao.findByClass(className);
    }

    @Override
    public final List<StudentClass> findBySupervisor(final String email) {
        return studentDao.findBySupervisor(email);
    }

    @Override
    public List<AssignedQuiz> findQuizzesByClass(final String className) {
        return studentDao.findQuizzesByClass(className);
    }
}
