package com.letrangerv.vtester.domain;

import java.time.LocalDateTime;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@SuppressWarnings("unused")
public class AssignedQuiz {
    private QuizImpl quiz;
    private LocalDateTime deadline;

    public final QuizImpl getQuiz() {
        return quiz;
    }

    public final void setQuiz(final QuizImpl quiz) {
        this.quiz = quiz;
    }

    public final LocalDateTime getDeadline() {
        return deadline;
    }

    public final void setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
