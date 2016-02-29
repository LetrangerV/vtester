/**
 * @(#)OneAnswerOfManyQuestion.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package main.java.com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class OneAnswerOfManyQuestion implements Question {
    @Override
    public int evaluate() {
        return 0;
    }

    @Override
    public int getMaxScore() {
        return 1;
    }
}
