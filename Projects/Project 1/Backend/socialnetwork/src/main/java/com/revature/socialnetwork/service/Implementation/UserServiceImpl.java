package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.User;
import com.revature.socialnetwork.repository.UserRepository;
import com.revature.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserService interface.
 * This class provides methods for user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Registers a new user by saving the user entity to the database.
     * 
     * @param user the user to be registered
     * @return the registered user
     */
    @Override
    public User registerUser(User user) {
        // Save the user entity to the database
        return userRepository.save(user);
    }

    /**
     * Logs in a user by checking the email and password.
     * Simple authentication logic
     * 
     * @param email    the user's email
     * @param password the user's password
     * @return the authenticated user
     */
    @Override
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Retrieves a user by their id
     * Handles the case where the user might not be found.
     * 
     * @param id the user's id
     * @return the user with the given ID, or null if not found
     */
    @Override
    public User getUserById(Integer id) {
        // Use Optional to handle the case where the user is not found
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    /**
     * Updates the profile of an existing user.
     * 
     * @param user the user with updated profile information
     * @return the updated user
     */
    @Override
    public User updateUserProfile(User user) {
        // Save the updated user entity to the database
        return userRepository.save(user);
    }

    /**
     * Searches for users by a given keyword in their username or email.
     * 
     * @param keyword the keyword to search for (username or email)
     * @return a list of users matching the keyword
     */
    @Override
    public List<User> searchUsers(String keyword) {
        // Use the custom query method to search for users
        return userRepository.searchUsers(keyword);
    }
}
