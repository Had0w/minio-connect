package ru.klyuev.s3miniodemo.services;

import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.klyuev.s3miniodemo.utils.FileDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class MinioAdapter implements Serializable {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public List<FileDto> getAllBucket() {
        List<FileDto> objects = new ArrayList<>();
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder()
                    .bucket(bucket)
                    .recursive(true)
                    .build());
            for (Result<Item> item : results) {
                FileDto fileDto = new FileDto();
//                fileDto.setFilename(item.get().objectName());
//                fileDto.setSize(item.get().size());
                objects.add(fileDto);
            }
            return objects;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
