/**
 * @(#)QuizImpl.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class QuizImpl implements Quiz {
    private List<Question> m_questions;
    private String title;
    private int m_maxScore;
    private int m_totalScore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return m_questions;
    }

    public void setQuestions(List<Question> questions) {
        m_questions = questions;
    }

    public QuizImpl(List<Question> questions) {
        m_questions = questions;
    }

    public void addQuestion(Question q) {
        m_questions.add(q);
    }

    public void removeQuestion(Question q) {
        m_questions.remove(q);
    }

    @Override
    public int calculateResult() {
        m_totalScore = m_questions.stream().mapToInt(Question::evaluate).reduce(0, Integer::sum);
        return m_totalScore;
    }

    @Override
    public int calculateMaxScore() {
        m_maxScore= m_questions.stream().mapToInt(Question::getMaxScore).reduce(0, Integer::sum);
        return m_maxScore;
    }
}
