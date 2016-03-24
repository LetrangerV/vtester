package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.AssignedQuiz;
import com.letrangerv.vtester.domain.Student;
import com.letrangerv.vtester.domain.StudentClass;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
public interface StudentDao {
    List<Student> findByClass(final String className);
    List<StudentClass> findBySupervisor(final String email);
    List<AssignedQuiz> findQuizzesByClass(final String className);
}
