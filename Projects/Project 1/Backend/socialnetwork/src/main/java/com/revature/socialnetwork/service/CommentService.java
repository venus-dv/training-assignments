package com.revature.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.socialnetwork.repository.CommentRepository;

/**
 * Business rules and logic of Comments
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
}
