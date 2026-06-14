package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a student record in the Student Management System.
 */

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int studentId;
    private String name;
    private int age;
    private double grade;
    private ArrayList<String> subjects;

    public Student(int studentId, String name, int age, double grade, ArrayList<String> subjects) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.subjects = subjects;
    }

    // Getters and setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    // converting to toString
    @Override
    public String toString() {
        return "ID: " + studentId +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGrade: " + grade +
                "\nSubjects: " + subjects;
    }

}
