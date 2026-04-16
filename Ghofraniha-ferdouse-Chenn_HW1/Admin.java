import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

// Admin user: manages courses, students, and reports.
// Implements AdminInterface; default credentials: Admin / Admin001.
public class Admin extends User implements AdminInterface {
    public Admin() {
        super("Admin", "Admin001", "University", "Admin");
    }

    public Admin(String u, String p, String f, String l) {
        super(u, p, f, l);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n================ ADMIN MENU ================");
        System.out.println("--- Reports ---");
        System.out.println("1. View All Courses");
        System.out.println("2. View Full Courses");
        System.out.println("3. Write Full Courses to File");
        System.out.println("4. View Students in a Course");
        System.out.println("5. View Courses of a Student");
        System.out.println("6. Sort Courses");
        System.out.println("--- Management ---");
        System.out.println("7. Create a New Course");
        System.out.println("8. Delete a Course");
        System.out.println("9. Edit a Course");
        System.out.println("10. Display Course Info");
        System.out.println("11. Register a Student");
        System.out.println("------------------");
        System.out.println("0. Logout");
        System.out.println("============================================");
        System.out.print("Enter your choice: ");
    }

    // Prompts for course details and adds a new course if ID+section are unique.
    public void createCourse(ArrayList<Course> courses, Scanner scanner) {
        System.out.println("Please input the name of the course: ");
        String name = scanner.nextLine();

        System.out.println("Please input the course ID: ");
        String courseId = scanner.nextLine();

        System.out.println("Please input the maximum registered number: ");
        int maxStudents = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please input the name of the instructor: ");
        String instructor = scanner.nextLine();

        System.out.println("Please input the section number: ");
        int section = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please input the location: ");
        String location = scanner.nextLine();

        for (Course course : courses) {
            if (course.getCourseId().equals(courseId) && course.getCourseSectionNum() == section) {
                System.out.println("Error: A course with this ID and section already exists.");
                return;
            }
        }

        // Create a new Course object
        Course newCourse = new Course(name, courseId, maxStudents, 0, instructor, section, location);
        courses.add(newCourse);
        System.out.println("Success: New course has been added.");
    }

    // Deletes a course by ID+section; also removes it from all students' registrations.
    public void deleteCourse(ArrayList<Course> courses, ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter course ID to delete: ");
        String courseId = scanner.nextLine().trim();
        System.out.print("Enter section number to delete: ");
        int section = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getCourseId().equals(courseId) && course.getCourseSectionNum() == section) {
                courses.remove(i);
                // Clean up references in all students' registered lists
                if (students != null) {
                    for (Student student : students) {
                        ArrayList<Course> registered = student.getCoursesRegistered();
                        if (registered != null) {
                            registered.removeIf(c -> c.getCourseId().equals(courseId)
                                    && c.getCourseSectionNum() == section);
                        }
                    }
                }
                System.out.println("Success: Course deleted.");
                return;
            }
        }
        System.out.println("Error: Course not found.");
    }

    // Edits max capacity, instructor, section, or location for a course.
    public void editCourse(ArrayList<Course> courses, Scanner scanner) {
        System.out.print("Enter course ID to edit: ");
        String courseId = scanner.nextLine().trim();
        System.out.print("Enter section number to edit: ");
        int section = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < courses.size(); i++) {
            Course currentCourse = courses.get(i);

            if (currentCourse.getCourseId().equals(courseId) && currentCourse.getCourseSectionNum() == section) {
                System.out.println("Found course: " + currentCourse.getCourseName());
                System.out.println("Please choose which one you want to edit: ");
                System.out.println("1. Maximum Capacity");
                System.out.println("2. Instructor");
                System.out.println("3. Section Number");
                System.out.println("4. Location");

                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    System.out.println("Please enter the updated maximum capacity:");
                    int newMax = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = currentCourse.setMaxNum(newMax);
                    if (!updated) {
                        System.out
                                .println("Error: Maximum capacity cannot be smaller than current registered students.");
                        return;
                    }
                } else if (choice.equals("2")) {
                    System.out.println("Please enter the name of new instructor:");
                    String newInstructor = scanner.nextLine();
                    currentCourse.setCourseInstructor(newInstructor);
                } else if (choice.equals("3")) {
                    System.out.println("Please enter the new section number:");
                    int newSection = scanner.nextInt();
                    scanner.nextLine();

                    // Ensure new section number doesn't conflict with another course
                    for (int j = 0; j < courses.size(); j++) {
                        Course otherCourse = courses.get(j);
                        if (otherCourse != currentCourse
                                && otherCourse.getCourseId().equals(currentCourse.getCourseId())
                                && otherCourse.getCourseSectionNum() == newSection) {
                            System.out.println("Error: Another course with this ID and section already exists.");
                            return;
                        }
                    }

                    currentCourse.setCourseSectionNum(newSection);
                } else if (choice.equals("4")) {
                    System.out.println("Please enter the new location:");
                    String newLocation = scanner.nextLine();
                    currentCourse.setLocation(newLocation);
                } else {
                    System.out.println("Error: Invalid choice.");
                    return;
                }

                System.out.println("Edit success!");
                return;
            }
        }
        System.out.println("Error: Course not found.");
    }

    // Displays full details for a course (including enrolled students).
    public void displayCourseInfo(ArrayList<Course> courses, Scanner scanner) {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine().trim();
        System.out.print("Enter section number: ");
        int section = scanner.nextInt();
        scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < courses.size(); i++) {
            Course currentCourse = courses.get(i);
            if (currentCourse.getCourseId().equals(courseId) && currentCourse.getCourseSectionNum() == section) {
                found = true;
                System.out.println("********** Course Details **********");
                System.out.println("Course Name: " + currentCourse.getCourseName());
                System.out.println("Course ID: " + currentCourse.getCourseId());
                System.out.println("Instructor: " + currentCourse.getCourseInstructor());
                System.out.println("Section Number: " + currentCourse.getCourseSectionNum());
                System.out.println("Location: " + currentCourse.getLocation());
                System.out.println("Maximum Students: " + currentCourse.getMaxNum());
                System.out.println("Current Registered: " + currentCourse.getCurrentRegisteredNum());
                System.out.println("Registered Students: ");

                ArrayList<String> students = currentCourse.getRegisteredStudents();
                if (students == null || students.isEmpty()) {
                    System.out.println("- No students registered yet.");
                } else {
                    for (String s : students) {
                        System.out.println("- " + s);
                    }
                }
                System.out.println("************************************");
                return;
            }
        }

        if (!found) {
            System.out.println("Error: Course with ID " + courseId + " and section " + section + " not found.");
        }
    }

    // Adds a new student to the system (username must be unique).
    public void registerStudent(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getUsername().equals(username)) {
                System.out.println("Error: Username already exists.");
                return;
            }
        }

        Student newStudent = new Student(username, password, firstName, lastName);
        studentList.add(newStudent);
        System.out.println("Success: Student registered.");
    }

    // Prints all courses with enrollment counts.
    public void viewAllCourses(ArrayList<Course> courses) {
        System.out.println("\n----- All Courses -----");
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            System.out.println(c.getCourseName() + " | " + c.getCourseId() + " | " +
                    "Section " + c.getCourseSectionNum() + " | " +
                    c.getCurrentRegisteredNum() + "/" + c.getMaxNum());
        }
    }

    // Prints only courses that have reached max capacity.
    public void viewFullCourses(ArrayList<Course> courses) {
        System.out.println("----- List of Full Courses -----");
        boolean hasFull = false;

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getCurrentRegisteredNum() >= c.getMaxNum()) {
                System.out.println("Course: " + c.getCourseName() + " | ID: " + c.getCourseId() + " is FULL.");
                hasFull = true;
            }
        }

        if (!hasFull) {
            System.out.println("No courses are currently full.");
        }
        System.out.println("--------------------------------");
    }

    // Prompts for course ID+section and lists enrolled students.
    public void viewStudentsInCourse(ArrayList<Course> courses, Scanner scanner) {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine().trim();
        System.out.print("Enter section number: ");
        int section = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getCourseId().equals(courseId) && c.getCourseSectionNum() == section) {
                System.out.println("\nStudents in " + c.getCourseName() + " (" + c.getCourseId() + "):");
                ArrayList<String> names = c.getRegisteredStudents();
                if (names == null || names.isEmpty()) {
                    System.out.println("- No students registered.");
                } else {
                    for (int j = 0; j < names.size(); j++) {
                        System.out.println("- " + names.get(j));
                    }
                }
                return;
            }
        }
        System.out.println("Course not found.");
    }

    // Prompts for student name and lists all courses they are enrolled in.
    public void viewCoursesByStudent(ArrayList<Course> courses, Scanner scanner) {
        System.out.print("Enter the student's first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter the student's last name: ");
        String lastName = scanner.nextLine().trim();
        String fullName = firstName + " " + lastName;

        System.out.println("----- Courses for Student: " + fullName + " -----");
        boolean found = false;

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            ArrayList<String> students = c.getRegisteredStudents();
            if (students != null && students.contains(fullName)) {
                System.out.println("- " + c.getCourseName() + " (ID: " + c.getCourseId() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("The student " + fullName + " has not registered for any courses yet.");
        }
        System.out.println("---------------------------------------------");
    }

    // Exports full courses to FullCourses.txt.
    public void writeFullCoursesToFile(ArrayList<Course> courses) {
        try {
            FileWriter writer = new FileWriter("FullCourses.txt");

            boolean hasFull = false;
            for (int i = 0; i < courses.size(); i++) {
                Course c = courses.get(i);
                if (c.getCurrentRegisteredNum() >= c.getMaxNum()) {
                    String line = "Full Course: " + c.getCourseName() +
                            " | ID: " + c.getCourseId() +
                            " | Instructor: " + c.getCourseInstructor() + "\n";
                    writer.write(line);
                    hasFull = true;
                }
            }

            writer.close();

            if (hasFull) {
                System.out.println("Success: Full courses have been exported to 'FullCourses.txt'.");
            } else {
                System.out.println("Note: No full courses found. An empty file was created.");
            }

        } catch (IOException e) {
            System.out.println("Error: An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Sorts courses by enrollment count (ascending).
    public void sortCoursesByStudentCount(ArrayList<Course> courses) {
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Integer.compare(c1.getCurrentRegisteredNum(), c2.getCurrentRegisteredNum());
            }
        });

        System.out.println("Success: Courses have been sorted by student number (Ascending).");
    }

}
