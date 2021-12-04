package ru.klyuev.s3miniodemo.services;

import io.minio.MinioClient;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinioAdapter {

    @Autowired
    MinioClient minioClient;

    public List<Bucket> getAllBucket() {
        try {
            return minioClient.listBuckets();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
