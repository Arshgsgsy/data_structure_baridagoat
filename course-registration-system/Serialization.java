import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// Saves and loads courses/students to/from .ser files for session persistence.
public class Serialization {

    // Writes courses to a binary file; returns false on I/O error.
    public static boolean saveCourses(String path, ArrayList<Course> courses) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(courses);
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
            return false;
        }
    }

    // Reads courses from file; returns null if file missing or invalid.
    public static ArrayList<Course> loadCourses(String path) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            Object data = in.readObject();
            in.close();

            if (data instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Course> courses = (ArrayList<Course>) data;
                return courses;
            }
        } catch (IOException e) {
            // File missing or unreadable; return null for first run
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
        return null;
    }

    // Writes students to a binary file; returns false on I/O error.
    public static boolean saveStudents(String path, ArrayList<Student> students) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(students);
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
            return false;
        }
    }

    // Reads students from file; returns null if file missing or invalid.
    public static ArrayList<Student> loadStudents(String path) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            Object data = in.readObject();
            in.close();

            if (data instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Student> students = (ArrayList<Student>) data;
                return students;
            }
        } catch (IOException e) {
            // If file does not exist yet, return null.
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return null;
    }
}
