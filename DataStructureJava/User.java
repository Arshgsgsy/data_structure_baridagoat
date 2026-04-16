import Course;

public class User {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private Course[] courses;

    public User(String username, String password, String first_name, String last_name, Course[] courses) {
        setUsername(username);
        setPassword(password);
        setFirst_name(first_name);
        setLast_name(last_name);
        setCourses(courses);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String[] view_courses()

}