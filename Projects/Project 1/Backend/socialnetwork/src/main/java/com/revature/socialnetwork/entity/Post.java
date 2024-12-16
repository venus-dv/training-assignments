package com.revature.socialnetwork.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * This class models a post
 */
@Entity
@Table(name = "posts")
public class Post {

    /**
     * The id for this post
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The content body of this post
     */
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    /**
     * The date this post was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The URL for any media associated with this post
     */
    @Column(name = "media_url")
    private String mediaUrl;

    /**
     * The date this post was last updated
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * The user who created this post
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * No-args constructor
     */
    public Post() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    /**
     * All-args constructor
     * 
     * @param id        the id of the post
     * @param body      the content body of the post
     * @param createdAt the date the post was created
     * @param mediaUrl  the URL for any media associated with the post
     * @param updatedAt the date the post was last updated
     * @param user      the user who created the post
     */
    public Post(Integer id, String body, Date createdAt, String mediaUrl, Date updatedAt, User user) {
        this.id = id;
        this.body = body;
        this.createdAt = createdAt;
        this.mediaUrl = mediaUrl;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    /**
     * Gets the id of the post
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the post
     * 
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the content body of the post
     * 
     * @return the content body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the content body of the post
     * 
     * @param body the content body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the creation date of the post
     * 
     * @return the creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the post
     * 
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the media URL of the post
     * 
     * @return the media URL
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * Sets the media URL of the post
     * 
     * @param mediaUrl the media URL to set
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * Gets the last updated date of the post
     * 
     * @return the last updated date
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated date of the post
     * 
     * @param updatedAt the last updated date to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the user who created the post
     * 
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who created the post
     * 
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
