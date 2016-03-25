package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.Student;
import com.letrangerv.vtester.domain.StudentClass;
import com.letrangerv.vtester.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/22/16
 */
@Controller
@RequestMapping("/supervisor")
public class SupervisorController extends Utf8ContentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/classes", method = RequestMethod.GET)
    public final String findClasses(final Model model, final Principal principal) {
//        List<StudentClass> classes = studentService.findBySupervisor(principal.getName());
        List<StudentClass> classes = studentService.findBySupervisor("admin@admin");
        model.addAttribute("classes", classes);

        return "supervisor/classes";
    }

    @RequestMapping(path = "/students/{className}", method = RequestMethod.GET)
    public final String findStudentsAndMarksByClass(
        final Model model,
        @PathVariable final String className
    ) {
        List<Student> students = studentService.findByClass(className);
        List<AssignedQuiz> quizzes = studentService.findQuizzesByClass(className);
        model.addAttribute("students", students);
        model.addAttribute("quizzes", quizzes);

        return "supervisor/students";
    }

    @RequestMapping(method = RequestMethod.GET)
    public final String profile() {
        return "supervisor/profile";
    }
}
