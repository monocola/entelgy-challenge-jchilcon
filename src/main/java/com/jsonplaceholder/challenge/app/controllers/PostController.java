package com.jsonplaceholder.challenge.app.controllers;

import com.jsonplaceholder.challenge.app.entities.PostEntity;
import com.jsonplaceholder.challenge.app.errors.BeanErrorException;
import com.jsonplaceholder.challenge.app.errors.BeanNotFoundException;
import com.jsonplaceholder.challenge.app.services.PostService;
import com.jsonplaceholder.challenge.app.utils.Constants;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@CrossOrigin(origins = "*", maxAge = 3500, methods= {RequestMethod.POST})
@RequestMapping("/api/v1/post")
public class PostController {


    @Autowired
    PostService postService;


    @ApiResponse(responseCode = "200",
            headers = {
                    @Header(name = "Access-Control-Allow-Origin",schema = @Schema(type = "String"))},
            content = @Content(mediaType = "application/json", array = @ArraySchema( schema = @Schema(implementation = PostEntity.class))))
    @PostMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postListAll(){

        PostEntity objPost = null;
        try{
            objPost = postService.getPostAll();
        }catch (HttpClientErrorException ex){
            throw new BeanErrorException(Constants.MESSAGE_ERROR);
        }
        if(objPost == null ){
            throw new BeanNotFoundException( Constants.MESSAGE_NO_CONTENT);
        }

        return ResponseEntity.status(HttpStatus.OK).body(objPost);

    }
}
