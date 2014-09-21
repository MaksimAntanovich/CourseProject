package controller;

import dao.UserDAO;
import dto.UserDTO;
import entity.User;
import enumeration.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by maxim on 14.9.21.
 */
@Controller
public class RegistrationController {

    @RequestMapping("registration.htm")
    public String showPage(Model model) {
        model.addAttribute("user", new User());
        return "commons/registration";
    }

    @Autowired
    @Qualifier("UserDAO")
    private UserDAO userDAO;

    @Autowired
    private UserDTO userDTO;

    @RequestMapping(value = "add_user.htm", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) throws SQLException {
        if (result.hasErrors()) {
            return "commons/registration";
        }
        user = userDTO.buildNewUser(user, Role.USER.toString());
        userDAO.addUser(user);
        return "redirect: home.htm";
    }

}
