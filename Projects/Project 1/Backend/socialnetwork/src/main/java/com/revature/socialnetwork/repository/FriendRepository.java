package com.revature.socialnetwork.repository;

import com.revature.socialnetwork.entity.Friend;
import com.revature.socialnetwork.entity.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing friend relationships
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    /**
     * Finds friends by user id
     * 
     * @param userId the id of the user
     * @return a list of friends
     */
    List<Friend> findByUserId(Integer userId);

    /**
     * Finds friends by friend id
     * 
     * @param friendId the id of the friend
     * @return a list of friends
     */
    List<Friend> findByFriendId(Integer friendId);

    /**
     * Finds friends by user id and status
     * 
     * @param userId the id of the user
     * @param status the status of the friend request
     * @return a list of friends
     */
    List<Friend> findByUserIdAndStatus(Integer userId, FriendStatus status);

    /**
     * Finds friends by friend id and status
     * 
     * @param friendId the id of the friend
     * @param status the status of the friend request
     * @return a list of friends
     */
    List<Friend> findByFriendIdAndStatus(Integer friendId, FriendStatus status);

    /**
     * Finds a friend relationship by user id and friend id.
     * 
     * @param userId the id of the user
     * @param friendId the id of the friend
     * @return the friend relationship
     */
    Friend findByUserIdAndFriendId(Integer userId, Integer friendId);

    /**
     * Deletes a friend relationship by user id and friend id
     * 
     * @param userId the id of the user
     * @param friendId the id of the friend
     */
    void deleteByUserIdAndFriendId(Integer userId, Integer friendId);
}
