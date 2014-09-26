package site.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import site.dao.UserDAO;
import site.dto.UserDTO;
import site.entity.User;
import site.enumeration.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import site.service.SendMail;
import site.serviceimpl.SendMailImpl;

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

    @Autowired
    private SendMail MailProvider;


    @RequestMapping(value = "add_user.htm", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) throws SQLException {
        if (result.hasErrors()) {
            return "commons/registration";
        }
        user = userDTO.buildNewUser(user, Role.USER.toString());
        userDAO.addUser(user);
        MailProvider.sendMail(user);
        return "redirect: home.htm";
    }
}
