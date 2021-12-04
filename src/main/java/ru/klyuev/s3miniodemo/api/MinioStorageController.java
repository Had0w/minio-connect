package ru.klyuev.s3miniodemo.api;

import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.klyuev.s3miniodemo.services.MinioAdapter;

import java.util.List;

@RestController
public class MinioStorageController {

    @Autowired
    MinioAdapter adapter;

    @GetMapping(path = "/buckets")
    public List<Bucket> bucketList() {
        return adapter.getAllBucket();
    }
}
