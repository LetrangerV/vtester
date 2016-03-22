package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class OneAnswerQuestion extends Entity implements Question {
    private String questionText;
    private List<Option> options;

    public final String getQuestionText() {
        return questionText;
    }

    public final void setQuestionText(final String questionText) {
        this.questionText = questionText;
    }

    public final void setOptions(final List<Option> options) {
        this.options = options;
    }

    public final List<Option> getOptions() {
        return options;
    }

    @Override
    public final int evaluate() {

        return 0;
    }

    @Override
    public final int getMaxScore() {
        return 1;
    }
}
