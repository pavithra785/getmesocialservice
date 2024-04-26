package com.example.getmesocialservice.config;

import com.example.getmesocialservice.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp initializeFirebase() throws IOException {

        PathMatchingResourcePatternResolver resolver= new PathMatchingResourcePatternResolver();
        Resource resource= resolver.getResource("myphotoapp-deb82-firebase-adminsdk-eykkh-0f9d4e3d71.json");
        FileInputStream serviceAccount =
                new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);

    }


    public FirebaseUser authenticate(String idToken) throws IOException, FirebaseAuthException {
        String uid=FirebaseAuth.getInstance( initializeFirebase()).verifyIdToken(idToken).getUid();
        String name=FirebaseAuth.getInstance( initializeFirebase()).verifyIdToken(idToken).getName();
        String email=FirebaseAuth.getInstance( initializeFirebase()).verifyIdToken(idToken).getEmail();

        return new FirebaseUser(uid,name,email);
    }
}
