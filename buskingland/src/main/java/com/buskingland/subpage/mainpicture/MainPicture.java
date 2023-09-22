package com.buskingland.subpage.mainpicture;

import com.buskingland.subpage.text.Text;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String originalFileName;

    @NotEmpty
    private String storedFilePath;

    private Long fileSize;

    @JsonIgnore
    @OneToOne
    private Text text;

    /**
     * @return 주요 이미지 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @return 원본 파일 이름
     */
    public String getOriginalFileName() {
        return originalFileName;
    }

    /**
     * @return 저장된 파일 경로
     */
    public String getStoredFilePath() {
        return storedFilePath;
    }

    /**
     * @return 파일 크기
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 주요 이미지 ID를 설정합니다.
     *
     * @param id 주요 이미지 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 원본 파일 이름을 설정합니다.
     *
     * @param originalFileName 원본 파일 이름
     */
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    /**
     * 저장된 파일 경로를 설정합니다.
     *
     * @param storedFilePath 저장된 파일 경로
     */
    public void setStoredFilePath(String storedFilePath) {
        this.storedFilePath = storedFilePath;
    }

    /**
     * 파일 크기를 설정합니다.
     *
     * @param fileSize 파일 크기
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 연결된 텍스트 엔티티를 반환합니다.
     *
     * @return 연결된 텍스트 엔티티
     */
    public Text getText() {
        return text;
    }

    /**
     * 연결된 텍스트 엔티티를 설정합니다.
     *
     * @param text 연결된 텍스트 엔티티
     */
    public void setText(Text text) {
        this.text = text;
    }
}