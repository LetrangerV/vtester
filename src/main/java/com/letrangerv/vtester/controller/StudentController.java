package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.domain.OneAnswerQuestion;
import com.letrangerv.vtester.domain.Option;
import com.letrangerv.vtester.domain.PassedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.service.OneAnswerQuestionServiceImpl;
import com.letrangerv.vtester.service.OptionService;
import com.letrangerv.vtester.service.QuizService;
import com.letrangerv.vtester.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@Controller
@RequestMapping("/student")
@SuppressWarnings("unused")
public class StudentController extends Utf8ContentController {
    @Autowired
    private QuizService m_quizService;
    @Autowired
    private OneAnswerQuestionServiceImpl m_questionService;
    @Autowired
    private StudentService m_studentService;
    @Autowired
    private OptionService m_optionService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage(Model model, Principal principal) {
//        List<QuizImpl> assignedQuizzes = m_quizService.findAssignedQuizzes(principal.getName());
//        List<PassedQuiz> passedQuizzes = m_quizService.findPassedQuizzes(principal.getName());
        List<QuizImpl> assignedQuizzes = m_quizService.findAssignedQuizzes("pupkin@22");
        List<PassedQuiz> passedQuizzes = m_quizService.findPassedQuizzes("pupkin@22");
        model.addAttribute("assignedQuizzes", assignedQuizzes);
        model.addAttribute("passedQuizzes", passedQuizzes);
        return "student/studentAllQuizzes";
    }

    @RequestMapping(path = "/pass/{title}", method = RequestMethod.GET)
    public String passQuiz(Model model, @PathVariable final String title) {
        //TODO bind sent results to current user
        List<OneAnswerQuestion> questions = m_questionService.getByQuiz(title);
        int[] questionIds = questions.stream().mapToInt(OneAnswerQuestion::getId).toArray();

        List<Integer> list = new ArrayList<>(questionIds.length);
        for (int questionId : questionIds) {
            list.add(questionId);
        }

        List<Option> options = m_optionService.getByQuestionIds(list);

        options.stream().forEach(o -> {
            Optional<OneAnswerQuestion> question = (
                questions
                    .stream()
                    .filter(q -> q.getId() == o.getQuestionId())
                    .findFirst()
            );
            question.get().getOptions().add(o);
        });

        model.addAttribute("questions", questions);

        return "student/pass";
    }

    @RequestMapping(path = "/quiz", method = RequestMethod.POST)
    public String evaluateQuiz() {
        //todo parse sent results, replace by json in future

        return "redirect:/student/success";
    }

    @RequestMapping(path = "/success", method = RequestMethod.GET)

    public String success() {
        return "student/success";
    }

}
