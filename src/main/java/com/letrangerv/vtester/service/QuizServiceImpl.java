package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import com.letrangerv.vtester.domain.PassedQuiz;
import com.letrangerv.vtester.domain.Question;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.persistence.OneAnswerQuestionDaoImpl;
import com.letrangerv.vtester.persistence.OptionDao;
import com.letrangerv.vtester.persistence.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
@Component
@SuppressWarnings("unused")
public class QuizServiceImpl implements QuizService {
    @Autowired
    private OneAnswerQuestionDaoImpl m_questionDao;
    @Autowired
    private QuizDao m_quizDao;
    @Autowired
    private OptionDao m_optionDao;

    @Transactional
    public void insertQuiz(QuizImpl quiz) {
        int quizId = m_quizDao.insert(quiz);
        List<Question> questions = quiz.getQuestions();
        questions.forEach(q -> {
            OneAnswerQuestion question = (OneAnswerQuestion) q;
            String type = null;
            if (question instanceof OneAnswerQuestion) {
                type = "one_answer";
            }

            int questionId = m_questionDao.add(question, quizId, type);
            m_optionDao.batchAdd(question.getOptions(), questionId);

        });
    }

    @Override
    public List<QuizImpl> findAssignedQuizzes(String userName){
        return m_quizDao.findAssignedQuizzes(userName);
    }

    @Override
    public List<PassedQuiz> findPassedQuizzes(String userName) {
        return m_quizDao.findPassedQuizzes(userName);
    }
}
