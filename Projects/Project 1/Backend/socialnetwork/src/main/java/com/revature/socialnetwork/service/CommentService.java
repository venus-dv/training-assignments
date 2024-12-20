package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.Comment;
import java.util.List;

/**
 * Interface for Comment Service to define the contract for comment-related
 * operations.
 */
public interface CommentService {

    /**
     * Adds a new comment to a post.
     * 
     * @param comment the comment to be added
     * @return the added comment
     */
    Comment addComment(Comment comment);

    /**
     * Retrieves all comments
     * 
     * @return all comments
     */
    List<Comment> getAllComments();

    /**
     * Retrieves comments by post id
     * 
     * @param postId the id of the post
     * @return a list of comments for the specified post
     */
    List<Comment> getCommentsByPostId(Integer postId);

    /**
     * Retrieves a comment by its ID.
     * 
     * @param id the id of the comment
     * @return the comment with the given id
     */
    Comment getCommentById(Integer id);

    /**
     * Updates an existing comment
     * 
     * @param comment the comment with updated information
     * @return the updated comment
     */
    Comment updateComment(int commentId, Comment comment);

    /**
     * Deletes a comment by its id
     * 
     * @param id the id of the comment to be deleted
     */
    void deleteComment(Integer id);
}
