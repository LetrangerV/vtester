/**
 * @(#)QuizDao.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.QuizImpl;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface QuizDao {
    int insert(QuizImpl quiz);
}
