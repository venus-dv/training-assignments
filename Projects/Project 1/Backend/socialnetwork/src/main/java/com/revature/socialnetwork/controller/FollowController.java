package com.revature.socialnetwork.controller;

import com.revature.socialnetwork.entity.Follow;
import com.revature.socialnetwork.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing follow relationships between users.
 */
@RestController
@RequestMapping("/api/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * Follows a user
     *
     * @param follow the follow relationship to be created
     * @return the created follow relationship
     */
    @PostMapping
    public ResponseEntity<Follow> followUser(@RequestBody Follow follow) {
        Follow createdFollow = followService.followUser(follow);
        return ResponseEntity.ok(createdFollow);
    }

    /**
     * Unfollows a user
     *
     * @param followId the id of the follow relationship to be deleted
     * @return a response indicating the result of the operation
     */
    @DeleteMapping("/{followId}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Integer followId) {
        followService.unfollowUser(followId);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves the followers of a user
     *
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the followee
     */
    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<Follow>> getFollowers(@PathVariable Integer userId) {
        List<Follow> followers = followService.getFollowers(userId);
        return ResponseEntity.ok(followers);
    }

    /**
     * Retrieves the users followed by a user
     *
     * @param userId the id of the user
     * @return a list of follow relationships where the user is the follower
     */
    @GetMapping("/{userId}/followees")
    public ResponseEntity<List<Follow>> getFollowees(@PathVariable Integer userId) {
        List<Follow> followees = followService.getFollowees(userId);
        return ResponseEntity.ok(followees);
    }
}
