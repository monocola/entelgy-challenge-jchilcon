package com.jsonplaceholder.challenge.app.services;

import com.jsonplaceholder.challenge.app.entities.PostDetailEntity;
import com.jsonplaceholder.challenge.app.entities.PostEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class PostServiceTest {

    @Autowired
    PostService postService = Mockito.mock(PostService.class);

    @BeforeEach
    void setUp() {
        Mockito.when(postService.getPostAll());
    }

    @Test
    void  getPostAll() {

    }




}
