package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.Follow;
import java.util.List;

/**
 * Interface for Follow Service to define the contract for follow-related
 * operations.
 */
public interface FollowService {

    /**
     * Follows a user
     * 
     * @param follow the follow relationship to be created
     * @return the created follow relationship
     */
    Follow followUser(Follow follow);

    /**
     * Unfollows a user
     * 
     * @param followId the ID of the follow relationship to be deleted
     */
    void unfollowUser(int followId);

    /**
     * Retrieves the followers of a user
     * 
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the followee
     */
    List<Follow> getFollowers(int userId);

    /**
     * Retrieves the users followed by a user
     * 
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the follower
     */
    List<Follow> getFollowees(int userId);
}
