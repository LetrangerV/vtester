package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
@SuppressWarnings("unused")
public class Option extends Entity {
    private String optionText;
    private boolean isRightAnswer;
    private int questionId;

    public final String getOptionText() {
        return optionText;
    }

    public final void setOptionText(final String optionText) {
        this.optionText = optionText;
    }

    public final boolean isRightAnswer() {
        return isRightAnswer;
    }

    public final void setRightAnswer(final boolean rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    public final int getQuestionId() {
        return questionId;
    }

    public final void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }
}
