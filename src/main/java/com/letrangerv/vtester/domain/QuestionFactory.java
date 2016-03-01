/**
 * @(#)QuestionFactory.java 3/1/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package main.java.com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
public class QuestionFactory {
    private static final String ONE_ANSWER = "one_answer";
    private static final String MULTIPLE_ANSWERS = "multi_answer";
    private static final String MAPPING = "mapping";
    private static final String USER_INPUT = "user_input";

//    private RequestParser

    public static Question createQuestion(final String typeOfQuestion) throws NoSuchQuestionTypeException {
        switch (typeOfQuestion) {
            case ONE_ANSWER: {
                return new SelectOneAnswerQuestion();
            }
            case MULTIPLE_ANSWERS: {
                return null;  //TODO CREATE CLASSES
            }
            case MAPPING: {
                return null;
            }
            case USER_INPUT: {
                return null;
            }
            default:
                throw new NoSuchQuestionTypeException(
                    "Can't create question with type " + typeOfQuestion
                );
        }
    }
}
