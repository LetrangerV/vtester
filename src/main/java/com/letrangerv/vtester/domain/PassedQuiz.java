package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@SuppressWarnings("unused")
public class PassedQuiz {
    private QuizImpl quiz;
    private int mark;

    public final QuizImpl getQuiz() {
        return quiz;
    }

    public final void setQuiz(final QuizImpl quiz) {
        this.quiz = quiz;
    }

    public final int getMark() {
        return mark;
    }

    public final void setMark(final int mark) {
        this.mark = mark;
    }
}
