package com.buskingland.mainpage.recommend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 추천 정보를 저장하는 엔티티 클래스입니다.
 */
@Entity
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String id1, id2, id3, id4, id5, id6;

    // Getter와 Setter 메서드는 Lombok의 @Getter와 @Setter 어노테이션을 사용하여 자동 생성 가능합니다.
    
    /**
     * 엔티티의 고유 ID를 반환합니다.
     *
     * @return 엔티티의 고유 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 엔티티의 고유 ID를 설정합니다.
     *
     * @param id 엔티티의 고유 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 추천 ID 1을 반환합니다.
     *
     * @return 추천 ID 1
     */
    public String getId1() {
        return id1;
    }

    /**
     * 추천 ID 1을 설정합니다.
     *
     * @param id1 추천 ID 1
     */
    public void setId1(String id1) {
        this.id1 = id1;
    }

    /**
     * 추천 ID 2를 반환합니다.
     *
     * @return 추천 ID 2
     */
    public String getId2() {
        return id2;
    }

    /**
     * 추천 ID 2를 설정합니다.
     *
     * @param id2 추천 ID 2
     */
    public void setId2(String id2) {
        this.id2 = id2;
    }

    /**
     * 추천 ID 3을 반환합니다.
     *
     * @return 추천 ID 3
     */
    public String getId3() {
        return id3;
    }

    /**
     * 추천 ID 3을 설정합니다.
     *
     * @param id3 추천 ID 3
     */
    public void setId3(String id3) {
        this.id3 = id3;
    }

    /**
     * 추천 ID 4를 반환합니다.
     *
     * @return 추천 ID 4
     */
    public String getId4() {
        return id4;
    }

    /**
     * 추천 ID 4를 설정합니다.
     *
     * @param id4 추천 ID 4
     */
    public void setId4(String id4) {
        this.id4 = id4;
    }

    /**
     * 추천 ID 5를 반환합니다.
     *
     * @return 추천 ID 5
     */
    public String getId5() {
        return id5;
    }

    /**
     * 추천 ID 5를 설정합니다.
     *
     * @param id5 추천 ID 5
     */
    public void setId5(String id5) {
        this.id5 = id5;
    }

    /**
     * 추천 ID 6를 반환합니다.
     *
     * @return 추천 ID 6
     */
    public String getId6() {
        return id6;
    }

    /**
     * 추천 ID 6를 설정합니다.
     *
     * @param id6 추천 ID 6
     */
    public void setId6(String id6) {
        this.id6 = id6;
    }
}