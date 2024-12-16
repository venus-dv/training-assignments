package com.revature.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.socialnetwork.repository.PostRepository;
import com.revature.socialnetwork.repository.UserRepository;

/**
 * Business rules and logic of Posts
*/
@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
}
