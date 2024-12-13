CREATE TABLE `users` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(255), 
	`password` VARCHAR(255), 
	`email` VARCHAR(255) UNIQUE, 
	`birthdate` DATE, 
	`profile_picture_url` VARCHAR(255), 
	`bio` TEXT, 
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP 
);
CREATE TABLE `follows` (
	`follower_id` INTEGER, 
    `follow_id` INTEGER, 
    `created_at` TIMESTAMP, 
    FOREIGN KEY (`follower_id`) REFERENCES `users` (`id`), 
    FOREIGN KEY (`follow_id`) REFERENCES `users` (`id`) 
);
CREATE TABLE `posts` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT, 
    `body` TEXT COMMENT 'Content of the post', 
    `user_id` INTEGER, 
    `media_url` VARCHAR(255), 
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) 
);
CREATE TABLE `comments` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT, 
    `post_id` INTEGER, `user_id` INTEGER, 
    `content` TEXT, 
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`), 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) 
);
CREATE TABLE `reactions` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT, 
    `user_id` INTEGER, 
    `post_id` INTEGER, 
    `comment_id` INTEGER, 
    `reaction_type` ENUM('like', 'love', 'dislike', 'wow'), 
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`), 
    FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`), 
    FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`) 
);

-- Indexes for the Users table
CREATE INDEX idx_users_email ON users (email); 
CREATE INDEX idx_users_name ON users (user_name); 

-- Indexes for the Posts table 
CREATE INDEX idx_posts_user_id ON posts (user_id); 

-- Indexes for the Comments table 
CREATE INDEX idx_comments_post_id ON comments (post_id); 
CREATE INDEX idx_comments_user_id ON comments (user_id); 

-- Indexes for the Follows table 
CREATE INDEX idx_follows_follower_id ON follows (follower_id); 
CREATE INDEX idx_follows_follow_id ON follows (follow_id); 

-- Indexes for the Reactions table 
CREATE INDEX idx_reactions_user_id ON reactions (user_id); 
CREATE INDEX idx_reactions_post_id ON reactions (post_id); 
CREATE INDEX idx_reactions_comment_id ON reactions (comment_id);