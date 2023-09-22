package com.buskingland.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원 가입 요청 처리
     * @param userDto 사용자 정보 DTO
     * @return ResponseEntity<User> 회원 가입 결과
     */
    @PostMapping("/signup")
    public ResponseEntity<User> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    /**
     * 내 정보 조회 요청 처리
     * @return ResponseEntity<User> 내 정보 조회 결과
     */
    @GetMapping("/user/get")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    /**
     * 특정 사용자 정보 조회 요청 처리
     * @param username 조회할 사용자의 이름
     * @return ResponseEntity<User> 조회 결과
     */
    @GetMapping("/user/get/{username}")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
    	if (!hasAdminRole()) {
            // 권한이 없는 경우 처리
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        // 권한이 있는 경우 사용자 정보 반환
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
    
    /**
     * 현재 사용자가 관리자 권한을 가지고 있는지 확인
     * @return boolean 현재 사용자가 관리자 권한을 가지고 있는지 여부
     */
    public boolean hasAdminRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
            .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}
