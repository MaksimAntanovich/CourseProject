package site.dtoimpl;

import org.springframework.stereotype.Service;
import site.dto.StoryDTO;
import site.entity.Story;
import site.entity.User;

/**
 * Created by maxim on 14.9.30.
 */
@Service("StoryDTO")
public class StoryDTOImpl implements StoryDTO {
    @Override
    public Story buildNewStory(Story story, User author) {
        story.setAuthor(author);
        return story;
    }
}
