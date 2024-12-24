import React from 'react';
import { Card, CardContent, Typography, Avatar, Box } from '@mui/material';

const Post = ({ post }) => {
    const userName =  `${post.user.firstName} ${post.user.lastName}`;

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
            </CardContent>
        </Card>
    );
};

export default Post;
