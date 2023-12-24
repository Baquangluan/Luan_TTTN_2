package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Post;
import com.example.example3.service.PostService;
import com.example.example3.repository.PostRepository;


import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServicelmpl implements PostService {

    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        // Set default values for the new fields
        post.setSlug("Default Slug");
        post.setDetail("Default Detail");
        post.setImage("Default Image");
        post.setType("Default Type");
        post.setMetakey("Default Metakey");
        post.setMetadesc("Default Metadesc");
        post.setCreated_at(new Date());
        post.setUpdated_at(new Date());
        post.setCreated_by("Default Creator");
        post.setUpdated_by("Default Updater");
        post.setStatus("Active");
        post.setEmail("Default Email");
        post.setFullname("Default Fullname");
   


        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        return optionalPost.orElse(null);
    }

    @Override
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post updatePost(Post post) {
        Optional<Post> optionalPost = postRepository.findById(post.getId());
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setSlug(post.getSlug());
            existingPost.setDetail(post.getDetail());
            existingPost.setImage(post.getImage());
            existingPost.setType(post.getType());
            existingPost.setMetakey(post.getMetakey());
            existingPost.setMetadesc(post.getMetadesc());
            existingPost.setCreated_at(new Date());
            existingPost.setUpdated_at(new Date());

            existingPost.setCreated_by(post.getCreated_by());
            existingPost.setUpdated_by(post.getUpdated_by());
            existingPost.setStatus(post.getStatus());
            existingPost.setEmail(post.getEmail());
            existingPost.setFullname(post.getFullname());
        

            return postRepository.save(existingPost);
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
