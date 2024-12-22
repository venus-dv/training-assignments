package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Comment;
import com.revature.socialnetwork.repository.CommentRepository;
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
public class CommentServiceImplTest {

    private static final Logger logger = Logger.getLogger("CommentServiceImplTest");

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

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
    void testAddComment() {
        Comment comment = new Comment();
        comment.setContent("Test comment content");

        logger.info("Adding a new comment");
        commentService.addComment(comment);

        verify(commentRepository, times(1)).save(comment);
        logger.info("Comment added successfully");
    }

    @Test
    void testGetAllComments() {
        List<Comment> comments = List.of(new Comment(), new Comment());

        when(commentRepository.findAll()).thenReturn(comments);

        logger.info("Retrieving all comments");
        List<Comment> allComments = commentService.getAllComments();

        assertNotNull(allComments);
        assertFalse(allComments.isEmpty());
        verify(commentRepository, times(1)).findAll();
        logger.info("All comments retrieved successfully");
    }

    @Test
    void testGetCommentsByPostId() {
        int postId = 1;
        List<Comment> comments = List.of(new Comment(), new Comment());

        when(commentRepository.findByPost_Id(postId)).thenReturn(comments);

        logger.info("Retrieving comments by post ID");
        List<Comment> foundComments = commentService.getCommentsByPostId(postId);

        assertNotNull(foundComments);
        assertFalse(foundComments.isEmpty());
        verify(commentRepository, times(1)).findByPost_Id(postId);
        logger.info("Comments retrieved successfully");
    }

    @Test
    void testGetCommentById() {
        int commentId = 1;
        Comment comment = new Comment();
        comment.setId(commentId);

        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        logger.info("Retrieving comment by ID");
        Comment foundComment = commentService.getCommentById(commentId);

        assertNotNull(foundComment);
        assertEquals(commentId, foundComment.getId());
        verify(commentRepository, times(1)).findById(commentId);
        logger.info("Comment retrieved successfully");
    }

    @Test
    void testUpdateComment() {
        int commentId = 1;
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setContent("Updated comment content");

        when(commentRepository.save(comment)).thenReturn(comment);

        logger.info("Updating comment");
        Comment updatedComment = commentService.updateComment(commentId, comment);

        assertNotNull(updatedComment);
        assertEquals("Updated comment content", updatedComment.getContent());
        verify(commentRepository, times(1)).save(comment);
        logger.info("Comment updated successfully");
    }

    @Test
    void testDeleteComment() {
        int commentId = 1;

        doNothing().when(commentRepository).deleteById(commentId);

        logger.info("Deleting comment by ID");
        commentService.deleteComment(commentId);

        verify(commentRepository, times(1)).deleteById(commentId);
        logger.info("Comment deleted successfully");
    }
}
