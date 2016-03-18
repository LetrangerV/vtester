/**
 * @(#)StudentServiceImpl.java 3/18/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
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
public class StudentServiceImpl implements StudentService {
//    @Autowired
//    private StudentDao m_studentDao;

    @Override
    public List<QuizImpl> findAssignedQuizzes(String userName) {
//        return m_studentDao.findAssignedQuizzes(userName);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
