package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Post;
import com.revature.socialnetwork.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    private static final Logger logger = Logger.getLogger("PostServiceImplTest");

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    public void setUp() {
        try {
            MockitoAnnotations.openMocks(this);
            logger.info("Setting up the test environment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreatePost() {
        Post post = new Post();
        post.setBody("Test post content");

        logger.info("Creating a new post");
        postService.createPost(post);

        verify(postRepository, times(1)).save(post);
        logger.info("Post created successfully");
    }

    @Test
    void testGetPostsByUserId() {
        int userId = 1;
        List<Post> posts = List.of(new Post(), new Post());

        when(postRepository.findByUserId(userId)).thenReturn(posts);

        logger.info("Retrieving posts by user ID");
        List<Post> foundPosts = postService.getPostsByUserId(userId);

        assertNotNull(foundPosts);
        assertFalse(foundPosts.isEmpty());
        verify(postRepository, times(1)).findByUserId(userId);
        logger.info("Posts retrieved successfully");
    }

    @Test
    void testGetPostById() {
        int postId = 1;
        Post post = new Post();
        post.setId(postId);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        logger.info("Retrieving post by ID");
        Post foundPost = postService.getPostById(postId);

        assertNotNull(foundPost);
        assertEquals(postId, foundPost.getId());
        verify(postRepository, times(1)).findById(postId);
        logger.info("Post retrieved successfully");
    }

    @Test
    void testGetAllPosts() {
        List<Post> posts = List.of(new Post(), new Post());

        when(postRepository.findAll()).thenReturn(posts);

        logger.info("Retrieving all posts");
        List<Post> allPosts = postService.getAllPosts();

        assertNotNull(allPosts);
        assertFalse(allPosts.isEmpty());
        verify(postRepository, times(1)).findAll();
        logger.info("All posts retrieved successfully");
    }

    @Test
    void testUpdatePost() {
        int postId = 1;
        Post post = new Post();
        post.setId(postId);
        post.setBody("Updated post content");

        when(postRepository.save(post)).thenReturn(post);

        logger.info("Updating post");
        Post updatedPost = postService.updatePost(postId, post);

        assertNotNull(updatedPost);
        assertEquals("Updated post content", updatedPost.getBody());
        verify(postRepository, times(1)).save(post);
        logger.info("Post updated successfully");
    }

    @Test
    void testDeletePost() {
        int postId = 1;

        doNothing().when(postRepository).deleteById(postId);

        logger.info("Deleting post by ID");
        postService.deletePost(postId);

        verify(postRepository, times(1)).deleteById(postId);
        logger.info("Post deleted successfully");
    }

    @Test
    void testSearchPosts() {
        String keyword = "test";
        List<Post> posts = List.of(new Post(), new Post());

        when(postRepository.searchPosts(keyword)).thenReturn(posts);

        logger.info("Searching posts by keyword");
        List<Post> foundPosts = postService.searchPosts(keyword);

        assertNotNull(foundPosts);
        assertFalse(foundPosts.isEmpty());
        verify(postRepository, times(1)).searchPosts(keyword);
        logger.info("Posts found successfully");
    }
}
