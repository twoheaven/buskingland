package com.buskingland.mainpage.recommend;

/**
 * 추천 정보를 찾을 수 없을 때 발생하는 예외 클래스입니다.
 */
@SuppressWarnings("serial")
public class RecommendNotFoundException extends RuntimeException {

    /**
     * 예외 메시지를 포함한 예외를 생성합니다.
     *
     * @param message 예외 메시지
     */
    public RecommendNotFoundException(String message) {
        super(message);
    }
}