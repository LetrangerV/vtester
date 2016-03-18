/**
 * @(#)StudentService.java 3/18/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.QuizImpl;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
public interface StudentService {
    List<QuizImpl> findAssignedQuizzes(String userName);
}
