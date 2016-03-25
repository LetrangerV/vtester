package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.Option;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
public interface OptionService {
    List<Option> getByQuestionIds(List<Integer> questionIds);
    void updateQuizResults(List<Integer> answerIds, int quizId);
}
