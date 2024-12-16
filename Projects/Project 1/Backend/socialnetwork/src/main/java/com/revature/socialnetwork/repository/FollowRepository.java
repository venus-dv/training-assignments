package com.revature.socialnetwork.repository;

import com.revature.socialnetwork.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    List<Follow> findByFollowerId(Integer followerId);

    List<Follow> findByFollowId(Integer followId);
}
