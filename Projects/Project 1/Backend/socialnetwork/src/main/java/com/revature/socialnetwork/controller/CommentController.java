package com.revature.socialnetwork.controller;

import com.revature.socialnetwork.entity.Comment;
import com.revature.socialnetwork.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing comments
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    /**
     * Creates a new comment
     *
     * @param comment the comment details to create
     * @return the created comment
     */
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        log.info(comment.getContent() + " " + comment.getPost().getId() + " " + comment.getUserId().getId());
        Comment createdComment = commentService.addComment(comment);
        return ResponseEntity.ok(createdComment);
    }

    /**
     * Retrieves all comments
     *
     * @return the list of all comments
     */
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    /**
     * Retrieves comments by post id
     *
     * @param postId the id of the post whose comments are to be retrieved
     * @return the list of comments for the specified post
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable int postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        log.info(comments.get(0).getContent() + " " + comments.get(0).getPost().getId() + " " + comments.get(0).getUserId().getId());
        return ResponseEntity.ok(comments);
    }

    /**
     * Retrieves a comment by id
     *
     * @param commentId the id of the comment to retrieve
     * @return the comment with the specified id
     */
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int commentId) {
        System.out.println("Entered getCommentById");
        Comment comment = commentService.getCommentById(commentId);
//        comment.setPostId(1);
        return ResponseEntity.ok(comment);
    }

    /**
     * Updates a comment's information
     *
     * @param commentId the id of the comment to update
     * @param comment   the updated comment details
     * @return the updated comment
     */
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable int commentId, @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(commentId, comment);
        return ResponseEntity.ok(updatedComment);
    }

    /**
     * Deletes a comment by ID.
     *
     * @param commentId the ID of the comment to delete.
     * @return a response indicating the result of the operation.
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
