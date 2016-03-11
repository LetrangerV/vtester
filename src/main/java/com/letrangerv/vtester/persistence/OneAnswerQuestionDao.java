/**
 * @(#)OneAnswerQuestionDao.java 3/11/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Component
public class OneAnswerQuestionDao extends BaseDaoImpl<OneAnswerQuestion> {
    @Autowired
    private Properties m_properties;

//    Just create a simple Java Properties file with key-value pairs like this one:
//    users.select.all = select * from user  . You should be able to use \ at the end of the line to allow the content to go over multiply lines

    public OneAnswerQuestionDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<OneAnswerQuestion> findAll() {
//        return getJdbcTemplate().query();
        return super.findAll();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
