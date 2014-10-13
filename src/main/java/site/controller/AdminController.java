package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.dao.UserDAO;
import site.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 14.10.13.
 */
@Controller
public class AdminController {
    @Autowired
    UserDAO userDAO;

    @RequestMapping("admin.htm")
    public String showAdminPage(Model model) throws SQLException{
        List<User> users = userDAO.getAllUsers();
        model.addAttribute("users",users);
        return "admin/cabinet";
    }
}
