package site.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


/**
 * Created by maxim on 14.9.21.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


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

    @ManyToOne(targetEntity = UserRole.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private UserRole role;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    private Set<Story> stories;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    private List<Annotation> annotations;

    @Column(name = "locked")
    private boolean locked = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Story> getStories() {
        return stories;
    }

    public void setStories(Set<Story> stories) {
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

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
