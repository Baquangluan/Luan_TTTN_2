package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.example3.entity.Post;  // Change Order to Post
import com.example.example3.service.PostService;  // Change OrderService to PostService

@RestController
@AllArgsConstructor
@RequestMapping("api/posts")  // Change the path to "api/posts"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class PostController {

    private PostService postService;  // Change OrderService to PostService

    // Create Post REST API
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {  // Change Order to Post
        Post savedPost = postService.createPost(post);  // Change OrderService to PostService
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // Get Post by id REST API
    // http://localhost:8080/api/posts/1  // Change the path
    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long postId) {  // Change orderId to postId
        Post post = postService.getPostById(postId);  // Change getOrderById to getPostById
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Posts REST API
    // http://localhost:8080/api/posts  // Change the path
    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postService.getAllPosts(pageable);  // Change Categories to posts
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Update Post REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/posts/1  // Change the path
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long postId,
            @RequestBody Post post) {  // Change Order to Post
        post.setId(postId);  // Change orderId to postId
        Post updatedPost = postService.updatePost(post);  // Change OrderService to PostService
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    // Delete Post REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId) {  // Change orderId to postId
        postService.deletePost(postId);  // Change deleteOrder to deletePost
        return new ResponseEntity<>("Post successfully deleted!", HttpStatus.OK);
    }
}
