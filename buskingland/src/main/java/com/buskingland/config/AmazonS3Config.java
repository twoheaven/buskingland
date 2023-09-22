package com.buskingland.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {

    @Value("${cloud.aws.credentials.accessKey}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String awsSecretKey;

    @Value("${cloud.aws.region.static}")
    private String awsRegion;

    // Amazon S3 Bean을 생성하는 메서드
    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3Client.builder()
            .withRegion(awsRegion)  // Amazon S3 클라이언트를 지정된 지역으로 설정합니다.
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))  // AWS 자격 증명 정보를 설정합니다.
            .build();  // AmazonS3 Bean을 빌드하고 반환합니다.
    }
}