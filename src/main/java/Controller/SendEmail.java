package Controller;



import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SendEmail {

    public void SendEmail(String email, String userName,String sub, String text,String action) {

        final String username = "shop.coin.test2@gmail.com";
        final String password = "enivxsngxslqoqcx";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shop.coin.test2@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(sub);
            
            if("register".equals(action)) {
            	 message.setContent("Dear "+userName+", <br>"+text,"text/html");
            }
            if("changePass".equals(action)) {
            	message.setContent("Dear "+userName+", <br>"
            +"this is the link to <a href=http://localhost:8088/Shop_Coin_Web/GetToken?Token="+text+">Change Password</a>","text/html");
            }
           

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}