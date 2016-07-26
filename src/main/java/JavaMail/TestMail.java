package JavaMail;

import java.util.Random;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Class contains method for sending messages to user
 *
 * @author GrannyPython
 */
public class TestMail {
    static Random rand = new Random();

    /**
     * This method send letter to user email, it is necessary to have
     *
     * @param email of user
     * @return nothing
     */
    public static int generateAndSendEmail(String email) {

        //TODO: Attention! Delete code after release!
        //TODO: Delete TODO after release! =)
        final String username = "";
        final String password = "";


        /**
         * set settings for server
         */
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        //Generating message
        int randomNum;
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("PASSWORD CONFIRMATION");
            randomNum = rand.nextInt((99999 - 0) + 1);
            String emailBody = "You are welcome man, your code is --> " + randomNum + " <-- <br><br> Regards, <br>Andrew Karabaev";
            message.setText(emailBody);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return randomNum;
    }

    /**
     * Method using for changing current password obiously, necessary send info about
     *
     * @param email   here and
     * @param newPass new password
     * @throws MessagingException if user will forget to write email and as caching result we generates
     * @throws RuntimeException
     */
    public static void newPassword(String email, String newPass) {

        //Attention, Secure info. Delete after release
        final String username = "karabaevmb@gmail.com";
        final String password = "aDMe3c9c";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("New Password");
            String emailBody = "New password is --> " + newPass + " <-- <br><br> Regards, <br>Andrew Karabaev";
            message.setText(emailBody);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
