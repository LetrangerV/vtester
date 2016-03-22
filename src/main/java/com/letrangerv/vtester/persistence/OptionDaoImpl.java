package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
@Component
@SuppressWarnings("unused")
public class OptionDaoImpl implements OptionDao {
    public static final String SELECT_OPTIONS_BY_QUESTIONS = "option.select.by.questions";
    private NamedParameterJdbcTemplate jdbcTemplate;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    @Qualifier("option")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int[] batchAdd(List<Option> options, int questionId) {
        return null;
    }

    @Override
    public List<Option> getByQuestionIds(List<Integer> questionIds) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("ids", questionIds);
        return jdbcTemplate.query(queries.getProperty(SELECT_OPTIONS_BY_QUESTIONS), map,
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
