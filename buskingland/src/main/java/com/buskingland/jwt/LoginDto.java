package com.buskingland.jwt;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    // 사용자명, 최소 3자에서 최대 50자여야 합니다.
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    // 비밀번호, 최소 3자에서 최대 100자여야 합니다.
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    /**
     * 사용자명을 반환합니다.
     *
     * @return 사용자명
     */
    public String getUsername() {
        return username;
    }

    /**
     * 사용자명을 설정합니다.
     *
     * @param username 사용자명
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 비밀번호를 반환합니다.
     *
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * 비밀번호를 설정합니다.
     *
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }
}