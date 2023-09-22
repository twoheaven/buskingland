package com.buskingland.subpage.text;

import java.util.ArrayList;
import java.util.List;

import com.buskingland.subpage.mainpicture.MainPicture;
import com.buskingland.subpage.subpicture.SubPicture;
import com.buskingland.subpage.video.Video;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Division division; // 팀의 부문을 나타내는 열거형 변수

    private String teamName; // 팀 이름
    private String shortIntro; // 짧은 소개
    private Integer teamMany; // 팀 인원
    private String longIntro; // 긴 소개
    private String portfolio; // 포트폴리오
    private String repertoire; // 레퍼토리
    private String equipment; // 장비 정보

    // 메인사진과 Text를 일대일 관계로 구성함 fetch = FetchType.LAZY
    @OneToOne(mappedBy = "text", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MainPicture mainPicture;

    /**
     * 메인 사진을 설정합니다.
     * 
     * @param mainPicture 설정할 메인 사진 객체
     */
    public void setMainPicture(MainPicture mainPicture) {
        this.mainPicture = mainPicture;
        mainPicture.setText(this);
    }

    /**
     * 메인 사진을 반환합니다.
     * 
     * @return 메인 사진 객체
     */
    public MainPicture getMainPicture() {
        return mainPicture;
    }

    @OneToMany(mappedBy = "text", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubPicture> subPictures = new ArrayList<>();

    // SubPicture 추가 및 삭제 메서드
    /**
     * 서브 사진을 추가합니다.
     * 
     * @param subPicture 추가할 서브 사진 객체
     */
    public void addSubPicture(SubPicture subPicture) {
        subPictures.add(subPicture);
        subPicture.setText(this);
    }

    /**
     * 서브 사진을 제거합니다.
     * 
     * @param subPicture 제거할 서브 사진 객체
     */
    public void removeSubPicture(SubPicture subPicture) {
        subPictures.remove(subPicture);
        subPicture.setText(null);
    }

    /**
     * 서브 사진 목록을 반환합니다.
     * 
     * @return 서브 사진 객체 목록
     */
    public List<SubPicture> getSubPictures() {
        return subPictures;
    }

    @OneToMany(mappedBy = "text", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();

    // Video 추가 및 삭제 메서드
    /**
     * 비디오를 추가합니다.
     * 
     * @param video 추가할 비디오 객체
     */
    public void addVideo(Video video) {
        videos.add(video);
        video.setText(this);
    }

    /**
     * 비디오를 제거합니다.
     * 
     * @param video 제거할 비디오 객체
     */
    public void removeVideo(Video video) {
        videos.remove(video);
        video.setText(null);
    }

    /**
     * 비디오 목록을 반환합니다.
     * 
     * @return 비디오 객체 목록
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * 팀 부문을 반환합니다.
     * 
     * @return 팀 부문 열거형
     */
    public Division getDivision() {
        return division;
    }

    /**
     * 팀 부문을 설정합니다.
     * 
     * @param division 설정할 팀 부문 열거형
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     * 엔터티의 ID를 반환합니다.
     * 
     * @return 엔터티의 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 엔터티의 ID를 설정합니다.
     * 
     * @param id 설정할 엔터티의 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 팀 이름을 반환합니다.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName 팀 이름을 설정합니다.
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return 짧은 소개를 반환합니다.
     */
    public String getShortIntro() {
        return shortIntro;
    }

    /**
     * @param shortIntro 짧은 소개를 설정합니다.
     */
    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    /**
     * @return 팀 인원을 반환합니다.
     */
    public Integer getTeamMany() {
        return teamMany;
    }

    /**
     * @param teamMany 팀 인원을 설정합니다.
     */
    public void setTeamMany(Integer teamMany) {
        this.teamMany = teamMany;
    }

    /**
     * @return 긴 소개를 반환합니다.
     */
    public String getLongIntro() {
        return longIntro;
    }

    /**
     * @param longIntro 긴 소개를 설정합니다.
     */
    public void setLongIntro(String longIntro) {
        this.longIntro = longIntro;
    }

    /**
     * @return 포트폴리오를 반환합니다.
     */
    public String getPortfolio() {
        return portfolio;
    }

    /**
     * @param portfolio 포트폴리오를 설정합니다.
     */
    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    /**
     * @return 레퍼토리를 반환합니다.
     */
    public String getRepertoire() {
        return repertoire;
    }

    /**
     * @param repertoire 레퍼토리를 설정합니다.
     */
    public void setRepertoire(String repertoire) {
        this.repertoire = repertoire;
    }

    /**
     * @return 장비 정보를 반환합니다.
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * @param equipment 장비 정보를 설정합니다.
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    // Setter for subPictures
    /**
     * 서브 사진 목록을 설정합니다.
     * 
     * @param subPictures 설정할 서브 사진 목록
     */
    public void setSubPictures(List<SubPicture> subPictures) {
        this.subPictures = subPictures;
    }

    /**
     * 비디오 목록을 설정합니다.
     * 
     * @param videos 설정할 비디오 목록
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}