package com.buskingland.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String nickname;

    /**
     * @return 사용자 이름(username) 반환
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username 설정할 사용자 이름(username)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return 비밀번호(password) 반환
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 설정할 비밀번호(password)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 닉네임(nickname) 반환
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname 설정할 닉네임(nickname)
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
