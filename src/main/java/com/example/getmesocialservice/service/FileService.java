package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.regions.Region;


import java.io.IOException;
@Service
public class FileService {
    public boolean upload(MultipartFile file) throws IOException {

        try {
            Region region = Region.US_WEST_2;
            final AmazonS3 s3= AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();

            ObjectMetadata metadata= new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            s3.putObject("backendps3",file.getOriginalFilename(),file.getInputStream(),metadata);
            return true;

        }

        catch (AmazonServiceException ex){
            return false;
        }




    }



}
