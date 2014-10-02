package site.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by maxim on 14.9.26.
 */
@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @Column(name = "chapter_id")
    @GeneratedValue
    private Integer id;


    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "text")
    @NotEmpty
    private String text;

    @ManyToOne(targetEntity = Story.class,cascade = CascadeType.ALL)
    @JoinColumn(name="story")
    private Story story;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}

