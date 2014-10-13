package site.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by maxim on 14.10.13.
 */
@Entity
@Table(name = "annotations")
public class Annotation {
    @Id
    @Column(name = "annotation_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "text")
    @GeneratedValue
    private String text;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="author")
    @Fetch(FetchMode.SELECT)
    private User user;

    @ManyToOne(targetEntity = Story.class)
    @JoinColumn(name="story")
    @Fetch(FetchMode.SELECT)
    private Story story;

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
