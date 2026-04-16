import java.io.Serializable;

// Abstract base class for Admin and Student users.
// Demonstrates: abstract class, method overloading, encapsulation.
public abstract class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Default constructor
    public User() {
        this.username = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
    }

    // Overloaded constructor with username and password only
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = "";
        this.lastName = "";
    }

    // Full parameterized constructor
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof User)) return false;
        User otherUser = (User) o;
        return this.username != null && this.username.equals(otherUser.username);
    }

    // Abstract method - subclasses must implement their own menu
    public abstract void displayMenu();
}
