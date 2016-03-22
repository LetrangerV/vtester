package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.Option;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface OptionDao {
    int[] batchAdd(List<Option> options, int questionId);
    List<Option> getByQuestionIds(List<Integer> questionIds);
}
