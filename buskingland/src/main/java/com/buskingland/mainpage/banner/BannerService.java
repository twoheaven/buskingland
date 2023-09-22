package com.buskingland.mainpage.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;
    private final AmazonS3 amazonS3;

    @Autowired
    public BannerService(BannerRepository bannerRepository, AmazonS3 amazonS3) {
        this.bannerRepository = bannerRepository;
        this.amazonS3 = amazonS3;
    }

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    /**
     * 새로운 배너를 생성하고 저장합니다.
     *
     * @param file      업로드된 이미지 파일
     * @param backcolor 배너의 배경 색상
     * @return 생성된 배너 객체
     * @throws IOException 파일 업로드 중 발생한 예외
     */
    public Banner createBanner(MultipartFile file, String backcolor) throws IOException {
        Banner banner = new Banner();
        banner.setOriginalFileName(file.getOriginalFilename());
        banner.setFileSize(file.getSize());
        banner.setBackcolor(backcolor);

        String storedFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        amazonS3.putObject(new PutObjectRequest(bucketName, storedFileName, file.getInputStream(), metadata));

        String s3Url = amazonS3.getUrl(bucketName, storedFileName).toString();
        banner.setStoredFilePath(s3Url);

        return bannerRepository.save(banner);
    }

    /**
     * 모든 배너 정보를 조회합니다.
     *
     * @return 모든 배너 정보를 담고 있는 리스트
     */
    public List<Banner> getAllBanners() {
        return bannerRepository.findAll();
    }

    /**
     * 주어진 id에 해당하는 배너 정보를 조회합니다.
     *
     * @param id 배너의 고유 id
     * @return 주어진 id에 해당하는 배너 정보
     * @throws BannerNotFoundException 해당 id에 해당하는 배너가 없을 경우 발생하는 예외
     */
    public Banner getBannerById(Long id) {
        return bannerRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
    }

    /**
     * 주어진 id에 해당하는 배너를 삭제합니다.
     *
     * @param id 삭제할 배너의 고유 id
     * @throws BannerNotFoundException 해당 id에 해당하는 배너가 없을 경우 발생하는 예외
     */
    public void deleteBanner(Long id) {
        Banner banner = getBannerById(id);

        // S3에서 이미지 파일 삭제
        String s3ObjectKey = extractS3ObjectKey(banner.getStoredFilePath());
        deleteImageFile(s3ObjectKey);

        // 배너 객체 삭제
        bannerRepository.deleteById(id);
    }

    /**
     * 주어진 S3 URL에서 객체 키를 추출합니다.
     *
     * @param s3Url S3 객체 URL
     * @return 추출된 S3 객체 키
     */
    private String extractS3ObjectKey(String s3Url) {
        String[] parts = s3Url.split("/");
        return parts[parts.length - 1];
    }

    /**
     * 주어진 S3 객체 키에 해당하는 이미지 파일을 S3에서 삭제합니다.
     *
     * @param s3ObjectKey 삭제할 S3 객체 키
     * @throws RuntimeException 이미지 파일 삭제 중 오류 발생 시 발생하는 예외
     */
    private void deleteImageFile(String s3ObjectKey) {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(bucketName, s3ObjectKey));
        } catch (Exception e) {
            // 이미지 파일 삭제 중 오류 발생 시 예외 처리
            e.printStackTrace();
            throw new RuntimeException("이미지 파일 삭제 중 오류가 발생했습니다.");
        }
    }
}