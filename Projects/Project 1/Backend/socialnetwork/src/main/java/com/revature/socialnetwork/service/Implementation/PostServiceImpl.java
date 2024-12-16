package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Post;
import com.revature.socialnetwork.repository.PostRepository;
import com.revature.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of PostService interface
 * This class provides methods for post-related operations
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    /**
     * Creates a new post by saving the post entity to the database
     * 
     * @param post the post to be created
     * @return the created post
     */
    @Override
    public Post createPost(Post post) {
        // Save the post entity to the database
        return postRepository.save(post);
    }

    /**
     * Retrieves posts by user id
     * 
     * @param userId the id of the user
     * @return a list of posts created by the specified user
     */
    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    /**
     * Retrieves a post by its id
     * Handles the case where the post might not be found
     * 
     * @param id the id of the post
     * @return the post with the given id, or null if not found
     */
    @Override
    public Post getPostById(Integer id) {
        // Use Optional to handle the case where the post is not found
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    /**
     * Updates an existing post
     * 
     * @param post the post with updated information
     * @return the updated post
     */
    @Override
    public Post updatePost(Post post) {
        // Save the updated post entity to the database
        return postRepository.save(post);
    }

    /**
     * Deletes a post by its id
     * 
     * @param id the id of the post to be deleted
     */
    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    /**
     * Searches for posts by a given keyword in the post content
     * 
     * @param keyword the keyword to search for in the post content
     * @return a list of posts matching the keyword
     */
    @Override
    public List<Post> searchPosts(String keyword) {
        return postRepository.searchPosts(keyword);
    }
}
