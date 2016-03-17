/**
 * @(#)OptionDaoImpl.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.AnswerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
@Component
public class OptionDaoImpl implements OptionDao {
//    @Value("${option.insert}")
    public static final String INSERT_OPTION_SQL = "option.insert";
    private JdbcTemplate m_jdbcTemplate;
    @Autowired
    @Qualifier("option")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        m_jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int[] batchAdd(List<AnswerOption> options, int questionId) {
        System.out.println(queries.getProperty(INSERT_OPTION_SQL));
        return m_jdbcTemplate.batchUpdate(queries.getProperty(INSERT_OPTION_SQL), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                AnswerOption option = options.get(i);
                preparedStatement.setString(1, option.getOptionText());
                preparedStatement.setBoolean(2, option.isRightAnswer());
                preparedStatement.setInt(3, questionId);
            }

            @Override
            public int getBatchSize() {
                return options.size();
            }
        });
    }
}
