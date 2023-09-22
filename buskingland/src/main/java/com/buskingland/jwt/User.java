package com.buskingland.jwt;

import java.util.Collections;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Long userId;
        private String username;
        private String password;
        private String nickname;
        private boolean activated;
        private Set<Authority> authorities;

        private UserBuilder() {
            // UserBuilder의 private 생성자
        }

        public UserBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserBuilder activated(boolean activated) {
            this.activated = activated;
            return this;
        }

        public UserBuilder authorities(Set<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public UserBuilder authority(Authority authority) {
            this.authorities = Collections.singleton(authority);
            return this;
        }

        public User build() {
            User user = new User();
            user.userId = this.userId;
            user.username = this.username;
            user.password = this.password;
            user.nickname = this.nickname;
            user.authorities = this.authorities;
            user.activated = this.activated;
            return user;
        }
    }

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    // Getters and setters

    /**
     * @return 사용자 아이디(userId) 반환
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId 사용자 아이디(userId) 설정
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 사용자 이름(username) 반환
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username 사용자 이름(username) 설정
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
     * @param password 비밀번호(password) 설정
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
     * @param nickname 닉네임(nickname) 설정
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return 활성화 여부(activated) 반환
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * @param activated 활성화 여부(activated) 설정
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    /**
     * @return 권한(authorities) 목록 반환
     */
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities 권한(authorities) 목록 설정
     */
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}