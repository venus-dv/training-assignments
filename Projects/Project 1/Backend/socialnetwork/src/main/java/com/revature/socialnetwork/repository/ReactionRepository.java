package com.revature.socialnetwork.repository;

import com.revature.socialnetwork.entity.Reaction;
import com.revature.socialnetwork.entity.ReactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer> {
    List<Reaction> findByPostId(Integer postId);

    List<Reaction> findByCommentId(Integer commentId);

    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.post.id = :postId AND r.reactionType = :reactionType")
    Long countByPostIdAndReactionType(@Param("postId") Integer postId,
            @Param("reactionType") ReactionType reactionType);
}
