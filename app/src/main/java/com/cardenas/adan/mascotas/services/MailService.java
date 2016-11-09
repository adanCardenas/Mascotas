package com.cardenas.adan.mascotas.services;

import android.util.Log;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Created by adan_ on 05/11/2016.
 */

public class MailService {
    private String correoRemitente;
    private String nombreRemitente;
    private String comentario;

    public MailService(String correoRemitente,String nombreRemitente, String comentario) {
        this.nombreRemitente=nombreRemitente;
        this.correoRemitente=correoRemitente;
        this.comentario=comentario;
    }

    public void sendEmail() throws AddressException, MessagingException {
        String host = "smtp.gmail.com";
        String address = "adan0adn@gmail.com";
        String from = "fromaddress@gmail.com";
        String pass = "";//Para probar pon tu password
        String to="adan0adn@gmail.com";

        Multipart multiPart;
        String finalString="";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", address);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        Log.i("Mail", "Propiedades seteadas");

        Session session = Session.getDefaultInstance(props, null);
        DataHandler handler=new DataHandler(new ByteArrayDataSource(finalString.getBytes(),"text/plain" ));
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(correoRemitente));
        message.setDataHandler(handler);
        Log.i("Mail", "Sesion seteada");
        multiPart=new MimeMultipart();
        InternetAddress toAddress;
        toAddress = new InternetAddress(to);
        message.addRecipient(Message.RecipientType.TO, toAddress);
        Log.i("Mail", "Agregando destino...");
        message.setSubject("Send Auto-Mail");
        message.setContent(multiPart);
        message.setText("Demo For Sending Mail in Android Automatically");
        Log.i("check", "transport");
        Transport transport = session.getTransport("smtp");
        Log.i("check", "connecting");
        transport.connect(host,address , pass);
        Log.i("check", "wana send");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close(); Log.i("check", "sent");
    }
}
