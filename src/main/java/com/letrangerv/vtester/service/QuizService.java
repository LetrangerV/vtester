package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface QuizService {
    void insertQuiz(QuizImpl quiz);
    List<AssignedQuiz> findQuizzesByUser(String userName);
}
