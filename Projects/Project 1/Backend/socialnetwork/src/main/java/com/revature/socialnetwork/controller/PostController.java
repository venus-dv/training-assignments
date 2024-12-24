package com.revature.socialnetwork.controller;

import com.revature.socialnetwork.dto.PostRequest;
import com.revature.socialnetwork.entity.Post;
import com.revature.socialnetwork.service.PostService;
import com.revature.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing posts
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Retrieves all posts
     *
     * @return the list of all posts
     */
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    /**
     * Creates a new post
     *
     * @param post the post details to create
     * @return the created post
     */
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    /**
     * Retrieves a post by id
     *
     * @param postId the id of the post to retrieve
     * @return the post with the specified id
     */
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable int postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    /**
     * Updates a post's information
     *
     * @param postId the id of the post to update
     * @param post   the updated post details
     * @return the updated post
     */
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable int postId, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(postId, post);
        return ResponseEntity.ok(updatedPost);
    }

    /**
     * Deletes a post by id
     *
     * @param postId the id of the post to delete
     * @return a response indicating the result of the operation
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable int postId) {
//        postService.deletePost(postId);
//        return ResponseEntity.ok().build();

        boolean isDeleted = postService.deletePost(postId);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
