package site.dto;

import site.entity.Story;
import site.entity.User;

/**
 * Created by maxim on 14.9.30.
 */
public interface StoryDTO {
    Story buildNewStory(Story story,User author);
}
