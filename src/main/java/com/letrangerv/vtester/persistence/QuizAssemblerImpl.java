/**
 * @(#)QuizAssemblerImpl.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
@Component
public class QuizAssemblerImpl implements QuizAssembler {
    @Override
    public QuizImpl toQuiz(QuizDto quizDto) {
        //todo maybe add AnswerOptionAssembler and QuestionAssembler
        List<Question> questions = new ArrayList<>();
        int[] numOfOptions = quizDto.getNumberOfOptions();
        int optionsCounter = 0;
        for (int i = 0; i < quizDto.getQuestionTypes().length; i++) {
            //todo create different types of questions
            OneAnswerQuestion question = new OneAnswerQuestion();
            question.setQuestionText(quizDto.getQuestionText()[i]);
            question.setOptionSet(new HashSet<>());

            for (int j = 0; j < numOfOptions[i]; j++) {
                AnswerOption option = new AnswerOption();
                option.setOptionText(quizDto.getOptionText()[optionsCounter]);
                option.setRightAnswer(quizDto.getRightAnswer()[optionsCounter]);

                question.getOptionSet().add(option);
                optionsCounter++;
            }
            questions.add(question);
        }

        return new QuizImpl(questions);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QuizDto toQuizDto(QuizImpl quiz) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
