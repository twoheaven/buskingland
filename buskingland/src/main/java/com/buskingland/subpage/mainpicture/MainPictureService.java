package com.buskingland.subpage.mainpicture;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class MainPictureService {
    private final MainPictureRepository mainPictureRepository;
    private final AmazonS3 amazonS3;

    @Autowired
    public MainPictureService(MainPictureRepository mainPictureRepository, AmazonS3 amazonS3) {
        this.mainPictureRepository = mainPictureRepository;
        this.amazonS3 = amazonS3;
    }

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;
    
    /**
     * 새로운 메인 이미지를 생성하고 저장합니다.
     *
     * @param file 새로운 이미지 파일
     * @return 생성된 메인 이미지
     * @throws IOException 파일 업로드 중 발생한 예외
     */
    public MainPicture createMainPicture(MultipartFile file) throws IOException {
        MainPicture mainPicture = new MainPicture();
        mainPicture.setOriginalFileName(file.getOriginalFilename());
        mainPicture.setFileSize(file.getSize());

        // 이미지 파일을 고유한 이름으로 저장하고 S3에 업로드합니다.
        String storedFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        amazonS3.putObject(new PutObjectRequest(bucketName, storedFileName, file.getInputStream(), metadata));

        String s3Url = amazonS3.getUrl(bucketName, storedFileName).toString();
        mainPicture.setStoredFilePath(s3Url);

        return mainPictureRepository.save(mainPicture);
    }

    /**
     * 기존 메인 이미지를 새 이미지로 업데이트합니다.
     *
     * @param id            업데이트할 메인 이미지의 ID
     * @param newImageFile  새로운 이미지 파일
     * @param newMainPicture 새로운 메인 이미지 정보
     * @return 업데이트된 메인 이미지
     * @throws IOException 파일 업로드 중 발생한 예외
     */
    public MainPicture updateMainPicture(Long id, MultipartFile newImageFile, MainPicture newMainPicture) throws IOException {
        // 기존 메인 이미지 정보 가져오기
        MainPicture existingMainPicture = getMainPictureById(id);

        // 새로운 이미지 파일 업로드 및 기존 이미지 파일 삭제
        String storedFileName = UUID.randomUUID().toString() + "_" + newImageFile.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(newImageFile.getSize());
        amazonS3.putObject(new PutObjectRequest(bucketName, storedFileName, newImageFile.getInputStream(), metadata));

        String s3Url = amazonS3.getUrl(bucketName, storedFileName).toString();
        existingMainPicture.setStoredFilePath(s3Url);

        // 메인 이미지 정보 업데이트
        existingMainPicture.setOriginalFileName(newImageFile.getOriginalFilename());
        existingMainPicture.setFileSize(newImageFile.getSize());
        // 추가적인 필드 업데이트 가능

        return mainPictureRepository.save(existingMainPicture);
    }

    /**
     * 주어진 ID에 해당하는 메인 이미지를 가져옵니다.
     *
     * @param id 메인 이미지의 ID
     * @return 주어진 ID에 해당하는 메인 이미지
     */
    public MainPicture getMainPictureById(Long id) {
        return mainPictureRepository.findById(id)
                .orElseThrow(() -> new MainPictureNotFoundException(id));
    }
}
