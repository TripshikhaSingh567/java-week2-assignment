import model.Student;
import service.StudentManager;
import util.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        manager.setStudents(FileHandler.loadStudents());

        boolean running = true;

        while (running) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average Grade");
            System.out.println("7. Save Records");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Grade: ");
                    double grade = Double.parseDouble(scanner.nextLine());

                    ArrayList<String> subjects = new ArrayList<>();

                    System.out.print("How many subjects? ");
                    int subjectCount = Integer.parseInt(scanner.nextLine());

                    for (int i = 1; i <= subjectCount; i++) {

                        System.out.print("Enter Subject " + i + ": ");
                        subjects.add(scanner.nextLine());
                    }

                    Student student = new Student(
                            id,
                            name,
                            age,
                            grade,
                            subjects
                    );

                    boolean added = manager.addStudent(student);

                    if (added) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student ID already exists.");
                    }
                    break;

                case 2:

                    manager.displayAllStudents();

                    break;

                case 3:
                    System.out.println("\nSearch Student");
                    System.out.println("1. Search By ID");
                    System.out.println("2. Search By Name");
                    System.out.print("Enter choice: ");

                    int searchChoice = Integer.parseInt(scanner.nextLine());

                    if (searchChoice == 1) {

                        System.out.print("Enter Student ID: ");
                        int searchId = Integer.parseInt(scanner.nextLine());

                        Student foundStudent = manager.searchById(searchId);

                        if (foundStudent != null) {
                            System.out.println("\nStudent Found:");
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    else if (searchChoice == 2) {

                        System.out.print("Enter Student Name: ");
                        String searchName = scanner.nextLine();

                        Student foundStudent = manager.searchByName(searchName);

                        if (foundStudent != null) {
                            System.out.println("\nStudent Found:");
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    else {
                        System.out.println("Invalid search option.");
                    }
                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.println("1. Update Grade");
                    System.out.println("2. Update Subjects");
                    System.out.print("Enter choice: ");

                    int updateChoice = Integer.parseInt(scanner.nextLine());

                    if (updateChoice == 1) {

                        System.out.print("Enter New Grade: ");
                        double newGrade = Double.parseDouble(scanner.nextLine());

                        boolean updated = manager.updateGrade(updateId, newGrade);

                        if (updated) {
                            System.out.println("Grade updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                    }

                    else if (updateChoice == 2) {

                        ArrayList<String> newSubjects = new ArrayList<>();

                        System.out.print("How many subjects? ");
                        int count = Integer.parseInt(scanner.nextLine());

                        for (int i = 1; i <= count; i++) {

                            System.out.print("Enter Subject " + i + ": ");
                            newSubjects.add(scanner.nextLine());
                        }

                        boolean updated = manager.updateSubjects(updateId, newSubjects);

                        if (updated) {
                            System.out.println("Subjects updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                    }

                    else {
                        System.out.println("Invalid update option.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    Student studentToDelete = manager.searchById(deleteId);

                    if (studentToDelete == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("\nStudent Found:");
                    System.out.println(studentToDelete);

                    System.out.print("Are you sure you want to delete? (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {

                        boolean deleted = manager.deleteStudent(deleteId);

                        if (deleted) {
                            System.out.println("Student deleted successfully.");
                        }

                    } else {
                        System.out.println("Deletion cancelled.");
                    }

                    break;

                case 6:

                    double average = manager.calculateAverageGrade();

                    if (average == 0) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.printf("Class Average Grade: %.2f%n", average);
                    }

                    break;

                case 7:

                    FileHandler.saveStudents(manager.getStudents());

                    break;

                case 8:

                    FileHandler.saveStudents(manager.getStudents());

                    System.out.println("Exiting application...");

                    running = false;

                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}