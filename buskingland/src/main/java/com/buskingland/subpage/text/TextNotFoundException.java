package com.buskingland.subpage.text;

// RuntimeException을 상속받아서 사용자 정의 예외 클래스인 TextNotFoundException을 정의합니다.
@SuppressWarnings("serial")
public class TextNotFoundException extends RuntimeException {
    /**
     * 생성자 메서드입니다.
     *
     * @param id  텍스트의 식별자
     */
    public TextNotFoundException(Long id) {
        super("Text not found with id: " + id);
    }
}