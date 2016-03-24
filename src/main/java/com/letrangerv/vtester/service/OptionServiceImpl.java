package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.Option;
import com.letrangerv.vtester.persistence.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
@Component
@SuppressWarnings("unused")
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao optionDao;

    @Override
    public final List<Option> getByQuestionIds(final List<Integer> questionIds) {
        return optionDao.getByQuestionIds(questionIds);
    }
}
