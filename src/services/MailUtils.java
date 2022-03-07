/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author nadee ben cheikh
 */
public class MailUtils {
    public static void SendMail(String recepient, String username) throws MessagingException{
        Properties pr = new Properties();
        
  
        pr.put("mail.smtp.auth","true");
        pr.put("mail.smtp.starttls.enable","true");
        pr.put("mail.smtp.host","smtp.gmail.com");
        pr.put("mail.smtp.port","587");
        
        String email = "realityvisionisamm@gmail.com";
        String pass = "p4Q7Pr$GrRJG6Y9D";
        
          Session session  = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(email, pass);
            }
        });
          
          Message msg = prepareMessage(session,email,recepient,username);
          Transport.send(msg);
          System.out.println("Message envoyer");
    }

    private static Message prepareMessage(Session session, String email,String recepient,String username) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject("Welcome to Esplay !");
            msg.setText("Hi! "+username+" You're now part of a community that connects patient gamers with Esplay"
                    + " application. \n Discover our current games and wait for stay tuned for more updates.. \"");
               return msg;
                    
                    } catch (MessagingException ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    public static void sendmail2(String recipient, String password) throws MessagingException{
        Properties pr = new Properties();
    pr.put("mail.smtp.auth", "true");
    pr.put("mail.smtp.starttls.enable", "true");
    pr.put("mail.smtp.host", "smtp.gmail.com");
    pr.put("mail.smtp.port", "587");
    
    String email = "realityvisionisamm@gmail.com";
    String pass = "p4Q7Pr$GrRJG6Y9D";
    
    Session session  = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication(email, pass);          
            }    
});
    
    Message message = prepareMessage2(session,email,recipient,password);
    Transport.send(message);
        System.out.println("message envoyé");
    }

    private static Message prepareMessage2( Session session, String email,String recipient,String password ) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)) ;
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
            message.setSubject("New password");
            message.setText("Hi  your new password = "+password );
      return message;
        } catch (MessagingException ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return null; 
    }    
    
}
