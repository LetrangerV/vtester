/**
 * @(#)Quiz.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public interface Quiz {
    void addQuestion(Question q);
    void removeQuestion(Question q);
    int calculateResult();
    int calculateMaxScore();
}
