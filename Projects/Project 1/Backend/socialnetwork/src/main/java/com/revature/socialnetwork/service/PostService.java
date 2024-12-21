package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.Post;
import java.util.List;

/**
 * Interface for Post Service to define the contract for post-related
 * operations.
 */
public interface PostService {

    /**
     * Creates a new post
     * 
     * @param post the post to be created
     * @return the created post
     */
    Post createPost(Post post);


    /**
     * Retrieves all posts
     * @return a list of all user posts
     */
    List<Post> getAllPosts();

    /**
     * Retrieves posts by user id
     * 
     * @param userId the id of the user
     * @return a list of posts created by the specified user
     */
    List<Post> getPostsByUserId(Integer userId);

    /**
     * Retrieves a post by its id
     * 
     * @param id the id of the post
     * @return the post with the given id
     */
    Post getPostById(Integer id);

    /**
     * Updates an existing post
     * 
     * @param post the post with updated information
     * @return the updated post
     */
    Post updatePost(int postId, Post post);

    /**
     * Deletes a post by its id
     * 
     * @param id the id of the post to be deleted
     */
    void deletePost(Integer id);

    /**
     * Searches for posts by a given keyword in the post content
     * 
     * @param keyword the keyword to search for in the post content
     * @return a list of posts matching the keyword
     */
    List<Post> searchPosts(String keyword);
}
