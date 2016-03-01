/**
 * @(#)Main.java 3/1/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package main.java.com.letrangerv.vtester;

import main.java.com.letrangerv.vtester.domain.*;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
public class Main {
    public static void main(String[] args) throws NoSuchQuestionTypeException {
        Quiz quiz = new QuizImpl();
        Question q1 = QuestionFactory.createQuestion("one_answer");


        quiz.addQuestion(q1);
    }
}
