package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.dao.UserDAO;
import site.dao.UserRoleDAO;
import site.entity.User;

import java.sql.SQLException;

/**
 * Created by maxim on 14.10.3.
 */
@Controller
public class UserCabinetController {

    @Autowired
    @Qualifier("UserDAO")
    private UserDAO userDAO;

    @Autowired
    @Qualifier("UserRoleDAO")
    private UserRoleDAO userRoleDAO;


    @RequestMapping("cabinet.htm")
    public String showPage(Model model) throws SQLException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user/cabinet";
    }
}
