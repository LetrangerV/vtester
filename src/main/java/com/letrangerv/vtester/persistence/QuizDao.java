package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.PassedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface QuizDao {
    int insert(QuizImpl quiz);
    List<QuizImpl> findAssignedQuizzes(String userName);
    List<PassedQuiz> findPassedQuizzes(String userName);
}
