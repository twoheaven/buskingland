package com.buskingland.mainpage.recruit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String youtubeLink;

    /**
     * 엔티티의 식별자(ID)를 반환합니다.
     *
     * @return 식별자(ID)
     */
    public Long getId() {
        return id;
    }

    /**
     * 엔티티의 식별자(ID)를 설정합니다.
     *
     * @param id 식별자(ID)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * YouTube 링크를 반환합니다.
     *
     * @return YouTube 링크
     */
    public String getYoutubeLink() {
        return youtubeLink;
    }

    /**
     * YouTube 링크를 설정합니다.
     *
     * @param youtubeLink YouTube 링크
     */
    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}