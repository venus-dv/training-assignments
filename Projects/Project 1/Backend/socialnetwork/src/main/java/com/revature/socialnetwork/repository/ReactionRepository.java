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
    List<Reaction> findByPostId(int postId);

    List<Reaction> findByCommentId(int commentId);

    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.post.id = :postId AND r.reactionType = :reactionType")
    int countByPostIdAndReactionType(@Param("postId") int postId,
            @Param("reactionType") ReactionType reactionType);

    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.comment.id = :commentId AND r.reactionType = :reactionType")
    int countByCommentIdAndReactionType(@Param("commentId") int commentId,
            @Param("reactionType") ReactionType reactionType);
}
