package service;

import model.Student;
import java.util.ArrayList;

/**
 * Handles all student-related operations such as
 * add, search, update, delete and grade calculations.
 */

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }
    /**
     * Adds a new student after checking for duplicate IDs.
     *
     * @param student Student object to be added
     * @return true if added successfully, false otherwise
     */
    public boolean addStudent(Student student) {

        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                return false; // Duplicate ID found
            }
        }

        students.add(student);
        return true;
    }
    /**
     * Searches a student by ID.
     *
     * @param studentId ID to search
     * @return Student object if found, otherwise null
     */
    public Student searchById(int studentId) {

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }
    /**
     * Searches a student by name.
     *
     * @param name Student name
     * @return Matching student or null
     */
    public Student searchByName(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }
    /**
     * Displays all student records in a formatted table.
     */
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-30s%n",
                "ID", "Name", "Age", "Grade", "Subjects");
        System.out.println("--------------------------------------------------------------------------------");

        for (Student student : students) {

            System.out.printf("%-10d %-20s %-10d %-10.2f %-30s%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAge(),
                    student.getGrade(),
                    student.getSubjects());
        }

        System.out.println("--------------------------------------------------------------------------------");
    }
    /**
     * Updates the grade of a student.
     *
     * @param studentId Student ID
     * @param newGrade New grade
     * @return true if updated successfully
     */
    public boolean updateGrade(int studentId, double newGrade) {

        Student student = searchById(studentId);

        if (student != null) {
            student.setGrade(newGrade);
            return true;
        }

        return false;
    }
    /**
     * Updates the subjects of a student.
     *
     * @param studentId Student ID
     * @param subjects New subject list
     * @return true if updated successfully
     */
    public boolean updateSubjects(int studentId, ArrayList<String> subjects) {

        Student student = searchById(studentId);

        if (student != null) {
            student.setSubjects(subjects);
            return true;
        }

        return false;
    }
    /**
     * Deletes a student record.
     *
     * @param studentId Student ID
     * @return true if deleted successfully
     */
    public boolean deleteStudent(int studentId) {

        Student student = searchById(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
    /**
     * Calculates the average grade of all students.
     *
     * @return average grade
     */
    public double calculateAverageGrade() {

        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getGrade();
        }

        return total / students.size();
    }
    /**
     * Replaces the current student list.
     *
     * @param students list of students loaded from file
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    /**
     * Returns all student records.
     *
     * @return list of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
}
