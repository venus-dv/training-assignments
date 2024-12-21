package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.Friend;
import com.revature.socialnetwork.entity.FriendStatus;
import com.revature.socialnetwork.repository.FriendRepository;
import com.revature.socialnetwork.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the FriendService interface
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public void sendFriendRequest(int userId, int friendId) {
        Friend friend = new Friend(userId, friendId, FriendStatus.REQUESTED);
        friendRepository.save(friend);
    }

    @Override
    public void acceptFriendRequest(int userId, int friendId) {
        Friend friend = friendRepository.findByUserIdAndFriendId(userId, friendId);
        if (friend != null && friend.getStatus() == FriendStatus.REQUESTED) {
            friend.setStatus(FriendStatus.ACCEPTED);
            friendRepository.save(friend);
        }
    }

    @Override
    public void declineFriendRequest(int userId, int friendId) {
        Friend friend = friendRepository.findByUserIdAndFriendId(userId, friendId);
        if (friend != null && friend.getStatus() == FriendStatus.REQUESTED) {
            friend.setStatus(FriendStatus.DECLINED);
            friendRepository.save(friend);
        }
    }

    @Override
    public void removeFriend(int userId, int friendId) {
        friendRepository.deleteByUserIdAndFriendId(userId, friendId);
    }

    @Override
    public List<Friend> getFriends(int userId) {
        return friendRepository.findByUserIdAndStatus(userId, FriendStatus.ACCEPTED);
    }

    @Override
    public FriendStatus getFriendshipStatus(int userId, int friendId) {
        Friend friend = friendRepository.findByUserIdAndFriendId(userId, friendId);
        return friend != null ? friend.getStatus() : null;
    }
}
