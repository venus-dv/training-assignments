package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Comment;
import com.revature.socialnetwork.repository.CommentRepository;
import com.revature.socialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of CommentService interface
 * This class provides methods for comment-related operations
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Adds a new comment to a post by saving the comment entity to the database
     * 
     * @param comment the comment to be added
     * @return the added comment
     */
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Retrieves comments by post id
     * 
     * @param postId the id of the post
     * @return a list of comments for the specified post
     */
    @Override
    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }

    /**
     * Retrieves a comment by its id
     * Handles the case where the comment might not be found.
     * 
     * @param id the id of the comment
     * @return the comment with the given ID, or null if not found
     */
    @Override
    public Comment getCommentById(Integer id) {
        // Use Optional to handle the case where the comment is not found
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }

    /**
     * Updates an existing comment
     * 
     * @param comment the comment with updated information
     * @return the updated comment
     */
    @Override
    public Comment updateComment(Comment comment) {
        // Save the updated comment entity to the database
        return commentRepository.save(comment);
    }

    /**
     * Deletes a comment by its ID
     * 
     * @param id the ID of the comment to be deleted
     */
    @Override
    public void deleteComment(Integer id) {
        // Delete the comment entity by its ID
        commentRepository.deleteById(id);
    }
}
