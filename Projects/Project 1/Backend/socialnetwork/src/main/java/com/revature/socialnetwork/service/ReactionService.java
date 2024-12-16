package com.revature.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.socialnetwork.repository.ReactionRepository;

/**
 * Business rules and logic of Reactions
 */
@Service
public class ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;
}
