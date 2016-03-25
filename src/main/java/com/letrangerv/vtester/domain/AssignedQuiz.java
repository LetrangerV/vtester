package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@SuppressWarnings("unused")
public class AssignedQuiz extends Entity {
    private QuizImpl quiz;
    private Integer mark;
    private boolean isPassed;

    public final QuizImpl getQuiz() {
        return quiz;
    }

    public final void setQuiz(final QuizImpl quiz) {
        this.quiz = quiz;
    }

    public final Integer getMark() {
        return mark;
    }

    public final void setMark(final Integer mark) {
        this.mark = mark;
    }

    public final boolean isPassed() {
        return isPassed;
    }

    public final void setPassed(final boolean passed) {
        isPassed = passed;
    }
}
