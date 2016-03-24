package com.letrangerv.vtester.persistence;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
public class QuizDto {
    private String title;
    private String[] questionTypes;
    private String[] questionText;
    private String[] optionText;
    private boolean[] isRightAnswer;
    private int[] numberOfOptions;

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String[] getQuestionTypes() {
        return questionTypes;
    }

    public final void setQuestionTypes(final String[] questionTypes) {
        this.questionTypes = questionTypes;
    }

    public final String[] getQuestionText() {
        return questionText;
    }

    public final void setQuestionText(final String[] questionText) {
        this.questionText = questionText;
    }

    public final String[] getOptionText() {
        return optionText;
    }

    public final void setOptionText(final String[] optionText) {
        this.optionText = optionText;
    }

    public final boolean[] getRightAnswer() {
        return isRightAnswer;
    }

    public final void setRightAnswer(final boolean[] rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    public final int[] getNumberOfOptions() {
        return numberOfOptions;
    }

    public final void setNumberOfOptions(final int[] numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }
}
