package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.Friend;
import com.revature.socialnetwork.entity.FriendStatus;

import java.util.List;

/**
 * Service interface for managing friend operations
 */
public interface FriendService {
    
    /**
     * Sends a friend request from one user to another
     *
     * @param userId the id of the user sending the friend request
     * @param friendId the id of the user receiving the friend request
     */
    void sendFriendRequest(int userId, int friendId);
    
    /**
     * Accepts a friend request
     *
     * @param userId the id of the user accepting the friend request
     * @param friendId the id of the user who sent the friend request
     */
    void acceptFriendRequest(int userId, int friendId);
    
    /**
     * Declines a friend request
     *
     * @param userId the id of the user declining the friend request
     * @param friendId the id of the user who sent the friend request
     */
    void declineFriendRequest(int userId, int friendId);
    
    /**
     * Removes a friend
     *
     * @param userId the id of the user removing the friend
     * @param friendId the id of the friend being removed
     */
    void removeFriend(int userId, int friendId);
    
    /**
     * Gets the list of friends for a user
     *
     * @param userId the id of the user whose friends are being retrieved
     * @return the list of friends
     */
    List<Friend> getFriends(int userId);

    /**
     * Gets the status of a friendship between two users
     *
     * @param userId the id of the user
     * @param friendId the id of the friend
     * @return the status of the friendship
     */
    FriendStatus getFriendshipStatus(int userId, int friendId);
}
