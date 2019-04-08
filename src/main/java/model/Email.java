package model;

import config.Config;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author raj
 */
public class Email {
    
    private String emailDestinatario;
    private String assunto;
    private Object msg;

    public Email(String emailDestinatario, String assunto, Object msg) {
        this.emailDestinatario = emailDestinatario;
        this.assunto = assunto;
        this.msg = msg;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public boolean enviarEmail() {
        Properties props = new Properties();

        props.put("mail.smtp.host", Config.EMAIL_SMTP);
        props.put("mail.smtp.socketFactory.port", Config.EMAIL_PORT);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", Config.EMAIL_PORT);

        Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Config.EMAIL_USER, Config.EMAIL_PASS);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Config.EMAIL_FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.emailDestinatario));

            message.setSubject(this.assunto);
            message.setContent(this.msg, "text/html; charset=utf-8");

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
