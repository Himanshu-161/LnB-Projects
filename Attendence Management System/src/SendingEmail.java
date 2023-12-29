import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendingEmail {

    static public void SendEmail(String sender , String receiver , String sub, String message){

        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String email = "himanshu16101";
        String password = "plxqpsabnzegghgh";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email,password);
            }
        });
        try{
            Message msg = new MimeMessage(session);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            msg.setFrom(new InternetAddress(sender));
            msg.setSubject(sub);
            msg.setText(message);
            Transport.send(msg);

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}










