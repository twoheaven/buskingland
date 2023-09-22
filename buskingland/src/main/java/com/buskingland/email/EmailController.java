package com.buskingland.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmailController {
    
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // 클라이언트로부터 POST 요청을 받아 이메일을 전송하는 엔드포인트
    @PostMapping("/api/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        // 이메일을 보내는 로직
        
        String to = "example@gmail.com"; // 관리자 이메일 주소
        String subject = emailRequest.getSubject();
        String text = emailRequest.getText();

        // EmailService를 사용하여 이메일 전송
        emailService.sendEmail(to, subject, text);

        return "이메일이 성공적으로 전송되었습니다.";
    }
}
