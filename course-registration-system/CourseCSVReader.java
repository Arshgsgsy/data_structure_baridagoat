import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Loads course data from a CSV file (e.g. MyUniversityCourses.csv).
public class CourseCSVReader {

    // Parses CSV and returns a list of Course objects. Skips header and malformed rows.
    public static ArrayList<Course> loadCourses(String filePath) {
        ArrayList<Course> courses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine(); // skip header row

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 8) {
                    continue; // skip incomplete rows
                }

                // CSV columns: name, id, max, current, ..., instructor, section, location
                String courseName = values[0].trim();
                String courseId = values[1].trim();
                int maxNum = Integer.parseInt(values[2].trim());
                int currentRegisteredNum = Integer.parseInt(values[3].trim());
                String courseInstructor = values[5].trim();
                int courseSectionNum = Integer.parseInt(values[6].trim());
                String location = values[7].trim();

                Course c = new Course(courseName, courseId, maxNum, currentRegisteredNum, courseInstructor, courseSectionNum, location);

                courses.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }
}
