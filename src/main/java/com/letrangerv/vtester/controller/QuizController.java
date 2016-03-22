package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.persistence.QuizAssembler;
import com.letrangerv.vtester.persistence.QuizDto;
import com.letrangerv.vtester.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
@Controller
@RequestMapping(path = "/quiz")
public class QuizController extends Utf8ContentController {
    @Autowired
    private QuizAssembler quizAssembler;
    @Autowired
    private QuizService quizService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public final String addQuizPage() {
        return "supervisor/addQuiz";
    }

    @RequestMapping(method = RequestMethod.POST)
    public final void addTypes(
        @RequestParam(name = "title", required = true) final String title,
        @RequestParam(name = "question_type", required = true) final String[] questionTypes,
        @RequestParam(name = "question_text", required = true) final String[] questionText,
        @RequestParam(name = "option_text", required = true) final String[] optionText,
        @RequestParam(name = "is-right-hid", required = true) final boolean[] isRight,
        @RequestParam(name = "options-count", required = true) final int[] numOfOptions
    ) {

        QuizDto quizDto = new QuizDto();
        quizDto.setTitle(title);
        quizDto.setQuestionTypes(questionTypes);
        quizDto.setQuestionText(questionText);
        quizDto.setOptionText(optionText);
        quizDto.setRightAnswer(isRight);
        quizDto.setNumberOfOptions(numOfOptions);

        QuizImpl quiz = quizAssembler.toQuiz(quizDto);
        quizService.insertQuiz(quiz);
    }

    @RequestMapping(method = RequestMethod.GET)
    public final String get() {
        return "quiz";
    }
}
