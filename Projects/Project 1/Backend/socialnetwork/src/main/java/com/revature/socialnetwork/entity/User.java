package com.revature.socialnetwork.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * This class models a user
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * An id for this user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * A first name for this user
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * A last name for this user
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * An email for this user (must be unique, and not blank)
     */
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    /**
     * A password for this user
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * A birthdate for this user
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthdate;

    /**
     * A url for a profile picture of this user
     */
    @Column(name = "profile_picture_url")
    private String profilePicUrl;

    /**
     * A personal bio for this user
     */
    @Column(name = "bio")
    private String bio;

    /**
     * When this user was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * When this user was updated
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * No-args constructor
     */
    public User() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    /**
     * The id can be generated from the database so a constructor without id is
     * needed
     * 
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    /**
     * All-args constructor
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param birthdate
     * @param profilePicUrl
     * @param bio
     * @param createdAt
     * @param updatedAt
     */
    public User(Integer id, String firstName, String lastName, String email, String password, Date birthdate,
            String profilePicUrl, String bio, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.profilePicUrl = profilePicUrl;
        this.bio = bio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the id of the user
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the user
     * 
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the user
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     * 
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     * 
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of the user
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the birthdate of the user
     * 
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the user
     * 
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Gets the profile picture URL of the user
     * 
     * @return the profile picture URL
     */
    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    /**
     * Sets the profile picture URL of the user
     * 
     * @param profilePicUrl the profile picture URL to set
     */
    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    /**
     * Gets the bio of the user
     * 
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the bio of the user
     * 
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Gets the creation date of the user
     * 
     * @return the creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the user
     * 
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last updated date of the user
     * 
     * @return the last updated date
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated date of the user
     * 
     * @param updatedAt the last updated date to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
