package com.revature.socialnetwork.repository;

import com.revature.socialnetwork.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost_Id(int post_id);

    @Query("SELECT c FROM Comment c WHERE c.content LIKE %:keyword%")
    List<Comment> searchComments(@Param("keyword") String keyword);
}
