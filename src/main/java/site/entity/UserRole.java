package site.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


/**
 * Created by maxim on 14.9.21.
 */
@Entity
@Table(name = "roles")
public class UserRole {
    @Id

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
