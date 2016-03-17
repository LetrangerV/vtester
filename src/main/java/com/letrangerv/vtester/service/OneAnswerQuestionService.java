/**
 * @(#)OneAnswerQuestionService.java 3/11/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import com.letrangerv.vtester.persistence.OneAnswerQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Service
public class OneAnswerQuestionService {
    @Autowired
    private OneAnswerQuestionDao m_questionDao;

//    public List<OneAnswerQuestion> findAll() {
//        return m_questionDao.findAll();
//    }

}
