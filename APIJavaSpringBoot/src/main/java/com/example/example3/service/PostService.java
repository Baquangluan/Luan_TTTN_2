package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.example3.entity.Post; 

public interface PostService {  
    
    public Post createPost(Post post); 
    public Post getPostById(Long postId);  
    public Page<Post> getAllPosts(Pageable pageable);
    public Post updatePost(Post post); 
    public void deletePost(Long postId); 
}
