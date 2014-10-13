package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import site.dao.StoryDAO;
import site.dto.StoryDTO;
import site.entity.Chapter;
import site.dao.ChapterDAO;
import site.entity.Story;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by maxim on 14.10.3.
 */
@Controller
public class ChapterController {
    public String Storytitle;
    @RequestMapping("newchapter.htm")
    public String showStoryPage(Model model,@RequestParam String title)throws SQLException{
        Story story = storyDAO.getStory(title);
        Chapter chapter = new Chapter();
        chapter.setStory(story);
        story = storyDTO.addChapter(story,chapter);
        model.addAttribute("chapter", chapter);
        model.addAttribute("story", story);
        chapter.setStory(story);
        Storytitle = title;
        return "chapter/edit";
    }

    @RequestMapping("chapter.htm")
    public String showChapter(Model model,@RequestParam String title)throws SQLException{
        Story story = storyDAO.getStory(title);
        Chapter chapter = chapterDAO.findChapter(title);
        model.addAttribute("chapter", chapter);
        model.addAttribute("story", story);
        return "chapter/edit";
    }

    @Autowired
    @Qualifier("ChapterDAO")
    ChapterDAO chapterDAO;

    @Autowired
    StoryDAO storyDAO;

    @Autowired
    StoryDTO storyDTO;

    @RequestMapping(value = "add_chapter.htm", method = RequestMethod.POST)
    public String addChapter(@Valid @ModelAttribute Chapter chapter, Model model) throws SQLException {
        Story story = storyDAO.getStory(Storytitle);
        chapter.setStory(story);
        if(chapterDAO.findChapter(chapter.getTitle()) != null)
            chapterDAO.updateChapter(chapter);
        else
            chapterDAO.addChapter(chapter);
        return "redirect: home.htm";
    }

    @RequestMapping(value = "delete_chapter.htm")
    public String addChapter(@RequestParam String title,Model model) throws SQLException {

        Chapter chapter = chapterDAO.findChapter(title);
        chapterDAO.deleteChapter(chapter);
        return "redirect: home.htm";
    }
}
