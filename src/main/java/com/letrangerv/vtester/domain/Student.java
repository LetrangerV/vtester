package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@SuppressWarnings("unused")
public class Student extends Entity {
    private String firstName;
    private String lastName;
    private String email;
    private List<AssignedQuiz> assignedQuizzes;

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

    public final List<AssignedQuiz> getAssignedQuizzes() {
        return assignedQuizzes;
    }

    public final void setAssignedQuizzes(final List<AssignedQuiz> assignedQuizzes) {
        this.assignedQuizzes = assignedQuizzes;
    }
}
