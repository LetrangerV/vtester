/**
 * @(#)MarkImpl.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package main.java.com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class MarkImpl implements Mark {
    @Override
    public int convertToMark(double correctAnswersFraction) {
        if (correctAnswersFraction >= 0.9) {
            return 5;
        }

        if (correctAnswersFraction >= 0.7) {
            return 4;
        }

        if (correctAnswersFraction >= 0.5) {
            return 3;
        }

        return 2;
    }
}
