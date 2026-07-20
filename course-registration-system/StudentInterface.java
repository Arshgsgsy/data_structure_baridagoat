import java.util.ArrayList;
import java.util.Scanner;

// Interface defining student operations for course management.
// Implemented by Student class.
public interface StudentInterface {

    void viewAllCourses(ArrayList<Course> courseList);

    void viewAvailableCourses(ArrayList<Course> courseList);

    void registerForCourse(ArrayList<Course> courseList, Scanner scanner);

    void withdrawFromCourse(ArrayList<Course> courseList, Scanner scanner);

    void viewMyCoursesStudent(String firstName, String lastName, ArrayList<Course> courseList);
}
