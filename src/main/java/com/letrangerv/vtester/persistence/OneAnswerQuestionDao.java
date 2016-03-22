package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.OneAnswerQuestion;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
public interface OneAnswerQuestionDao {
    int add(OneAnswerQuestion question, final int quizId, final String type);
    List<OneAnswerQuestion> getByQuiz(final String title);
}
