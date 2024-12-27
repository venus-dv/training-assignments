import React from 'react';
import Post from './Post';
import {Box, Container, Typography} from '@mui/material';

const Feed = ({ posts }) => {
    return (
        <Container maxWidth="md">
            <Box mt={4}>
                {posts.length > 0 ? (
                    posts.map((post) => (
                    <Post key={post.id} post={post} />
                    ))
                ) : (
                    <Typography variant="h6" align="center">
                        No posts to display :(
                    </Typography>
                )}
            </Box>
        </Container>
    );
};

export default Feed;
