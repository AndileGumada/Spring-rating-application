package com.andile.votingappbackend.service;

import com.andile.votingappbackend.exception.ActivationException;
import com.andile.votingappbackend.model.NotificationEmail;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MailService {
    JavaMailSender javaMailSender;
    MailBuilder mailBuilder;

    @Async
    void sendEmail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("activation@redditclone.com");
            messageHelper.setTo(notificationEmail.getRecepient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailBuilder.build(notificationEmail.getBody()));
        };
        try {
            javaMailSender.send(messagePreparator);
            System.out.println("Activation Email Sent");
        } catch (MailException e) {
            throw new ActivationException("Error sending activation email to " + notificationEmail.getRecepient());
        }
    }
}
