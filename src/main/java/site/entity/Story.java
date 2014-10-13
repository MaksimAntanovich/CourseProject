package site.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by maxim on 14.9.27.
 */
@Entity
@Table(name = "stories")
public class Story {
    @Id
    @Column(name = "story_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author")
    private User author;

    @OneToMany(mappedBy = "story",fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Chapter> chapters;

    @OneToMany(mappedBy = "story",fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Annotation> annotations;

    @Column(name = "Rating")
    Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
