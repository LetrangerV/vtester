/**
 * @(#)OptionServiceImpl.java 3/21/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.Option;
import com.letrangerv.vtester.persistence.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
@Component
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao m_optionDao;

    @Override
    public List<Option> getByQuestionIds(List<Integer> questionIds) {
        return m_optionDao.getByQuestionIds(questionIds);
    }
}
