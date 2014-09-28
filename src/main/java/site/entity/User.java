package site.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by maxim on 14.9.21.
 */
@Entity
@Table(name = "users")
public class User {
    @Id

    @Column(name = "login")
    @NotEmpty
    @Size(min = 5, max = 20)
    private String login;

    @Column(name = "email")
    @NotEmpty
    @Size(min = 3, max = 60)
    private String email;

    @Column(name = "password")
    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @ManyToOne(targetEntity = UserRole.class)
    @JoinColumn(name = "role")
    private UserRole role;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Story> stories;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
