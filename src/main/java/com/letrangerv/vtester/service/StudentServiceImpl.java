package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.QuizImpl;
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
    private StudentDao m_studentDao;

    @Override
    public List<QuizImpl> findAssignedQuizzes(String userName) {
        return null;
    }
}
