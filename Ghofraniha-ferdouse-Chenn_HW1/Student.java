import java.util.ArrayList;
import java.util.Scanner;

// Student class - extends User and implements StudentInterface.
// Handles course registration, withdrawal, and viewing operations.
public class Student extends User implements StudentInterface {

    private static final long serialVersionUID = 1L;

    private ArrayList<Course> coursesRegistered;
    private static final int MAX_COURSES = 20; // cap on courses per student

    public Student() {
        super();
        this.coursesRegistered = new ArrayList<>();
    }

    public Student(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        this.coursesRegistered = new ArrayList<>();
    }

    public Student(String username, String password, String firstName, String lastName,
            ArrayList<Course> coursesRegistered) {
        super(username, password, firstName, lastName);
        this.coursesRegistered = coursesRegistered != null ? coursesRegistered : new ArrayList<>();
    }

    public ArrayList<Course> getCoursesRegistered() {
        return coursesRegistered;
    }

    public void setCoursesRegistered(ArrayList<Course> coursesRegistered) {
        // Guard against null to keep list valid
        if (coursesRegistered == null) {
            this.coursesRegistered = new ArrayList<>();
        } else {
            this.coursesRegistered = coursesRegistered;
        }
    }

    public int getRegisteredCount() {
        return coursesRegistered.size();
    }

    @Override
    public String toString() {
        return "Student [username=" + getUsername() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", coursesRegistered=" + coursesRegistered.size() + " courses]";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("         STUDENT MENU");
        System.out.println("========================================");
        System.out.println("Course Management:");
        System.out.println("  1. View all courses");
        System.out.println("  2. View all courses that are not full");
        System.out.println("  3. Register on a course");
        System.out.println("  4. Withdraw from a course");
        System.out.println("  5. View all courses I am registered in");
        System.out.println("  6. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || !(o instanceof Student))
            return false;
        Student otherStudent = (Student) o;
        return getUsername() != null && getUsername().equals(otherStudent.getUsername());
    }

    @Override
    public void viewAllCourses(ArrayList<Course> courseList) {
        System.out.println("\n========================================");
        System.out.println("           ALL COURSES");
        System.out.println("========================================");

        if (courseList == null || courseList.isEmpty()) {
            System.out.println("No courses available in the system.");
            return;
        }

        System.out.println("Course Name | Course ID | Instructor | Section | Location | Enrollment");

        for (Course course : courseList) {
            System.out.println(course.getCourseName() + " | " + course.getCourseId() + " | " +
                    course.getCourseInstructor() + " | " + course.getCourseSectionNum() + " | " +
                    course.getLocation() + " | " + course.getCurrentRegisteredNum() + "/" + course.getMaxNum());
        }
    }

    @Override
    public void viewAvailableCourses(ArrayList<Course> courseList) {
        System.out.println("\n========================================");
        System.out.println("       AVAILABLE COURSES (NOT FULL)");
        System.out.println("========================================");

        if (courseList == null || courseList.isEmpty()) {
            System.out.println("No courses available in the system.");
            return;
        }

        System.out.println("Course Name | Course ID | Instructor | Section | Location | Spots Left");

        int availableCount = 0;
        for (Course course : courseList) {
            if (!course.isFull()) {
                int spotsLeft = course.getMaxNum() - course.getCurrentRegisteredNum();
                System.out.println(course.getCourseName() + " | " + course.getCourseId() + " | " +
                        course.getCourseInstructor() + " | " + course.getCourseSectionNum() + " | " +
                        course.getLocation() + " | " + spotsLeft);
                availableCount++;
            }
        }

        if (availableCount == 0) {
            System.out.println("All courses are currently full.");
        }
    }

    @Override
    public void registerForCourse(ArrayList<Course> courseList, Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("        REGISTER FOR A COURSE");
        System.out.println("========================================");

        if (courseList == null || courseList.isEmpty()) {
            System.out.println("No courses available for registration.");
            return;
        }

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();

        System.out.print("Enter section number: ");
        int sectionNumber = scanner.nextInt();
        scanner.nextLine();

        String fullName = getFirstName() + " " + getLastName();

        // Find course by name and section
        Course targetCourse = null;
        for (int i = 0; i < courseList.size(); i++) {
            Course c = courseList.get(i);
            if (c.getCourseName().equals(courseName) && c.getCourseSectionNum() == sectionNumber) {
                targetCourse = c;
                break;
            }
        }

        if (targetCourse == null) {
            System.out.println("Error: Course not found.");
            return;
        }

        if (targetCourse.isFull()) {
            System.out.println("Error: Course '" + courseName + "' is full. Registration not possible.");
            return;
        }

        if (targetCourse.containsStudent(fullName)) {
            System.out.println("Error: You are already registered in this course.");
            return;
        }

        // Enforce per-student course limit
        if (coursesRegistered.size() >= MAX_COURSES) {
            System.out.println("Error: You have reached the maximum number of courses.");
            return;
        }

        // Add to course roster and to student's own list
        boolean added = targetCourse.addStudent(fullName);
        if (!added) {
            System.out.println("Error: Registration failed.");
            return;
        }
        coursesRegistered.add(targetCourse);

        System.out
                .println("Success! You have been registered for '" + courseName + "' (Section " + sectionNumber + ").");
        System.out.println(
                "Current enrollment: " + targetCourse.getCurrentRegisteredNum() + "/" + targetCourse.getMaxNum());
    }

    @Override
    public void withdrawFromCourse(ArrayList<Course> courseList, Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("        WITHDRAW FROM A COURSE");
        System.out.println("========================================");

        if (coursesRegistered.isEmpty()) {
            System.out.println("You are not registered in any courses.");
            return;
        }

        String fullName = getFirstName() + " " + getLastName();

        System.out.print("Enter course name to withdraw from: ");
        String courseName = scanner.nextLine().trim();

        System.out.print("Enter section number: ");
        int sectionNumber = scanner.nextInt();
        scanner.nextLine();

        Course targetCourse = null;
        for (Course c : courseList) {
            if (c.getCourseName().equalsIgnoreCase(courseName) && c.getCourseSectionNum() == sectionNumber) {
                targetCourse = c;
                break;
            }
        }

        if (targetCourse == null) {
            System.out.println("Error: Course '" + courseName + "' with section '" + sectionNumber + "' not found.");
            return;
        }

        if (!targetCourse.containsStudent(fullName)) {
            System.out.println("Error: You are not registered in this course.");
            return;
        }

        boolean removed = targetCourse.removeStudent(fullName);
        if (!removed) {
            System.out.println("Error: Could not withdraw from course.");
            return;
        }
        // Remove from student's local list to stay in sync
        for (int i = 0; i < coursesRegistered.size(); i++) {
            Course registeredCourse = coursesRegistered.get(i);
            if (registeredCourse.getCourseId().equals(targetCourse.getCourseId())
                    && registeredCourse.getCourseSectionNum() == targetCourse.getCourseSectionNum()) {
                coursesRegistered.remove(i);
                break;
            }
        }

        System.out
                .println("Success! You have been withdrawn from '" + courseName + "' (Section " + sectionNumber + ").");
        System.out.println(
                "Current enrollment: " + targetCourse.getCurrentRegisteredNum() + "/" + targetCourse.getMaxNum());
    }

    @Override
    public void viewMyCoursesStudent(String firstName, String lastName, ArrayList<Course> courseList) {
        System.out.println("\n========================================");
        System.out.println("         MY REGISTERED COURSES");
        System.out.println("========================================");

        String fullName = firstName + " " + lastName;

        // Scan all courses for ones containing this student
        if (courseList == null || courseList.isEmpty()) {
            System.out.println("No courses available in the system.");
            return;
        }

        System.out.println("Course Name | Course ID | Instructor | Section | Location");

        int myCoursesCount = 0;
        for (Course course : courseList) {
            if (course.containsStudent(fullName)) {
                System.out.println(course.getCourseName() + " | " + course.getCourseId() + " | " +
                        course.getCourseInstructor() + " | " + course.getCourseSectionNum() + " | " +
                        course.getLocation());
                myCoursesCount++;
            }
        }

        if (myCoursesCount == 0) {
            System.out.println("You are not registered in any courses.");
        } else {
            System.out.println("Total courses registered: " + myCoursesCount);
        }
    }
}
