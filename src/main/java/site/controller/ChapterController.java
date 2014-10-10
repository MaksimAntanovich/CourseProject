package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import site.entity.Chapter;
import site.dao.ChapterDAO;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by maxim on 14.10.3.
 */
@Controller
public class ChapterController {
    @RequestMapping("newchapter.htm")
    public String showStoryPage(Model model){
        model.addAttribute("chapter", new Chapter());
        return "chapter/edit";
    }

    @Autowired
    @Qualifier("ChapterDAO")
    ChapterDAO chapterDAO;

    @RequestMapping(value = "add_chapter.htm", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute Chapter chapter, BindingResult result, Model model) throws SQLException {
        if (result.hasErrors()) {
            return "redirect: home.htm";
        }
        chapterDAO.addChapter(chapter);
        return "redirect: home.htm";
    }
}
