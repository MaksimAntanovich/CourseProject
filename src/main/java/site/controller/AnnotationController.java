package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import site.dao.AnnotationDAO;
import site.dao.StoryDAO;
import site.dao.UserDAO;
import site.entity.Annotation;
import site.entity.Story;
import site.entity.User;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by maxim on 14.10.13.
 */
@Controller
public class AnnotationController {

    private User currentUser;
    private String currentTitle;
    @Autowired
    AnnotationDAO annotationDAO;

    @Autowired
    UserDAO  userDAO;

    @Autowired
    StoryDAO storyDAO;

    @RequestMapping("annotate.htm")
    public String addAnnotation(Model model, @RequestParam String title) throws SQLException{
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        currentUser = user;
        currentTitle = title;
        Annotation annotation = annotationDAO.getAnnotation(title,user);
        if(annotation == null)
            annotation = new Annotation();
        model.addAttribute("annotation",annotation);
        return "annotation/edit";
    }

    @RequestMapping(value = "add_annotation.htm", method = RequestMethod.POST)
    public String addChapter( Model model,@ModelAttribute Annotation annotation) throws SQLException {
        Story story = storyDAO.getStory(currentTitle);
        annotation.setStory(story);
        story.getAnnotations().add(annotation);
        annotation.setUser(currentUser);
        currentUser.getAnnotations().add(annotation);
        if(annotationDAO.getAnnotation(currentTitle,currentUser)!= null)
            annotationDAO.updateAnnotation(annotation);
        else
            annotationDAO.addAnnotation(annotation);
        return "redirect: home.htm";
    }
}
