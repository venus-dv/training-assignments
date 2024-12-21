package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Reaction;
import com.revature.socialnetwork.entity.ReactionType;
import com.revature.socialnetwork.repository.ReactionRepository;
import com.revature.socialnetwork.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of ReactionService interface
 * This class provides methods for reaction-related operations
 */
@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    /**
     * Adds a new reaction by saving the reaction entity to the database
     * 
     * @param reaction the reaction to be added
     * @return the added reaction
     */
    @Override
    public Reaction addReaction(Reaction reaction) {
        // Save the reaction entity to the database
        return reactionRepository.save(reaction);
    }

    /**
     * Retrieves reactions by post id
     * 
     * @param postId the id of the post
     * @return a list of reactions for the specified post
     */
    @Override
    public List<Reaction> getReactionsByPostId(Integer postId) {
        return reactionRepository.findByPostId(postId);
    }

    /**
     * Retrieves reactions by comment id
     * 
     * @param commentId the id of the comment
     * @return a list of reactions for the specified comment
     */
    @Override
    public List<Reaction> getReactionsByCommentId(Integer commentId) {
        return reactionRepository.findByCommentId(commentId);
    }

    /**
     * Retrieves a reaction by its id
     * Handles the case where the reaction might not be found.
     * 
     * @param id the id of the reaction
     * @return the reaction with the given id or null if not found
     */
    @Override
    public Reaction getReactionById(Integer id) {
        // Use Optional to handle the case where the reaction is not found
        Optional<Reaction> reaction = reactionRepository.findById(id);
        return reaction.orElse(null);
    }

    /**
     * Deletes a reaction by its id
     * 
     * @param id the id of the reaction to be deleted
     */
    @Override
    public void deleteReaction(Integer id) {
        reactionRepository.deleteById(id);
    }

    /**
     * Counts reactions by type for a given post
     * 
     * @param postId       the id of the post
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the post
     */
    @Override
    public Long countReactionsByTypeForPost(Integer postId, ReactionType reactionType) {
        // Count reactions by post id and reaction type
        return reactionRepository.countByPostIdAndReactionType(postId, reactionType);
    }

    /**
     * Counts reactions by type for a given comment.
     * 
     * @param commentId    the id of the comment
     * @param reactionType the type of reaction to count
     * @return the number of reactions of the specified type for the comment
     */
    @Override
    public Long countReactionsByTypeForComment(Integer commentId, ReactionType reactionType) {
        // Count reactions by comment id and reaction type
        return reactionRepository.countByCommentIdAndReactionType(commentId, reactionType);
    }
}
