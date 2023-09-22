package com.buskingland.mainpage.banner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String originalFileName;

    @NotEmpty
    private String storedFilePath;

    private Long fileSize;
    
    private String backcolor;

    /**
     * 원본 파일 이름을 반환합니다.
     *
     * @return 원본 파일 이름
     */
    public String getOriginalFileName() {
        return originalFileName;
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
     * 파일 크기를 반환합니다.
     *
     * @return 파일 크기
     */
    public Long getFileSize() {
        return fileSize;
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
     * 저장된 파일 경로를 반환합니다.
     *
     * @return 저장된 파일 경로
     */
    public String getStoredFilePath() {
        return storedFilePath;
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
     * ID를 반환합니다.
     *
     * @return ID
     */
    public Long getId() {
        return id;
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
     * 배너의 배경색을 반환합니다.
     *
     * @return 배너의 배경색
     */
    public String getBackcolor() {
        return backcolor;
    }

    /**
     * 배너의 배경색을 설정합니다.
     *
     * @param backcolor 설정할 배너의 배경색
     */
    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor;
    }
}