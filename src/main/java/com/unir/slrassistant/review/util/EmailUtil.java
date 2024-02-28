package com.unir.slrassistant.review.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendInviteCollaborator(String email, String name, String token, String frontEndUrl) throws MessagingException {

        //Thymeleaf template, see https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#template-layout

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        Context context = new Context();
        context.setVariable("token", token);
        context.setVariable("name", name);
        context.setVariable("frontEndUrl", frontEndUrl);

        String html = templateEngine.process("project/inviteCollaborator", context);

        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Invite Collaborator");
        mimeMessageHelper.setText(html, true);

        javaMailSender.send(mimeMessage);
    }

}
