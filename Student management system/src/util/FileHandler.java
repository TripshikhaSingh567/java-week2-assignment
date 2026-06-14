package util;

import model.Student;
import java.io.*;
import java.util.ArrayList;
/**
 * Handles saving and loading student records using serialization.
 */
public class FileHandler {
    private static final String FILE_NAME = "students.dat";
    /**
     * Saves all student records to a file.
     *
     * @param students list of students to save
     */
    public static void saveStudents(ArrayList<Student> students) {

        try (
                ObjectOutputStream outputStream =
                        new ObjectOutputStream(new FileOutputStream(FILE_NAME))
        ) {

            outputStream.writeObject(students);

            System.out.println("Student records saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving student records: "
                    + e.getMessage());
        }
    }
    /**
     * Loads student records from file.
     *
     * @return list of students
     */
    public static ArrayList<Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (
                ObjectInputStream inputStream =
                        new ObjectInputStream(new FileInputStream(FILE_NAME))
        ) {

            return (ArrayList<Student>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading student records: "
                    + e.getMessage());

            return new ArrayList<>();
        }
    }
}