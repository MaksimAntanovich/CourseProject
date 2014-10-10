package site.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author")
    private User author;

    @OneToMany(mappedBy = "story",fetch = FetchType.EAGER)
    private Set<Chapter> chapters;

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

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }
}
