/**
 * @(#)QuizDto.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
public class QuizDto {
    private String[] questionTypes;
    private String[] questionText;
    private String[] optionText;
    private boolean[] isRightAnswer;
    private int[] numberOfOptions;

    public String[] getQuestionTypes() {
        return questionTypes;
    }

    public void setQuestionTypes(String[] questionTypes) {
        this.questionTypes = questionTypes;
    }

    public String[] getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String[] questionText) {
        this.questionText = questionText;
    }

    public String[] getOptionText() {
        return optionText;
    }

    public void setOptionText(String[] optionText) {
        this.optionText = optionText;
    }

    public boolean[] getRightAnswer() {
        return isRightAnswer;
    }

    public void setRightAnswer(boolean[] rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    public int[] getNumberOfOptions() {
        return numberOfOptions;
    }

    public void setNumberOfOptions(int[] numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }
}
