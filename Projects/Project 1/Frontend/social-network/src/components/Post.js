import React from 'react';
import { Card, CardContent, Typography, Avatar, Box } from '@mui/material';

const Post = ({ post }) => {
    return (
        <Card sx={{ marginBottom: 2 }}>
            <CardContent>
                <Box display="flex" alignItems="center" mb={2}>
                    <Avatar sx={{ mr: 2 }}>
                        {/*{post.user.charAt(0).toUpperCase()}*/}
                        Avatar
                    </Avatar>
                    <Typography variant="h6">{post.user}</Typography>
                </Box>
                <Typography variant="body1" sx={{ mb: 2 }}>{post.body}</Typography>
            </CardContent>
        </Card>
    );
};

export default Post;
