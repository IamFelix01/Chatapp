package Entity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    @Column(name = "username")
    private String username;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PERMISSION")
    private int permission;

    @Column(name = "LAST_CONNECTION_TIME")
    private Timestamp lastConnectionTime;

    public UsersEntity(){
    }

    public int getId() {
        return iduser;
    }

    public void setId(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public Timestamp getLastConnectionTime() {
        return lastConnectionTime;
    }

    public void setLastConnectionTime(Timestamp lastConnectionTime) {
        this.lastConnectionTime = lastConnectionTime;
    }
    // Constructor, getters, and setters
}
