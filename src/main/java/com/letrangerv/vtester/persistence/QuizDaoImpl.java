/**
 * @(#)QuizDaoImpl.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

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
public class QuizDaoImpl implements QuizDao {
    public static final String INSERT_QUIZ_SQL = "quiz.insert";

    private JdbcTemplate m_jdbcTemplate;

    @Autowired
    @Qualifier("quiz")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
       m_jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insert(QuizImpl quiz) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        m_jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(queries.getProperty(INSERT_QUIZ_SQL), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, quiz.getTitle());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
