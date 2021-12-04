package ru.klyuev.s3miniodemo.api;

import io.minio.messages.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.klyuev.s3miniodemo.services.MinioAdapter;
import ru.klyuev.s3miniodemo.utils.FileDto;

import java.util.List;

@RestController
public class MinioStorageController {

    @Autowired
    private MinioAdapter adapter;

    @GetMapping(path = "/buckets")
    public List<FileDto> bucketList() {
        return adapter.getAllBucket();
    }
}
