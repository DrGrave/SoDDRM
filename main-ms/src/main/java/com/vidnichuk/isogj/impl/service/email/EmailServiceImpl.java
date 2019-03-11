package com.vidnichuk.isogj.impl.service.email;

import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:mail.properties")
public class EmailServiceImpl implements EmailService {

    @Value("${mail.confirm.subject}")
    private String confirmEmailSubject;

    @Value("${mail.confirm.text}")
    private String confirmEmailText;

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendConfirmationEmail(TempUser tempUser) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(tempUser.getEmail());
            helper.setSubject(confirmEmailSubject);
            helper.setText(String.format(confirmEmailText, tempUser.getConfirmLink()), true);
        } catch (MessagingException e) {
            throw new RuntimeException();
        }
        javaMailSender.send(message);
    }
}
