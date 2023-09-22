package com.buskingland.subpage.subpicture;

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
public class SubPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String storedFilePath;

    private Long fileSize;
    
    @JsonIgnore
    @ManyToOne
    private Text text;

    /**
     * @return ID를 반환합니다.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return 원본 파일 이름을 반환합니다.
     */
    public String getOriginalFileName() {
        return originalFileName;
    }

    /**
     * @return 저장된 파일 경로를 반환합니다.
     */
    public String getStoredFilePath() {
        return storedFilePath;
    }

    /**
     * @return 파일 크기를 반환합니다.
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * ID를 설정합니다.
     *
     * @param id 설정할 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 원본 파일 이름을 설정합니다.
     *
     * @param originalFileName 설정할 원본 파일 이름
     */
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    /**
     * 저장된 파일 경로를 설정합니다.
     *
     * @param storedFilePath 설정할 저장된 파일 경로
     */
    public void setStoredFilePath(String storedFilePath) {
        this.storedFilePath = storedFilePath;
    }

    /**
     * 파일 크기를 설정합니다.
     *
     * @param fileSize 설정할 파일 크기
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 연관된 텍스트 엔티티를 설정합니다.
     *
     * @param text 설정할 텍스트 엔티티
     */
    public void setText(Text text) {
        this.text = text;
    }	

    /**
     * 연관된 텍스트 엔티티를 반환합니다.
     *
     * @return 연관된 텍스트 엔티티
     */
    public Text getText() {
        return text;
    }
}
