/**
 * @(#)OptionService.java 3/21/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.Option;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
public interface OptionService {
    List<Option> getByQuestionIds(List<Integer> questionIds);
}
