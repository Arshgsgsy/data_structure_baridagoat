import java.util.ArrayList;
import java.util.Scanner;

// Entry point for the NYU Course Registration System.
// Handles login flow, menu navigation, and data persistence.
public class Main {

    // File paths for data storage
    private static final String COURSES_CSV_PATH = "MyUniversityCourses.csv";
    private static final String COURSES_SER_PATH = "courses.ser";
    private static final String STUDENTS_SER_PATH = "students.ser";

    // In-memory data stores (loaded from serialized files or CSV)
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Load courses: prefer serialized data, fall back to CSV if none exists
        ArrayList<Course> savedCourses = Serialization.loadCourses(COURSES_SER_PATH);
        if (savedCourses != null) {
            courses = savedCourses;
            System.out.println("Loaded courses from saved data.");
        } else {
            courses = CourseCSVReader.loadCourses(COURSES_CSV_PATH);
            System.out.println("Loaded courses from CSV file.");
        }

        // Load students from serialized file (empty list if first run)
        ArrayList<Student> savedStudents = Serialization.loadStudents(STUDENTS_SER_PATH);
        if (savedStudents != null) {
            students = savedStudents;
            System.out.println("Loaded students from saved data.");
        }

        boolean appRunning = true;
        System.out.println("Welcome to the NYU Course Registration System.");

        // Main loop: show menu and route to admin or student flow
        while (appRunning) {
            System.out.println("\n---------------- MAIN MENU ----------------");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice: ");

            if (!sc.hasNextLine()) {
                break;
            }
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                adminLogin(sc);
            } else if (choice.equals("2")) {
                studentLogin(sc);
            } else if (choice.equals("0")) {
                saveState();
                System.out.println("Goodbye!");
                appRunning = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    // Authenticates admin and runs the admin menu loop.
    private static void adminLogin(Scanner scanner) {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        // Hardcoded admin credentials (Admin / Admin001)
        if (username.equals("Admin") && password.equals("Admin001")) {
            System.out.println("Login Successful!");
            AdminInterface admin = new Admin();

            boolean adminRunning = true;
            while (adminRunning) {
                admin.displayMenu();
                if (!scanner.hasNextLine()) {
                    break;
                }
                String option = scanner.nextLine().trim();

                switch (option) {
                    case "1":
                        admin.viewAllCourses(courses);
                        break;
                    case "2":
                        admin.viewFullCourses(courses);
                        break;
                    case "3":
                        admin.writeFullCoursesToFile(courses);
                        break;
                    case "4":
                        admin.viewStudentsInCourse(courses, scanner);
                        break;
                    case "5":
                        admin.viewCoursesByStudent(courses, scanner);
                        break;
                    case "6":
                        admin.sortCoursesByStudentCount(courses);
                        saveState();
                        break;
                    case "7":
                        admin.createCourse(courses, scanner);
                        saveState();
                        break;
                    case "8":
                        admin.deleteCourse(courses, students, scanner);
                        saveState();
                        break;
                    case "9":
                        admin.editCourse(courses, scanner);
                        saveState();
                        break;
                    case "10":
                        admin.displayCourseInfo(courses, scanner);
                        break;
                    case "11":
                        admin.registerStudent(students, scanner);
                        saveState();
                        break;
                    case "0":
                        adminRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Invalid Admin credentials.");
        }
    }

    // Authenticates student by username/password and runs the student menu loop.
    private static void studentLogin(Scanner scanner) {
        System.out.print("Enter Student Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Student Password: ");
        String password = scanner.nextLine();

        // Look up student in registered students list
        Student foundStudent = null;
        for (Student s : students) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println("Welcome back, " + foundStudent.getFirstName() + "!");
            boolean studentRunning = true;
            while (studentRunning) {
                foundStudent.displayMenu();
                if (!scanner.hasNextLine()) {
                    break;
                }
                String option = scanner.nextLine().trim();
                switch (option) {
                    case "1":
                        foundStudent.viewAllCourses(courses);
                        break;
                    case "2":
                        foundStudent.viewAvailableCourses(courses);
                        break;
                    case "3":
                        foundStudent.registerForCourse(courses, scanner);
                        saveState();
                        break;
                    case "4":
                        foundStudent.withdrawFromCourse(courses, scanner);
                        saveState();
                        break;
                    case "5":
                        foundStudent.viewMyCoursesStudent(
                                foundStudent.getFirstName(), foundStudent.getLastName(), courses);
                        break;
                    case "6":
                        studentRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Error: Student not found. Please register with Admin first.");
        }
    }

    // Persists courses and students to .ser files for next session.
    private static void saveState() {
        boolean coursesSaved = Serialization.saveCourses(COURSES_SER_PATH, courses);
        boolean studentsSaved = Serialization.saveStudents(STUDENTS_SER_PATH, students);
        if (!coursesSaved || !studentsSaved) {
            System.out.println("Warning: Some data may not have been saved.");
        }
    }
}
