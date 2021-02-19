package com.jsonplaceholder.challenge.app.repositories.impl;

import com.jsonplaceholder.challenge.app.entities.PostDetailEntity;
import com.jsonplaceholder.challenge.app.entities.PostEntity;
import com.jsonplaceholder.challenge.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("PostService")
@Repository
public class PostRepositrotyImpl implements PostService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    Environment env;

    @Override
    public PostEntity getPostAll(){

            String url = env.getProperty("posts.url");
            PostDetailEntity[] objects = restTemplate.getForObject(url, PostDetailEntity[].class);
            List<PostDetailEntity> portEntityList = Arrays.asList(objects);
            List<String> postsList = new ArrayList<>();
            PostEntity objPost = new PostEntity();
            String bar = "|";
            for (PostDetailEntity value : portEntityList) {
                String values = (value.getPostId().toString() + bar + value.getId().toString() +bar + value.getEmail());
                postsList.add(values);
                objPost.setData(postsList);
            }
            return objPost;
    }

}
