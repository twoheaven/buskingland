package com.buskingland.subpage.video;

import com.buskingland.subpage.text.Text;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeLink;

    @JsonIgnore
    @ManyToOne
    private Text text;

    /**
     * YouTube 동영상의 링크를 반환합니다.
     *
     * @return YouTube 동영상 링크
     */
    public String getYoutubeLink() {
        return youtubeLink;
    }
    
    /**
     * Video 엔티티의 식별자(ID)를 반환합니다.
     *
     * @return Video 엔티티의 식별자(ID)
     */
    public Long getId() {
        return id;
    }

    /**
     * Video 엔티티의 식별자(ID)를 설정합니다.
     *
     * @param id Video 엔티티의 식별자(ID)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * YouTube 동영상의 링크를 설정합니다.
     *
     * @param youtubeLink YouTube 동영상 링크
     */
    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    /**
     * Video 엔티티가 속한 Text 엔티티를 반환합니다.
     *
     * @return 속한 Text 엔티티
     */
    public Text getText() {
        return text;
    }

    /**
     * Video 엔티티가 속한 Text 엔티티를 설정합니다.
     *
     * @param text 속한 Text 엔티티
     */
    public void setText(Text text) {
        this.text = text;
    }
}