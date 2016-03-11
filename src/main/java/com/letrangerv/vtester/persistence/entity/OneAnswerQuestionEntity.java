/**
 * @(#)OneAnswerQuestionEntity.java 3/11/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence.entity;

import com.letrangerv.vtester.domain.AnswerOption;

import java.util.Set;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
public class OneAnswerQuestionEntity extends Entity {
    private String questionText;
    private Set<AnswerOption> m_optionSet;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Set<AnswerOption> getOptionSet() {
        return m_optionSet;
    }

    public void setOptionSet(Set<AnswerOption> optionSet) {
        m_optionSet = optionSet;
    }
}
