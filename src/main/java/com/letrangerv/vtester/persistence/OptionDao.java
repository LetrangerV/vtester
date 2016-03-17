/**
 * @(#)OptionDao.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.AnswerOption;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface OptionDao {
    int[] batchAdd(List<AnswerOption> options, int questionId);
}
