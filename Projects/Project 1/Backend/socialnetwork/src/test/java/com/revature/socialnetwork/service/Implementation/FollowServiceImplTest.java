package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Follow;
import com.revature.socialnetwork.repository.FollowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FollowServiceImplTest {

    private static final Logger logger = Logger.getLogger("FollowServiceImplTest");

    @Mock
    private FollowRepository followRepository;

    @InjectMocks
    private FollowServiceImpl followService;

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
    void testFollowUser() {
        Follow follow = new Follow();
        follow.setFollower(follow.getFollower());
        follow.setFollow(follow.getFollow());

        logger.info("Following a user");
        followService.followUser(follow);

        verify(followRepository, times(1)).save(follow);
        logger.info("User followed successfully");
    }

    @Test
    void testUnfollowUser() {
        int followId = 1;

        doNothing().when(followRepository).deleteById(followId);

        logger.info("Unfollowing a user");
        followService.unfollowUser(followId);

        verify(followRepository, times(1)).deleteById(followId);
        logger.info("User unfollowed successfully");
    }

    @Test
    void testGetFollowers() {
        int userId = 1;
        List<Follow> followers = List.of(new Follow(), new Follow());

        when(followRepository.findByFollowId(userId)).thenReturn(followers);

        logger.info("Retrieving followers by user ID");
        List<Follow> foundFollowers = followService.getFollowers(userId);

        assertNotNull(foundFollowers);
        assertFalse(foundFollowers.isEmpty());
        verify(followRepository, times(1)).findByFollowId(userId);
        logger.info("Followers retrieved successfully");
    }

    @Test
    void testGetFollowees() {
        int userId = 1;
        List<Follow> followees = List.of(new Follow(), new Follow());

        when(followRepository.findByFollowerId(userId)).thenReturn(followees);

        logger.info("Retrieving followees by user ID");
        List<Follow> foundFollowees = followService.getFollowees(userId);

        assertNotNull(foundFollowees);
        assertFalse(foundFollowees.isEmpty());
        verify(followRepository, times(1)).findByFollowerId(userId);
        logger.info("Followees retrieved successfully");
    }
}
