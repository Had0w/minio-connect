package ru.klyuev.s3miniodemo.config;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${minio.url}")
    private String minioUrl;
    @Value("${minio.access.name}")
    private String accessKey;
    @Value("${minio.access.password}")
    private String accessSecret;

    @Bean
    public MinioClient s3Client() {
        return  MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(accessKey, accessSecret)
                .build();
    }
}
