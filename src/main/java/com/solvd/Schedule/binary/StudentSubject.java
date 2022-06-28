package com.solvd.Schedule.binary;

import java.util.Objects;

public class StudentSubject {

    private long id;
    private Student student;
    private Subject subject;
    private int grade;

    public StudentSubject(long id, Student student, Subject subject, int grade) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public StudentSubject() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSubject)) return false;
        StudentSubject that = (StudentSubject) o;
        return id == that.id && grade == that.grade && Objects.equals(student, that.student) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, subject, grade);
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", grade=" + grade +
                '}';
    }
}
