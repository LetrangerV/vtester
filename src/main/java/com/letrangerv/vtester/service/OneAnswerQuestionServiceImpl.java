package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import com.letrangerv.vtester.persistence.OneAnswerQuestionDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Service
public class OneAnswerQuestionServiceImpl implements OneAnswerQuestionService {
    @Autowired
    private OneAnswerQuestionDaoImpl questionDao;

    public final List<OneAnswerQuestion> getByQuiz(final int quizId) {
        return questionDao.getByQuiz(quizId);
    }
}
