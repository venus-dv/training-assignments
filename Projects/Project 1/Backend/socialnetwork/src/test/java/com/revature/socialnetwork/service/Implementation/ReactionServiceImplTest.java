package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Reaction;
import com.revature.socialnetwork.entity.ReactionType;
import com.revature.socialnetwork.repository.ReactionRepository;
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
public class ReactionServiceImplTest {

    private static final Logger logger = Logger.getLogger("ReactionServiceImplTest");

    @Mock
    private ReactionRepository reactionRepository;

    @InjectMocks
    private ReactionServiceImpl reactionService;

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
    void testAddReaction() {
        Reaction reaction = new Reaction();
        reaction.setReactionType(ReactionType.LIKE);

        logger.info("Adding a new reaction");
        reactionService.addReaction(reaction);

        verify(reactionRepository, times(1)).save(reaction);
        logger.info("Reaction added successfully");
    }

    @Test
    void testGetReactionsByPostId() {
        int postId = 1;
        List<Reaction> reactions = List.of(new Reaction(), new Reaction());

        when(reactionRepository.findByPostId(postId)).thenReturn(reactions);

        logger.info("Retrieving reactions by post ID");
        List<Reaction> foundReactions = reactionService.getReactionsByPostId(postId);

        assertNotNull(foundReactions);
        assertFalse(foundReactions.isEmpty());
        verify(reactionRepository, times(1)).findByPostId(postId);
        logger.info("Reactions retrieved successfully");
    }

    @Test
    void testGetReactionsByCommentId() {
        int commentId = 1;
        List<Reaction> reactions = List.of(new Reaction(), new Reaction());

        when(reactionRepository.findByCommentId(commentId)).thenReturn(reactions);

        logger.info("Retrieving reactions by comment ID");
        List<Reaction> foundReactions = reactionService.getReactionsByCommentId(commentId);

        assertNotNull(foundReactions);
        assertFalse(foundReactions.isEmpty());
        verify(reactionRepository, times(1)).findByCommentId(commentId);
        logger.info("Reactions retrieved successfully");
    }

    @Test
    void testGetReactionById() {
        int reactionId = 1;
        Reaction reaction = new Reaction();
        reaction.setId(reactionId);

        when(reactionRepository.findById(reactionId)).thenReturn(Optional.of(reaction));

        logger.info("Retrieving reaction by ID");
        Reaction foundReaction = reactionService.getReactionById(reactionId);

        assertNotNull(foundReaction);
        assertEquals(reactionId, foundReaction.getId());
        verify(reactionRepository, times(1)).findById(reactionId);
        logger.info("Reaction retrieved successfully");
    }

    @Test
    void testDeleteReaction() {
        int reactionId = 1;

        doNothing().when(reactionRepository).deleteById(reactionId);

        logger.info("Deleting reaction by ID");
        reactionService.deleteReaction(reactionId);

        verify(reactionRepository, times(1)).deleteById(reactionId);
        logger.info("Reaction deleted successfully");
    }

    @Test
    void testCountReactionsByTypeForPost() {
        int postId = 1;
        ReactionType reactionType = ReactionType.LIKE;
        int reactionCount = 5;

        when(reactionRepository.countByPostIdAndReactionType(postId, reactionType)).thenReturn(reactionCount);

        logger.info("Counting reactions by type for post");
        int count = reactionService.countReactionsByTypeForPost(postId, reactionType);

        assertEquals(reactionCount, count);
        verify(reactionRepository, times(1)).countByPostIdAndReactionType(postId, reactionType);
        logger.info("Reactions counted successfully");
    }

    @Test
    void testCountReactionsByTypeForComment() {
        int commentId = 1;
        ReactionType reactionType = ReactionType.LIKE;
        int reactionCount = 3;

        when(reactionRepository.countByCommentIdAndReactionType(commentId, reactionType)).thenReturn(reactionCount);

        logger.info("Counting reactions by type for comment");
        int count = reactionService.countReactionsByTypeForComment(commentId, reactionType);

        assertEquals(reactionCount, count);
        verify(reactionRepository, times(1)).countByCommentIdAndReactionType(commentId, reactionType);
        logger.info("Reactions counted successfully");
    }
}
