package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.Reaction;
import com.revature.socialnetwork.entity.ReactionType;
import java.util.List;

/**
 * Interface for Reaction Service to define the contract for reaction-related
 * operations
 */
public interface ReactionService {

    /**
     * Adds a new reaction
     * 
     * @param reaction the reaction to be added
     * @return the added reaction
     */
    Reaction addReaction(Reaction reaction);

    /**
     * Retrieves reactions by post id
     * 
     * @param postId the id of the post
     * @return a list of reactions for the specified post
     */
    List<Reaction> getReactionsByPostId(Integer postId);

    /**
     * Retrieves reactions by comment id
     * 
     * @param commentId the id of the comment
     * @return a list of reactions for the specified comment
     */
    List<Reaction> getReactionsByCommentId(Integer commentId);

    /**
     * Retrieves a reaction by its id
     * 
     * @param id the id of the reaction
     * @return the reaction with the given id
     */
    Reaction getReactionById(Integer id);

    /**
     * Deletes a reaction by its id
     * 
     * @param id the id of the reaction to be deleted
     */
    void deleteReaction(Integer id);

    /**
     * Counts reactions by type for a given post
     * 
     * @param postId       the id of the post
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the post
     */
    Long countReactionsByTypeForPost(Integer postId, ReactionType reactionType);

    /**
     * Counts reactions by type for a given comment
     * 
     * @param commentId    the id of the comment
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the comment
     */
    Long countReactionsByTypeForComment(Integer commentId, ReactionType reactionType);
}
