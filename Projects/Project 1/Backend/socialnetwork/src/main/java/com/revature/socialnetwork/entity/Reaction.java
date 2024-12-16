package com.revature.socialnetwork.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * This class models a reaction to posts and comments
 */
@Entity
@Table(name = "reactions")
public class Reaction {

    /**
     * The id for this reaction
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The user who made this reaction
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * The post associated with this reaction
     */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * The comment associated with this reaction
     */
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    /**
     * The type of this reaction (like, love, dislike, wow)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "reaction_type", nullable = false)
    private ReactionType reactionType;

    /**
     * The date this reaction was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * No-args constructor
     */
    public Reaction() {
        this.createdAt = new Date();
    }

    /**
     * All-args constructor
     * 
     * @param id           the id of the reaction
     * @param user         the user who made the reaction
     * @param post         the post associated with the reaction
     * @param comment      the comment associated with the reaction
     * @param reactionType the type of the reaction
     * @param createdAt    the date the reaction was created
     */
    public Reaction(Integer id, User user, Post post, Comment comment, ReactionType reactionType, Date createdAt) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.comment = comment;
        this.reactionType = reactionType;
        this.createdAt = createdAt;
    }

    /**
     * Gets the id of the reaction
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the reaction
     * 
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the user who made the reaction
     * 
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who made the reaction
     * 
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the post associated with the reaction
     * 
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets the post associated with the reaction
     * 
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Gets the comment associated with the reaction
     * 
     * @return the comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the comment associated with the reaction
     * 
     * @param comment the comment to set
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     * Gets the type of the reaction
     * 
     * @return the type of reaction
     */
    public ReactionType getReactionType() {
        return reactionType;
    }

    /**
     * Sets the type of the reaction
     * 
     * @param reactionType the type of reaction to set
     */
    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    /**
     * Gets the creation date of the reaction
     * 
     * @return the creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the reaction
     * 
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
