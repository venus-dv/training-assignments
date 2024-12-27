package com.revature.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.revature.socialnetwork.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Custom query method to find a user by their email and password for
     * authentication purposes
     * 
     * @param email    user's email
     * @param password user's password
     * @return the user with the given email and password
     */
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:keyword%")
    List<User> searchUsers(@Param("keyword") String keyword);
}
