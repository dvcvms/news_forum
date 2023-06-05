package ru.mirea.newsforum.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.newsforum.dto.PostDTO;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.entity.Post;
import ru.mirea.newsforum.service.GroupService;
import ru.mirea.newsforum.service.PostService;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:8000")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final GroupService groupService;

    @GetMapping("/get")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/getByCourseOrGroup/{groupToDecode}")
    public ResponseEntity<List<Post>> getPost(@PathVariable String groupToDecode) {
        String groupNumber = URLDecoder.decode(groupToDecode, StandardCharsets.UTF_8);
        GroupEntity group = groupService.parseGroup(groupNumber);
        List<Post> posts = postService.findPostByCourseOrGroup(group.getCourse(), group);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> savePost(@RequestBody PostDTO postDTO) {
        List<GroupEntity> groups = groupService.parseGroups(postDTO.getGroups());

        Post post = new Post()
                .setGroups(groups)
                .setHeader(postDTO.getHeader())
                .setContent(postDTO.getContent())
                .setCourse(postDTO.getCourse())
                .setImageUrl(postDTO.getImageUrl());

        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable("id") long id) {
        postService.deleteById(id);
    }
}
