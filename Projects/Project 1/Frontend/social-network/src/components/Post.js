import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { Card, CardContent, Typography, Avatar, Box, Button, TextField } from '@mui/material';
import {getUser, saveComments} from "../api/sessionApi";

const Post = ({ post }) => {
    const [showComments, setShowComments] = useState(false);
    const [comments, setComments] = useState(post.comments || []);
    const [newComment, setNewComment] = useState('');
    const userName = `${post.user.firstName} ${post.user.lastName}`;

    const handleToggleComments = () => {
        setShowComments(!showComments);
    };

    const handleAddComment = async () => {
        if (newComment.trim()) {
            const newCommentObj = { text: newComment, user: localStorage.getItem('username') };
            setComments(prevComments => [...prevComments, newCommentObj]);

            const storedUserId = localStorage.getItem('userId');
            const user = await getUser(storedUserId);

            await saveComments(newComment, post, user);
            setNewComment('');
        }
    };


    const handleSaveComment = async (e) => {
        setNewComment(e.target.value);
    };

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/comments/post/${post.id}`);
                const comments = response.data;

                const formattedComments = comments.map(comment => {
                    return {
                        text: comment.content,
                        user: `${comment.userId.firstName} ${comment.userId.lastName}`
                    };
                });

                setComments(formattedComments);
            } catch (error) {
                // console.error('Error fetching comments:', error);
            }
        };

        fetchPosts();
    }, [post.id]);


    return (
        <Card sx={{ marginBottom: 4 }}>
            <CardContent>
                <Box display="flex" alignItems="center" mb={2}>
                    <Avatar sx={{ mr: 2 }} src={post.user.profilePicUrl} alt={userName}>
                        {userName.charAt(0).toUpperCase()}
                    </Avatar>
                    <Typography variant="h6">{userName}</Typography>
                </Box>
                <Typography variant="body1" sx={{ mb: 2 }}>{post.body}</Typography>
                {post.mediaUrl && <img src={post.mediaUrl} alt="Post media" style={{ maxWidth: '100%', marginTop: '1rem' }} />}
                <Button onClick={handleToggleComments} sx={{ mt: 2 }}>
                    {showComments ? 'Hide Comments' : 'Show Comments'}
                </Button>
                {showComments && (
                    <Box mt={2}>
                        {comments.map((comment, index) => (
                            <Box key={index} mb={2}>
                                <Typography variant="body2"><strong>{comment.user}:</strong> {comment.text}</Typography>
                            </Box>
                        ))}
                        <Box display="flex" alignItems="center" mt={2}>
                            <TextField
                                label="Add a comment"
                                variant="outlined"
                                fullWidth
                                value={newComment}
                                onChange={handleSaveComment}
                            />
                            <Button onClick={handleAddComment} sx={{ ml: 2 }}>
                                Post
                            </Button>
                        </Box>
                    </Box>
                )}
            </CardContent>
        </Card>
    );
};

export default Post;
