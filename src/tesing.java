

import com.sun.mail.pop3.POP3SSLStore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Properties;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Session;

class testing {

    public static void main(String[] args)  {

        Properties props = new Properties();

        String host = "pop.mail.ru";
        String provider = "pop3";
        final String PORT = "995";
        String username = "goleshov@list.ru";
        String pass = "holeshov";
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.setProperty("mail.pop3.ssl.trust", "*");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", PORT);
        props.setProperty("mail.pop3.socketFactory.port", PORT);

        URLName urln = new URLName(provider, host, Integer.parseInt(PORT), null, username, pass);

        Session session = Session.getInstance(props,  null);


        POP3SSLStore store = new POP3SSLStore(session, urln);
       // Store store = session.getStore(urln);
        try {
            store.connect();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        Folder inbox = null;
        try {
            inbox = store.getFolder("INBOX");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (inbox == null) {
           System.out.println("No INBOX");
            System.exit(1);
        }
        try {
            inbox.open(Folder.READ_ONLY);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        Message[] messages = new Message[0];
        try {
            messages = inbox.getMessages();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //  for (int i = 0; i < 1; i++) {
        int i=906;
            System.out.println("Message " + (i + 1));
           File newFile=new File("F:\\test\\"+i+".txt");
        try {
            PrintWriter printWriter=new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //  printWriter.write(

         //
           System.out.println(messages[i].toString());

          //  messages[i].writeTo(System.out);
     //  }
        try {
            inbox.close(false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


