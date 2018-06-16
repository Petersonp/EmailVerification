/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificationemail;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Patrick
 */
public class Model {

    int accountCount = 0;
    Account[] accounts = new Account[100];
    FileHelper helper = new FileHelper();
    final public String seperator = "| || || |_";

    Model() {
        String lines[] = helper.readAccounts();
        this.accountCount = lines.length;
        System.out.println(accountCount);
        for (int i = 0; i < accountCount; i++) {
            accounts[i] = new Account();
            String information[] = lines[i].split(seperator);
            // username, password, email
            accounts[i].setUsername(information[0]);
            accounts[i].setPassword(information[1]);
            accounts[i].setEmail(information[2]);
        }
    }
    boolean sameWord(String word1, String word2) {
        boolean confirm = true;
        if ((int) word1.length() != (int) word2.length()) {
            confirm = false;
        } else {
            for (int i = 0; i < word1.length(); i++) { 
                if ((char) word1.charAt(i) != (char) word2.charAt(i)) {
                    confirm = false;
                    //System.out.println((char) Pass.charAt(i) + " != " + (char) CPass.charAt(i));
                }
            }
        }
        return confirm;
    }
    String getSeperator(){
        return seperator;
    }

    void signUp(String username, String password, String email) {
        System.out.println("Signed up");
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(getHash(password.getBytes()));
        account.setEmail(email);
        accounts[accountCount] = account;
        accountCount++;
        helper.writeAccounts(getAccounts());
        System.out.println("Finished Signed Up");

    }

    boolean isMatch(String name, int index) {
        boolean avaliable = false;
        String lines[] = helper.readAccounts();
        for (int i = 0; i < accountCount; i++) {
            String information[] = lines[i].split(seperator);
            if (sameWord(name,information[index])) avaliable = true;
        }
        return avaliable;
    }

    String[] getAccounts() {
        //System.out.println("Sending Accounts...");
        String[] tmpAct = new String[accountCount];
        for (int i = 0; i < accountCount; i++) {
            tmpAct[i] = accounts[i].toFile();
        }
        
        return tmpAct;
    }

    public static String getHash(byte[] inputBytes) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD2");
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (Exception e) {
            System.out.println(e);
        }
        return hashValue;
    }

    public void sendEmail(String email, String code) {
        
        final String username = "noreplymcdelivery@gmail.com";
        final String password = "mcdelivery";
        
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
            message.setFrom(new InternetAddress("noreplymcdelivery@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Email Verification");
            message.setText(code);
            System.out.println("Sending Email");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email Sent");
        
    }
    
    public String createCode(){
        String tmpstring = "";
        for (int i = 0; i < 5; i++){
            Random rand = new Random();
            int di = rand.nextInt(2);
            tmpstring += (char)(((di*17)+48)+(rand.nextInt((di*16)+10)));
            }
        return tmpstring;
    }
}
