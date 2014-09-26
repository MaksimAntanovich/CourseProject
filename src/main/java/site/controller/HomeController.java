package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * Created by maxim on 14.9.23.
 */
@Controller
public class HomeController {
//
//    @Autowired
//    @Qualifier("CategoryDAO")
//    private CategoryDAO categoryDAO;
//
//    @RequestMapping({"", "home.htm" })
//    public String showPage(Model model) throws SQLException {
//        List<Locale.Category> categories = categoryDAO.getAllCategories();
//        model.addAttribute("categories", categories);
//        return "commons/home";
//    }
//
//    @RequestMapping(value = "admin.htm")
//    public String showAdminPage(Model model) {
//        model.addAttribute("message", "Hello, admin!");
//        return "commons/home";
//    }
}