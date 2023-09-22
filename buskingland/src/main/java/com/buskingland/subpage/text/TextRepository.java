package com.buskingland.subpage.text;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TextRepository extends JpaRepository<Text, Long>, JpaSpecificationExecutor<Text> {
	
    /**
     * 모든 Text 엔티티를 페이징하여 조회합니다.
     *
     * @param pageable 페이징 정보를 나타내는 Pageable 객체
     * @return 페이징된 Text 엔티티의 페이지
     */
    Page<Text> findAll(Pageable pageable);
}