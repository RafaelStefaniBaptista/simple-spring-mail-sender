package br.com.cwi.crescer.simple_spring_mail_sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(path = "send", method = RequestMethod.GET)
    public String sendMail() {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter hourMinuteSecondDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String hourMinuteSecondNow = now.format(hourMinuteSecondDateFormatter);

            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
//            helper.setTo("rafael.baptista@cwi.com.br");
            helper.setTo("diogo.araujo@cwi.com.br");
            helper.setSubject("CWI MAIL TEST " + hourMinuteSecondNow);
            helper.setText("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" data-reactroot=\"\" style=\"box-sizing: border-box; font-feature-settings: normal; margin: 0; padding: 0; border: 0; font-weight: normal;\">\n" +
                    "  <head>\n" +
                    "  </head>\n" +
                    "  <body style=\"box-sizing: border-box; font-feature-settings: normal; margin: 0; padding: 0; border: 0; font-weight: normal;\">\n" +
                    "    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#FFFFFF\" class=\"backgroundWhite\" style=\"border-collapse:collapse;border-spacing:0;border:none 0;background-color:#FFFFFF;\">\n" +
                    "       TEST " +
                    "                </table>\n" +
                    "                <style type=\"text/css\">\n" +
                    "                    @media only screen and (max-width: 480px){\n" +
                    "                        table#canspamBar td{font-size:14px !important;}\n" +
                    "                        table#canspamBar td a{display:block !important; margin-top:10px !important;}\n" +
                    "                    }\n" +
                    "                </style>\n" +
                    "            </body>\n" +
                    "</html>", true);
            mailSender.send(mail);

            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
    }
}
