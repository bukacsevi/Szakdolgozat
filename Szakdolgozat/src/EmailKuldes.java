import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;
import javax.activation.*;
import javax.swing.JOptionPane;
import newpackage.Cimzett;
import newpackage.Vevő;

public class EmailKuldes
{
final String senderEmailID = "goo.supp.goo";
final String senderPassword = "Evievi784";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";
String receiverEmailID = null;
static String emailSubject;
static String emailBody;
static Cimzett cimzett;
public EmailKuldes(Cimzett cimzett, String csatolmany)
{
this.cimzett=cimzett;    
this.receiverEmailID=cimzett.getEmail();
this.emailSubject="Árajánlat";
this.emailBody="Árajánlat elküldve!";
Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", emailServerPort);
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");
SecurityManager security = System.getSecurityManager();
try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
setFileAsAttachment(msg,csatolmany);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
Transport.send(msg);
JOptionPane.showMessageDialog(null, "Email elküldve!");
}
catch (Exception mex)
{
    JOptionPane.showMessageDialog(null, "Hibás e-mail cím!");
mex.printStackTrace();
   
}
}
public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}
public static void setFileAsAttachment(Message msg, String filename)throws MessagingException {
 
        // Első rész létrehozása és kitöltése
        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText("Tisztelt "+cimzett.getNev()+"!");
 
        // Második rész létrehozása és kitöltése
        MimeBodyPart p2 = new MimeBodyPart();
        
        // Betesszük a fájlt a második részbe
        FileDataSource fds = new FileDataSource(filename);
        p2.setDataHandler(new DataHandler(fds));
        p2.setFileName(fds.getName());
 
        // Multipart létrehozása. A törzsrészeket hozzáadjuk.
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);
 
        // Beállítjuk a Multipart-ot üzenet tartalmának
        msg.setContent(mp);
    }
/*public static void main(String[] args)
{     
MailSender mailSender=new
MailSender("bukacsevi@gmail.com",emailSubject,emailBody,"C:/a.docx");
}*/
}