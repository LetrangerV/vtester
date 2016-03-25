package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.domain.*;
import com.letrangerv.vtester.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private QuizService quizService;
    @Autowired
    private OneAnswerQuestionServiceImpl questionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private OptionService optionService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage(Model model, Principal principal) {
//        List<QuizImpl> allQuizzes = quizService.findQuizzesByUser(principal.getName());
//        List<PassedQuiz> passedQuizzes = quizService.findPassedQuizzes(principal.getName());
        List<AssignedQuiz> allQuizzes = quizService.findQuizzesByUser("pupkin@22");

        List<AssignedQuiz> assignedQuizzes = new ArrayList<>();
        List<AssignedQuiz> passedQuizzes = new ArrayList<>();

        for (AssignedQuiz q : allQuizzes) {
            if (q.isPassed()) {
                passedQuizzes.add(q);
            } else {
                assignedQuizzes.add(q);
            }
        }

        model.addAttribute("assignedQuizzes", assignedQuizzes);
        model.addAttribute("passedQuizzes", passedQuizzes);
        return "student/studentAllQuizzes";
    }

    @RequestMapping(path = "/pass/{assignedQuizId}", method = RequestMethod.GET)
    public String passQuiz(Model model, @PathVariable final int assignedQuizId) {
        //TODO bind sent results to current user
        List<OneAnswerQuestion> questions = questionService.getByQuiz(assignedQuizId);
        int[] questionIds = questions.stream().mapToInt(OneAnswerQuestion::getId).toArray();

        List<Integer> list = new ArrayList<>(questionIds.length);
        for (int questionId : questionIds) {
            list.add(questionId);
        }

        List<Option> options = optionService.getByQuestionIds(list);

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
        model.addAttribute("assignedQuizId", assignedQuizId);

        return "student/pass";
    }

    @RequestMapping(path = "/classes", method = RequestMethod.GET)
    public String getStudentsAndMarks(Model model, final Principal principal) {
//        List<Student> students = studentService.findByClass(principal.getName());
//        List<StudentClass> classes = studentService.findBySupervisor(principal.getName());
        List<StudentClass> classes = studentService.findBySupervisor("admin@admin");
        model.addAttribute("classes", classes);

        return "supervisor/classes";
    }

    @RequestMapping(path = "/quiz", method = RequestMethod.POST)
    public String evaluateQuiz(HttpServletRequest request) throws ServiceException {
        ArrayList<Integer> answerIds = new ArrayList<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        int assignedQuizId = -1;

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();

            if ("assignedQuizId".equals(paramName)) {
                assignedQuizId = Integer.parseInt(request.getParameter(paramName));
            } else {
                answerIds.add(Integer.valueOf(request.getParameter(paramName)));
            }
        }

        if (assignedQuizId == -1) {
            throw new ServiceException("Failed to evaluate quiz: No assigned quiz found.");
        }

        optionService.updateQuizResults(answerIds, assignedQuizId);
        return "redirect:/student/success";
    }

    @RequestMapping(path = "/success", method = RequestMethod.GET)
    public String success() {
        return "student/success";
    }

}
