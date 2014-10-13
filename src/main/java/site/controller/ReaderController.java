package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.dao.StoryDAO;
import site.dao.UserDAO;
import site.entity.Story;
import site.entity.User;

import java.sql.SQLException;

/**
 * Created by maxim on 14.10.13.
 */
@Controller
public class ReaderController {
    @Autowired
    StoryDAO storyDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("read.htm")
    public String readStory(Model model,@RequestParam String title,@RequestParam Integer id)throws SQLException{
        Story story = storyDAO.getStory(title);
        model.addAttribute("story",story);
        model.addAttribute("text",story.getChapters().get(id-1).getText());
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        model.addAttribute("user",user);
        return "commons/read";
    }
}
