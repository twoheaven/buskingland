package com.buskingland.subpage.text;

import org.springframework.data.jpa.domain.Specification;

public class TextSpecification {
    
    /**
     * 주어진 키워드를 포함하는 Text 엔티티를 검색하기 위한 Specification을 생성합니다.
     *
     * @param keyword 검색어 키워드
     * @return 검색 조건을 정의한 Specification 객체
     */
    public static Specification<Text> textContains(String keyword) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.or(
                criteriaBuilder.like(root.get("equipment"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("longIntro"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("portfolio"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("repertoire"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("shortIntro"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("teamName"), "%" + keyword + "%")
            );
    }
}