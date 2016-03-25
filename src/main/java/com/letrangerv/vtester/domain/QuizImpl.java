package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class QuizImpl extends Entity {
    private List<Question> questions;
    private String title;

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final List<Question> getQuestions() {
        return questions;
    }

    public final void setQuestions(final List<Question> questions) {
        this.questions = questions;
    }

    public QuizImpl(final String title) {
        this.title = title;
    }

    public QuizImpl(final List<Question> questions) {
        this.questions = questions;
    }
}
