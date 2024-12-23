package com.revature.socialnetwork.service.Implementation;

import com.revature.socialnetwork.entity.User;
import com.revature.socialnetwork.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private static final Logger logger = Logger.getLogger("UserServiceImplTest");

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        try {
            MockitoAnnotations.openMocks(this);
            logger.info("Setting up the test environment");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    String email = "john.doe@email.com";
    String password = "password";

    @Test
    void testRegisterUser() {
        User user = new User(email, password);

        logger.info("Registering a new user");
        userService.registerUser(user);

        verify(userRepository, times(1)).save(user);
        logger.info("User registered successfully");

    }

    @Test
    void testLoginUser() {
        User user = new User(email, password);
        when(userRepository.findByEmailAndPassword(email, password)).thenReturn(user);

        logger.info("Logging in user");
        User loggedInUser = userService.loginUser(email, password);
        assertNotNull(loggedInUser);
        assertEquals(email, loggedInUser.getEmail());
        verify(userRepository, times(1)).findByEmailAndPassword(email, password);
        logger.info("User logged in successfully");
    }

    @Test
    void testGetUserById() {
        int userId = 1;
        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        logger.info("Retrieving user by ID");
        User foundUser = userService.getUserById(userId);
        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
        verify(userRepository, times(1)).findById(userId);
        logger.info("User retrieved successfully");
    }

    @Test
    void testUpdateUserProfile() {
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setEmail("jane.doe@email.com");
        when(userRepository.save(user)).thenReturn(user);

        logger.info("Updating user profile");
        User updatedUser = userService.updateUserProfile(userId, user);
        assertNotNull(updatedUser);
        assertEquals("jane.doe@email.com", updatedUser.getEmail());
        verify(userRepository, times(1)).save(user);
        logger.info("User profile updated successfully");
    }

    @Test
    void testDeleteUser() {
        int userId = 1;
        doNothing().when(userRepository).deleteById(userId);

        logger.info("Deleting user by ID");
        boolean isDeleted = userService.deleteUser(userId);
        assertTrue(isDeleted);
        verify(userRepository, times(1)).deleteById(userId);
        logger.info("User deleted successfully");
    }

    @Test
    void testSearchUsers() {
        String keyword = "john";
        // Assuming you have a list of users returned for the search
        List<User> users = List.of(new User(), new User());
        when(userRepository.searchUsers(keyword)).thenReturn(users);

        logger.info("Searching users by keyword");
        List<User> foundUsers = userService.searchUsers(keyword);
        assertNotNull(foundUsers);
        assertFalse(foundUsers.isEmpty());
        verify(userRepository, times(1)).searchUsers(keyword);
        logger.info("Users found successfully");
    }

    @Test
    void testGetAllUsers() {
        // Assuming you have a list of users returned for the search
        List<User> users = List.of(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        logger.info("Retrieving all users");
        List<User> allUsers = userService.getAllUsers();
        assertNotNull(allUsers);
        assertFalse(allUsers.isEmpty());
        verify(userRepository, times(1)).findAll();
        logger.info("All users retrieved successfully");
    }
}
