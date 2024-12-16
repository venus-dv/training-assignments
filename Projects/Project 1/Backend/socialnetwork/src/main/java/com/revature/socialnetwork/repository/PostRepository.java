package com.revature.socialnetwork.repository;

import com.revature.socialnetwork.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);

    @Query("SELECT p FROM Post p WHERE p.body LIKE %:keyword%")
    List<Post> searchPosts(@Param("keyword") String keyword);
}
