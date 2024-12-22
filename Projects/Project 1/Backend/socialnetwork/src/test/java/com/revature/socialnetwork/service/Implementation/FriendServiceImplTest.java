package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Friend;
import com.revature.socialnetwork.entity.FriendStatus;
import com.revature.socialnetwork.repository.FriendRepository;
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
public class FriendServiceImplTest {

    private static final Logger logger = Logger.getLogger("FriendServiceImplTest");

    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private FriendServiceImpl friendService;

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
    void testSendFriendRequest() {
        Friend friend = new Friend(1, 2, FriendStatus.REQUESTED);

        logger.info("Sending friend request");
        friendService.sendFriendRequest(1, 2);

        verify(friendRepository, times(1)).save(any(Friend.class));
        logger.info("Friend request sent successfully");
    }

    @Test
    void testAcceptFriendRequest() {
        int userId = 1;
        int friendId = 2;
        Friend friend = new Friend(userId, friendId, FriendStatus.REQUESTED);

        when(friendRepository.findByUserIdAndFriendId(userId, friendId)).thenReturn(friend);

        logger.info("Accepting friend request");
        friendService.acceptFriendRequest(userId, friendId);

        assertEquals(FriendStatus.ACCEPTED, friend.getStatus());
        verify(friendRepository, times(1)).save(friend);
        logger.info("Friend request accepted successfully");
    }

    @Test
    void testDeclineFriendRequest() {
        int userId = 1;
        int friendId = 2;
        Friend friend = new Friend(userId, friendId, FriendStatus.REQUESTED);

        when(friendRepository.findByUserIdAndFriendId(userId, friendId)).thenReturn(friend);

        logger.info("Declining friend request");
        friendService.declineFriendRequest(userId, friendId);

        assertEquals(FriendStatus.DECLINED, friend.getStatus());
        verify(friendRepository, times(1)).save(friend);
        logger.info("Friend request declined successfully");
    }

    @Test
    void testRemoveFriend() {
        int userId = 1;
        int friendId = 2;

        doNothing().when(friendRepository).deleteByUserIdAndFriendId(userId, friendId);

        logger.info("Removing friend");
        friendService.removeFriend(userId, friendId);

        verify(friendRepository, times(1)).deleteByUserIdAndFriendId(userId, friendId);
        logger.info("Friend removed successfully");
    }

    @Test
    void testGetFriends() {
        int userId = 1;
        List<Friend> friends = List.of(new Friend(), new Friend());

        when(friendRepository.findByUserIdAndStatus(userId, FriendStatus.ACCEPTED)).thenReturn(friends);

        logger.info("Retrieving friends");
        List<Friend> foundFriends = friendService.getFriends(userId);

        assertNotNull(foundFriends);
        assertFalse(foundFriends.isEmpty());
        verify(friendRepository, times(1)).findByUserIdAndStatus(userId, FriendStatus.ACCEPTED);
        logger.info("Friends retrieved successfully");
    }

    @Test
    void testGetFriendshipStatus() {
        int userId = 1;
        int friendId = 2;
        Friend friend = new Friend(userId, friendId, FriendStatus.ACCEPTED);

        when(friendRepository.findByUserIdAndFriendId(userId, friendId)).thenReturn(friend);

        logger.info("Retrieving friendship status");
        FriendStatus status = friendService.getFriendshipStatus(userId, friendId);

        assertNotNull(status);
        assertEquals(FriendStatus.ACCEPTED, status);
        verify(friendRepository, times(1)).findByUserIdAndFriendId(userId, friendId);
        logger.info("Friendship status retrieved successfully");
    }
}
