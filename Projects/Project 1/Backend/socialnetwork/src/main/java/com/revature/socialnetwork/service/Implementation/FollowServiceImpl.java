package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Follow;
import com.revature.socialnetwork.repository.FollowRepository;
import com.revature.socialnetwork.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of FollowService interface
 * This class provides methods for follow-related operations
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    /**
     * Follows a user by saving the follow relationship to the database
     * 
     * @param follow the follow relationship to be created
     * @return the created follow relationship
     */
    @Override
    public Follow followUser(Follow follow) {
        // Save the follow relationship to the database
        return followRepository.save(follow);
    }

    /**
     * Unfollows a user by deleting the follow relationship from the database.
     * 
     * @param followId the ID of the follow relationship to be deleted
     */
    @Override
    public void unfollowUser(Integer followId) {
        followRepository.deleteById(followId);
    }

    /**
     * Retrieves the followers of a user
     * 
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the followee
     */
    @Override
    public List<Follow> getFollowers(Integer userId) {
        // Find follow relationships where the user is the followee
        return followRepository.findByFollowId(userId);
    }

    /**
     * Retrieves the users followed by a user
     * 
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the follower
     */
    @Override
    public List<Follow> getFollowees(Integer userId) {
        // Find follow relationships where the user is the follower
        return followRepository.findByFollowerId(userId);
    }
}
