package com.jsonplaceholder.challenge.app;

import com.jsonplaceholder.challenge.app.entities.PostEntity;
import com.jsonplaceholder.challenge.app.services.PostService;
import com.jsonplaceholder.challenge.app.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {


    @Autowired
    PostService postService;


    @Test
    public void postListAll(){
        PostEntity objPost = null;
        objPost = postService.getPostAll();
        ResponseEntity.status(HttpStatus.OK).body(objPost);

    }
}
