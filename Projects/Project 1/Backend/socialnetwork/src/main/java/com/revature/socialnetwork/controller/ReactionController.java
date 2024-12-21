package com.revature.socialnetwork.controller;

import com.revature.socialnetwork.entity.Reaction;
import com.revature.socialnetwork.entity.ReactionType;
import com.revature.socialnetwork.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing reactions to posts and comments
 */
@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    /**
     * Adds a new reaction
     *
     * @param reaction the reaction to be added
     * @return the added reaction
     */
    @PostMapping
    public ResponseEntity<Reaction> addReaction(@RequestBody Reaction reaction) {
        Reaction addedReaction = reactionService.addReaction(reaction);
        return ResponseEntity.ok(addedReaction);
    }

    /**
     * Retrieves reactions by post id
     *
     * @param postId the id of the post
     * @return a list of reactions for the specified post
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Reaction>> getReactionsByPostId(@PathVariable Integer postId) {
        List<Reaction> reactions = reactionService.getReactionsByPostId(postId);
        return ResponseEntity.ok(reactions);
    }

    /**
     * Retrieves reactions by comment id
     *
     * @param commentId the id of the comment
     * @return a list of reactions for the specified comment
     */
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<Reaction>> getReactionsByCommentId(@PathVariable Integer commentId) {
        List<Reaction> reactions = reactionService.getReactionsByCommentId(commentId);
        return ResponseEntity.ok(reactions);
    }

    /**
     * Retrieves a reaction by its id
     *
     * @param id the id of the reaction.
     * @return the reaction with the specified id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reaction> getReactionById(@PathVariable Integer id) {
        Reaction reaction = reactionService.getReactionById(id);
        return ResponseEntity.ok(reaction);
    }

    /**
     * Deletes a reaction by its id
     *
     * @param id the id of the reaction to be deleted
     * @return a response indicating the result of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Integer id) {
        reactionService.deleteReaction(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Counts reactions by type for a given post
     *
     * @param postId       the id of the post
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the post
     */
    @GetMapping("/post/{postId}/count")
    public ResponseEntity<Long> countReactionsByTypeForPost(
            @PathVariable Integer postId,
            @RequestParam ReactionType reactionType) {
        Long count = reactionService.countReactionsByTypeForPost(postId, reactionType);
        return ResponseEntity.ok(count);
    }

    /**
     * Counts reactions by type for a given comment
     *
     * @param commentId    the id of the comment
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the comment
     */
    @GetMapping("/comment/{commentId}/count")
    public ResponseEntity<Long> countReactionsByTypeForComment(
            @PathVariable Integer commentId,
            @RequestParam ReactionType reactionType) {
        Long count = reactionService.countReactionsByTypeForComment(commentId, reactionType);
        return ResponseEntity.ok(count);
    }
}
