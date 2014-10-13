package site.dto;

import site.entity.Chapter;
import site.entity.Story;
import site.entity.User;

import java.sql.SQLException;

/**
 * Created by maxim on 14.9.30.
 */
public interface StoryDTO {
    Story buildNewStory(Story story,User author);

    Story addChapter(Story story,Chapter chapter);
}
