package site.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by maxim on 14.9.26.
 */
@Entity
public class Chapter {
    @Id

    @Column(name = "Title")
    @NotEmpty
    private String title;

    @Column(name = "Text")
    @NotEmpty
    private String text;

    @ManyToOne(targetEntity = Story.class)
    @JoinTable(name="story")
    private Story story;

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
