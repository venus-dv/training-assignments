package com.revature.socialnetwork.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class models a Comment
 */
@Entity
@Table(name = "comments")
public class Comment {

    /**
     * An id for this comment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The content for this comment
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * The date this comment was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * The post id for this comment
     */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * The user who created this comment
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * No-args constructor
     */
    public Comment() {
        this.createdAt = new Date();
    }

    /**
     * All-args constructor
     * 
     * @param id        the id of the comment
     * @param content   the content of the comment
     * @param createdAt the date the comment was created
     * @param post_id   the post associated with the comment
     * @param user      the user who created the comment
     */
    public Comment(Integer id, String content, Date createdAt, Post post, User user) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.post = post;
        this.user = user;
    }

    /**
     * Gets the id of the comment
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the comment
     * 
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the content of the comment
     * 
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the comment
     * 
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the creation date of the comment
     * 
     * @return the creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the comment
     * 
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the post associated with the comment
     * 
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets the post associated with the comment
     * 
     * @param post the post to set
     */
    public void setPostId(Post post) {
        this.post = post;
    }

    /**
     * Gets the user who created the comment
     * 
     * @return the user
     */
    public User getUserId() {
        return user;
    }

    /**
     * Sets the user who created the comment
     * 
     * @param user the user to set
     */
    public void setUserId(User user) {
        this.user = user;
    }
}
