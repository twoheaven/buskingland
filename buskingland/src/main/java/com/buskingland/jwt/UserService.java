package com.buskingland.jwt;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 새로운 사용자를 가입시키는 메소드.
     *
     * @param userDto 가입할 사용자의 정보를 담은 DTO 객체
     * @return 가입한 사용자의 정보
     */
    @Transactional
    public User signup(UserDto userDto) {
        // 이미 가입되어 있는 사용자인지 확인
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        // 권한 정보 생성 (ROLE_USER)
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        // 사용자 정보 생성 및 저장
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    /**
     * 사용자 이름을 기반으로 사용자와 권한 정보를 조회하는 메소드.
     *
     * @param username 조회할 사용자의 이름
     * @return 사용자와 권한 정보가 포함된 Optional 객체
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    /**
     * 현재 로그인한 사용자의 이름을 기반으로 사용자와 권한 정보를 조회하는 메소드.
     *
     * @return 현재 로그인한 사용자와 권한 정보가 포함된 Optional 객체
     */
    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}