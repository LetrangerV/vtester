/**
 * @(#)OptionDaoImpl.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
@Component
public class OptionDaoImpl implements OptionDao {
    public static final String SELECT_OPTIONS_BY_QUESTIONS = "option.select.by.questions";
//    @Value("${option.insert}")
    public static final String INSERT_OPTION_SQL = "option.insert";
    private NamedParameterJdbcTemplate m_jdbcTemplate;
    @Autowired
    @Qualifier("option")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        m_jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int[] batchAdd(List<Option> options, int questionId) {
//        System.out.println(queries.getProperty(INSERT_OPTION_SQL));
//        return m_jdbcTemplate.batchUpdate(queries.getProperty(INSERT_OPTION_SQL), new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                Option option = options.get(i);
//                preparedStatement.setString(1, option.getOptionText());
//                preparedStatement.setBoolean(2, option.isRightAnswer());
//                preparedStatement.setInt(3, questionId);
//            }
//
//            @Override
//            public int getBatchSize() {
//                return options.size();
//            }
//        });
        return null;
    }

    @Override
    public List<Option> getByQuestionIds(List<Integer> questionIds) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("ids", questionIds);                             //todo debug
        return m_jdbcTemplate.query(queries.getProperty(SELECT_OPTIONS_BY_QUESTIONS), map,
            (resultSet, i) -> {
            Option option = new Option();
            option.setId(resultSet.getInt("option_id"));
            option.setOptionText(resultSet.getString("text"));
            option.setRightAnswer(resultSet.getBoolean("is_right"));
            option.setQuestionId(resultSet.getInt("question_id"));
            return option;
        }
            );
    }
}
