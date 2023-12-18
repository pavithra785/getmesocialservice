package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import static com.amazonaws.services.ec2.model.Scope.Region;

@Service
public class FileService {
    public boolean upload(MultipartFile file) {

        try {

            BasicAWSCredentials awsCredentials= new BasicAWSCredentials("AKIA2XURCHSI32SCGB6V","YNKLEVPq4Ri41gG2qKSDqRhrAgMyBckPfaMeDDtW");
            final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(Regions.US_EAST_2).build();

            ObjectMetadata metadata= new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            s3.putObject("backendsp3",file.getOriginalFilename(),file.getInputStream(),metadata);
            return true;

        }

        catch (AmazonServiceException | IOException e){
            e.printStackTrace();
            return false;
        }




    }

    public S3Object getFile(String key){

        BasicAWSCredentials awsCredentials= new BasicAWSCredentials("AKIA2XURCHSI32SCGB6V","YNKLEVPq4Ri41gG2qKSDqRhrAgMyBckPfaMeDDtW");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_2).build();
        return s3.getObject("backendsp3",key);
    }

    public void deleteFile(String key){

        BasicAWSCredentials awsCredentials= new BasicAWSCredentials("AKIA2XURCHSI32SCGB6V","YNKLEVPq4Ri41gG2qKSDqRhrAgMyBckPfaMeDDtW");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_2).build();
        s3.deleteObject("backendsp3",key);
    }


}
