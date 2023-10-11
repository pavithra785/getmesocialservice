package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping
@RestController("/api/files")
public class FileResource {
    @Autowired
    private FileService fileService;
    public boolean upload(@RequestParam(name = "file")MultipartFile file) throws IOException {
    return fileService.upload(file);
    }
}
