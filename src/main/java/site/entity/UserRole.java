package site.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * Created by maxim on 14.9.21.
 */
@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
