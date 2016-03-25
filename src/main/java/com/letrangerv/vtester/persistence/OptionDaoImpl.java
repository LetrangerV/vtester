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
    private static final String SELECT_OPTIONS_BY_QUESTIONS = "option.select.by.questions";
    private static final String SELECT_RIGHT_ANSWERS_COUNT = "option.select.count.right";
    private static final String EVALUATE_QUIZ = "quiz.update.mark";

    private NamedParameterJdbcTemplate jdbcTemplate;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    @Qualifier("option")
    private Properties queries;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    @Qualifier("quiz")
    private Properties quizQueries;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int[] batchAdd(final List<Option> options, final int questionId) {
        return null;
    }

    @Override
    public List<Option> getByQuestionIds(final List<Integer> questionIds) {
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

    @Override
    public int getRightAnswersCount(final List<Integer> answerIds) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("ids", answerIds);
        return jdbcTemplate.queryForObject(
            queries.getProperty(SELECT_RIGHT_ANSWERS_COUNT),
            map,
            Integer.class);
    }

    @Override
    public void evaluate(final double rightAnswersPercentage, final int assignedQuizId) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("percentage", rightAnswersPercentage);
        map.addValue("id", assignedQuizId);
        jdbcTemplate.update(
            quizQueries.getProperty(EVALUATE_QUIZ),
            map
        );
    }
}
