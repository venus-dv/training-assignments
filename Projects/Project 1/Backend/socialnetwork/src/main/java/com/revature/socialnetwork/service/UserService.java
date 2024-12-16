package com.revature.socialnetwork.service;

import com.revature.socialnetwork.entity.User;
import java.util.List;

/**
 * Interface for User Service to define the contract for user-related
 * operations.
 */
public interface UserService {

    /**
     * Registers a new user.
     * 
     * @param user the user to be registered
     * @return the registered user
     */
    User registerUser(User user);

    /**
     * Logs in a user with given email and password.
     * 
     * @param email    the user's email
     * @param password the user's password
     * @return the authenticated user
     */
    User loginUser(String email, String password);

    /**
     * Retrieves a user by their ID.
     * 
     * @param id the user's ID
     * @return the user with the given ID
     */
    User getUserById(Integer id);

    /**
     * Updates the profile of an existing user.
     * 
     * @param user the user with updated profile information
     * @return the updated user
     */
    User updateUserProfile(User user);

    /**
     * Searches for users by a given keyword.
     * 
     * @param keyword the keyword to search for (username or email)
     * @return a list of users matching the keyword
     */
    List<User> searchUsers(String keyword);
}
