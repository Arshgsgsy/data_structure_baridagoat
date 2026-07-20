import java.io.Serializable;
import java.util.ArrayList;

// Represents a university course with enrollment tracking.
// Serializable for persistence; manages student roster and capacity.
public class Course implements Serializable {

    private String courseName;
    private String courseId;
    private int maxNum;
    private int currentRegisteredNum;
    private ArrayList<String> registeredStudents;
    private String courseInstructor;
    private int courseSectionNum;
    private String location;

    // Creates a course with given details; initializes empty student roster.
    public Course(String courseName, String courseId, int maxNum, int currentRegisteredNum, String courseInstructor, int courseSectionNum, String location) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.maxNum = maxNum;
        this.courseInstructor = courseInstructor;
        this.courseSectionNum = courseSectionNum;
        this.location = location;
        this.currentRegisteredNum = currentRegisteredNum;
        this.registeredStudents = new ArrayList<String>();
    }

    // Returns true if enrollment has reached max capacity.
    public boolean isFull() {
        return currentRegisteredNum >= maxNum;
    }

    // Adds a student by name; returns false if full or already registered.
    public boolean addStudent(String studentName) {
        if (isFull()) {
            return false;
        }
        if (registeredStudents.contains(studentName)) {
            return false;
        }

        registeredStudents.add(studentName);
        currentRegisteredNum++;
        return true;
    }

    // Removes a student by name; returns false if not found.
    public boolean removeStudent(String studentName) {
        if (registeredStudents.contains(studentName)) {
            registeredStudents.remove(studentName);
            currentRegisteredNum--;
            return true;
        }
        else {
            return false;
        }
    }

    // Checks if a student (by full name) is enrolled.
    public boolean containsStudent(String studentName) {
        return registeredStudents.contains(studentName);
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getCurrentRegisteredNum() {
        return currentRegisteredNum;
    }

    // Returns a copy of the registered students list (avoids external modification).
    public ArrayList<String> getRegisteredStudents() {
        return new ArrayList<>(registeredStudents);
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public int getCourseSectionNum() {
        return courseSectionNum;
    }

    public String getLocation() {
        return location;
    }

    // Updates max capacity; fails if new max is less than current enrollment.
    public boolean setMaxNum(int maxNum) {
        if (maxNum >= currentRegisteredNum) {
            this.maxNum = maxNum;
            return true;
        }
        else {
            return false;
        }
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void setCourseSectionNum(int courseSectionNum) {
        this.courseSectionNum = courseSectionNum;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
