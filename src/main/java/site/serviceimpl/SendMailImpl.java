package site.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import site.entity.User;
import site.service.SendMail;

/**
 * Created by maxim on 14.9.24.
 */
public class SendMailImpl implements SendMail {

    private JavaMailSenderImpl mailSender;

    private SimpleMailMessage templateMessage;

    @Override
    public void sendMail(User user){
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(user.getEmail());
        msg.setText(
                "Dear " + user.getLogin()
                        + ", welcome. Please verify your email ");
        this.mailSender.send(msg);
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
}
