package com.example.mvc;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	// 1.登入 Google
	// 2.啟用二階段驗證(網址如下)
	// https://myaccount.google.com/security
	private static final String username = "xxxx@gmail.com"; // 你的 Gmail 郵箱
	// 3.設定應用程式密碼(網址如下)
	// https://myaccount.google.com/apppasswords
	private static final String password = "xxxx xxxx xxxx xxxx"; // 二階段應用專用密碼
    
	public static void main(String[] args) {
		// 4.設定收件人信箱
		String to = "xxx@gmail.com"; // 收件人電子郵件地址
        String emailHeader = "我的測試信件"; // Email 標題
        String emailContent = "這是我用 Java 寫的測試信件"; // Email 內文
        send(to, emailHeader, emailContent);
	}
	
	public static void send(String to, String emailHeader, String emailContent) {
        // Gmail 服務器的設置
        String host = "smtp.gmail.com";
        
        // 設置郵件屬性
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // 啟用 TLS 加密

        // 創建會話
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 創建郵件消息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(emailHeader);
            message.setText(emailContent);

            // 發送郵件
            Transport.send(message);
            System.out.println("信件傳送成功!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	
	
}
