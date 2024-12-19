package com.revature.socialnetwork.controller;

import com.revature.socialnetwork.entity.Friend;
import com.revature.socialnetwork.entity.FriendStatus;
import com.revature.socialnetwork.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing friend relationships
 */
@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * Sends a friend request from one user to another
     *
     * @param userId the id of the user sending the friend request
     * @param friendId the id of the user receiving the friend request
     * @return a response indicating the result of the operation
     */
    @PostMapping("/request")
    public ResponseEntity<Void> sendFriendRequest(@RequestParam int userId, @RequestParam int friendId) {
        friendService.sendFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    /**
     * Accepts a friend request
     *
     * @param userId the id of the user accepting the friend request
     * @param friendId the id of the user who sent the friend request
     * @return a response indicating the result of the operation.
     */
    @PostMapping("/accept")
    public ResponseEntity<Void> acceptFriendRequest(@RequestParam int userId, @RequestParam int friendId) {
        friendService.acceptFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    /**
     * Declines a friend request
     *
     * @param userId the id of the user declining the friend request
     * @param friendId the id of the user who sent the friend request
     * @return a response indicating the result of the operation
     */
    @PostMapping("/decline")
    public ResponseEntity<Void> declineFriendRequest(@RequestParam int userId, @RequestParam int friendId) {
        friendService.declineFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    /**
     * Removes a friend
     *
     * @param userId the id of the user removing the friend
     * @param friendId the id of the friend being removed
     * @return a response indicating the result of the operation
     */
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFriend(@RequestParam int userId, @RequestParam int friendId) {
        friendService.removeFriend(userId, friendId);
        return ResponseEntity.ok().build();
    }

    /**
     * Gets the list of friends for a user
     *
     * @param userId the id of the user whose friends are being retrieved
     * @return the list of friends
     */
    @GetMapping("/{userId}/friends")
    public ResponseEntity<List<Friend>> getFriends(@PathVariable int userId) {
        List<Friend> friends = friendService.getFriends(userId);
        return ResponseEntity.ok(friends);
    }

    /**
     * Gets the status of a friendship between two users
     *
     * @param userId the id of the user
     * @param friendId the id of the friend
     * @return the status of the friendship
     */
    @GetMapping("/status")
    public ResponseEntity<FriendStatus> getFriendshipStatus(@RequestParam int userId, @RequestParam int friendId) {
        FriendStatus status = friendService.getFriendshipStatus(userId, friendId);
        return ResponseEntity.ok(status);
    }
}
