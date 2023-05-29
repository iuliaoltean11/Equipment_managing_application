package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Echipament;
import com.ulbs.deposit.entity.Email;
import jakarta.annotation.PostConstruct;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class MailService {

    @Autowired
    IEchipamenteService echipamenteService;

    @Autowired
    IEmailService emailService;
    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    @Value("${email.smtp.host}")
    private String smtpHost;

    @Value("${email.smtp.port}")
    private String smtpPort;

    @Value("${email.smtp.auth}")
    private String smtpAuth;

    @Value("${email.smtp.socketFactory.port}")
    private String smtpSocketFactoryPort;

    @Value("${email.smtp.socketFactory.class}")
    private String smtpSocketFactoryClass;

    private static Boolean expired = false;

    //@Scheduled(cron = "0 0 8 * * *") // everyday, at 8 in the morning
    @PostConstruct
    public void sendEmail() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", smtpHost);
        prop.put("mail.smtp.port", smtpPort);
        prop.put("mail.smtp.auth", smtpAuth);
        prop.put("mail.smtp.socketFactory.port", smtpSocketFactoryPort);
        prop.put("mail.smtp.socketFactory.class", smtpSocketFactoryClass);

        List<Echipament> echipamente = echipamenteService.getAllEchipamente();
        String messageBody = "Draga administrator, \n\n urmatoarele echipamente trebuie schimbate: \n";

// Get today's date
        LocalDate today = LocalDate.now();

        for (Echipament echipament : echipamente) {
            LocalDate dataExpirare = echipament.getDataSchimbare().toLocalDate();
            if (dataExpirare != null && dataExpirare.equals(today)) {
                expired = true;
                messageBody += echipament.getNumeEchipament() + " " + echipament.getAmplasare() + " " + echipament.getCladire().getNumeCladire() + "\n";
            }
        }

        if (expired) {
            List<Email> emailList = emailService.getAllEmails();
            String emailString = "";
            for (Email email: emailList) {
                emailString += email.getAdresaEmail() + ", ";
            }

            Session session = Session.getInstance(prop,
                    new jakarta.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(emailString)
                );
                message.setSubject("Depozit ULBS");
                message.setText(messageBody);

                Transport.send(message);
                expired = false;
                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
