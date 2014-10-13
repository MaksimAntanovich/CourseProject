package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import site.dao.StoryDAO;
import site.dao.UserDAO;
import site.dto.StoryDTO;
import site.entity.Chapter;
import site.entity.Story;
import site.entity.User;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by maxim on 14.10.8.
 */
@Controller
public class StoryController {

    @Autowired
    StoryDAO storyDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    StoryDTO storyDTO;

    @RequestMapping("newstory.htm")
    public String showStoryPage(Model model) throws SQLException{
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        model.addAttribute("user", user);
        model.addAttribute("story", new Story());
        return "story/view";
    }

    @RequestMapping("story.htm")
    public String editStoryPage(Model model,@RequestParam String title) throws SQLException{
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        Story story = storyDAO.getStory(title);
        model.addAttribute("user", user);
        model.addAttribute("story", story);
        return "story/view";
    }

    @RequestMapping(value = "add_story.htm", method = RequestMethod.POST)
    public String addChapter(Model model,@Valid @ModelAttribute("story") Story story,BindingResult result) throws SQLException {
        if (result.hasErrors()) {
            return "redirect: home.htm";
        }
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        story = storyDTO.buildNewStory(story,user);
        storyDAO.addStory(story);
        return "redirect: home.htm";
    }

    @RequestMapping(value = "delete_story.htm")
    public String deleteChapter(Model model,@RequestParam String title) throws SQLException {
        Story story = storyDAO.getStory(title);
        storyDAO.deleteStory(story);
        return "redirect: home.htm";
    }

}
