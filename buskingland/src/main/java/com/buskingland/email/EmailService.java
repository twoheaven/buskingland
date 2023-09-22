package com.buskingland.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 이메일을 전송하는 메서드
    public void sendEmail(String to, String subject, String text) {
        // SimpleMailMessage 객체를 생성하여 이메일 설정
        SimpleMailMessage message = new SimpleMailMessage();
        
        // 발신자 이메일 주소 설정
        message.setFrom("example@naver.com");
        // 수신자 이메일 주소 설정
        message.setTo(to);
        // 이메일 제목 설정
        message.setSubject(subject);
        // 이메일 본문 설정
        message.setText(text);

        // 이메일을 전송
        mailSender.send(message);
    }
}