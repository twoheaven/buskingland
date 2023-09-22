package com.buskingland.email;

public class EmailRequest {

    private String to;       // 이메일 수신자 주소
    private String subject;  // 이메일 제목
    private String text;     // 이메일 본문

    // Getter 및 Setter 메서드
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}