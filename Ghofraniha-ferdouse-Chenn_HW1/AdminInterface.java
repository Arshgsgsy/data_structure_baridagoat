import java.util.ArrayList;
import java.util.Scanner;

// Interface representing Admin operations for course management.
// Implemented by Admin class.
public interface AdminInterface {

    void displayMenu();

    void createCourse(ArrayList<Course> courses, Scanner scanner);

    void deleteCourse(ArrayList<Course> courses, ArrayList<Student> studentList, Scanner scanner);

    void editCourse(ArrayList<Course> courses, Scanner scanner);

    void displayCourseInfo(ArrayList<Course> courses, Scanner scanner);

    void registerStudent(ArrayList<Student> studentList, Scanner scanner);

    void viewAllCourses(ArrayList<Course> courses);

    void viewFullCourses(ArrayList<Course> courses);

    void viewStudentsInCourse(ArrayList<Course> courses, Scanner scanner);

    void viewCoursesByStudent(ArrayList<Course> courses, Scanner scanner);

    void writeFullCoursesToFile(ArrayList<Course> courses);

    void sortCoursesByStudentCount(ArrayList<Course> courses);
}
