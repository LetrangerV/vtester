package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Component
public class OneAnswerQuestionDaoImpl implements OneAnswerQuestionDao {
    private static final String SELECT_QUESTIONS_BY_QUIZ = "question.select.by.quiz";
    private static final String INSERT_QUESTION_SQL = "question.insert";

    private JdbcTemplate m_jdbcTemplate;

    @Autowired
    @Qualifier("question")
    private Properties queries;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        m_jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int add(OneAnswerQuestion question, final int quizId, final String type) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        m_jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                queries.getProperty(INSERT_QUESTION_SQL),
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, question.getQuestionText());
            ps.setInt(2, quizId);
            ps.setString(3, type);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<OneAnswerQuestion> getByQuiz(final int quizId) {
        return m_jdbcTemplate.query(
            queries.getProperty(SELECT_QUESTIONS_BY_QUIZ),
            (resultSet, i) -> {
            OneAnswerQuestion question = new OneAnswerQuestion();
            question.setOptions(new ArrayList<>());
            question.setId(resultSet.getInt("question_id"));
            question.setQuestionText("text");
            //type id is omitted for now
            return question;
        },
            quizId);
    }
}
