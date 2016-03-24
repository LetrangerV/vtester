package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@SuppressWarnings("unused")
public class StudentClass extends Entity {
    private List<Student> students;
    private String name;

    public final List<Student> getStudents() {
        return students;
    }

    public final void setStudents(final List<Student> students) {
        this.students = students;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }
}
