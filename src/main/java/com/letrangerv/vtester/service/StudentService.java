package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.domain.Student;
import com.letrangerv.vtester.domain.StudentClass;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@SuppressWarnings("unused")
public interface StudentService {
    List<QuizImpl> findAssignedQuizzes(String userName);
    List<Student> findByClass(final String className);
    List<StudentClass> findBySupervisor(final String email);
    List<AssignedQuiz> findQuizzesByClass(final String className);
}
