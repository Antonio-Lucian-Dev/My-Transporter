package com.asusoftware.MyTransporter.user.controller;

import com.asusoftware.MyTransporter.user.model.dto.CreatePostDto;
import com.asusoftware.MyTransporter.user.model.dto.PostDto;
import com.asusoftware.MyTransporter.user.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;

    @PostMapping(path = "/create/{id}")
    public void create(@PathVariable(name = "id") UUID id, @RequestBody CreatePostDto createPostDto) {
        postService.create(id, createPostDto);
    }

    @GetMapping(path = "/findAll/{pageNumber}")
    public List<PostDto> findAll(@PathVariable(name = "pageNumber") int pageNumber) {
        return postService.findAll(pageNumber);
    }

    @GetMapping(path = "/findUserByCity/{cityName}")
    public void findUserByCity(@PathVariable(name = "cityName") String city) {}

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {}
}
