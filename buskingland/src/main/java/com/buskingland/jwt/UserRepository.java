package com.buskingland.jwt;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 사용자 이름을 기반으로 사용자 정보 및 권한 정보를 검색합니다.
     *
     * @param username 사용자 이름
     * @return 사용자 정보와 권한 정보가 포함된 Optional 객체
     */
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}

