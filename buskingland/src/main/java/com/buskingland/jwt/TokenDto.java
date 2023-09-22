package com.buskingland.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {

    private String token;

    /**
     * 토큰(DTO) 객체를 생성합니다.
     *
     * @param token JWT 토큰 문자열
     */
    public TokenDto(String token) {
        this.token = token;
    }

    /**
     * 토큰을 반환합니다.
     *
     * @return JWT 토큰 문자열
     */
    public String getToken() {
        return token;
    }

    /**
     * 토큰을 설정합니다.
     *
     * @param token JWT 토큰 문자열
     */
    public void setToken(String token) {
        this.token = token;
    }
}