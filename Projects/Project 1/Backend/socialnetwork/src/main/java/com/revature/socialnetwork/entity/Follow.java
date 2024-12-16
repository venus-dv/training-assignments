package com.revature.socialnetwork.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * This class models a follow relationship between users
 */
@Entity
@Table(name = "follows")
public class Follow {

    /**
     * The date when this follow relationship was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /**
     * The user who is being followed
     */
    @ManyToOne
    @JoinColumn(name = "follow_id")
    private User follow;

    /**
     * The user who is following
     */
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    /**
     * No-args constructor
     */
    public Follow() {
        this.createdAt = new Date();
    }

    /**
     * All-args constructor
     * 
     * @param createdAt the date the follow relationship was created
     * @param follow    the user being followed
     * @param follower  the user who is following
     */
    public Follow(Date createdAt, User follow, User follower) {
        this.createdAt = createdAt;
        this.follow = follow;
        this.follower = follower;
    }

    /**
     * Gets the date when the follow relationship was created
     * 
     * @return the creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the date when the follow relationship was created
     * 
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the user being followed
     * 
     * @return the user being followed
     */
    public User getFollow() {
        return follow;
    }

    /**
     * Sets the user being followed
     * 
     * @param follow the user to set
     */
    public void setFollow(User follow) {
        this.follow = follow;
    }

    /**
     * Gets the user who is following
     * 
     * @return the user who is following
     */
    public User getFollower() {
        return follower;
    }

    /**
     * Sets the user who is following
     * 
     * @param follower the user to set
     */
    public void setFollower(User follower) {
        this.follower = follower;
    }
}
