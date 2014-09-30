package site.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by maxim on 14.9.27.
 */
@Entity

public class Story {
    @Id
    @Column(name = "story_id")
    @GeneratedValue
    private Integer id;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author")
    private User author;

    @OneToMany(mappedBy = "story",fetch = FetchType.LAZY)
    private List<Chapter> chapters;


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
}
