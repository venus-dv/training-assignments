package com.revature.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.socialnetwork.repository.FollowRepository;

/**
 * Business rules and logic of Follows
 */
@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;
}
