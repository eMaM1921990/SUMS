/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author emam
 */
public class MailNotification {
    MD5 m=new MD5();
    String propFileName = "../mail.properties";
    public String getAutAddress() {
        String authaddress=null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("/").toURI().resolve(propFileName).getPath();
            
            Properties prop = new Properties();

            prop.load(new FileInputStream(path));
            authaddress=prop.getProperty(prop.getProperty("AutAddress"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authaddress;
    }
    
    
    public String getAutPassword() {
        String authaddress=null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("/").toURI().resolve(propFileName).getPath();
            
            Properties prop = new Properties();

            prop.load(new FileInputStream(path));
            authaddress=prop.getProperty(prop.getProperty("AutPassword"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authaddress;
    }
    
    public String getsmtpServer() {
        String authaddress=null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("/").toURI().resolve(propFileName).getPath();
            
            Properties prop = new Properties();

            prop.load(new FileInputStream(path));
            authaddress=prop.getProperty(prop.getProperty("smtpserver"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authaddress;
    }
    
    
    public String getSMTPPort() {
        String authaddress=null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("/").toURI().resolve(propFileName).getPath();
            
            Properties prop = new Properties();

            prop.load(new FileInputStream(path));
            authaddress=prop.getProperty(prop.getProperty("smtppot"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authaddress;
    }
    
    public void ActivationMail(String username,String mail,String id,String url){
        m.getMD5Password(id);
        try {
            final String authAddress = getAutAddress();
            final String authPassword = getAutPassword();
            final String smtpServer = getsmtpServer();
            final String smtpPort = getSMTPPort();
            String to = mail;

            String sender = "Info-" + getAutAddress();
            String subject = "Confirmation";
            String message = "Please confirm your registration "+url+m.getMD5Password(id);
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpServer);
            props.put("mail.smtp.port", smtpPort);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            Session sessionMail = Session.getInstance(props, new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(authAddress, authPassword);
                }
            });

            sessionMail.setDebug(true);

            // create a message
            MimeMessage msg = new MimeMessage(sessionMail);

            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(authAddress);
            msg.setFrom(addressFrom);
            InternetAddress[] addressTo = new InternetAddress[1];
            addressTo[0] = new InternetAddress(to);
            msg.setRecipients(Message.RecipientType.TO, addressTo);

            // Setting the Subject and Content Type
            msg.setSubject(subject, "UTF-8");
            msg.setContent(message, "text/html;charset=UTF-8");
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
