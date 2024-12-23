import React from 'react';
import { Button, Container, Typography, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const LandingPage = () => {
    const navigate = useNavigate();

    const handleLoginClick = () => {
        navigate('/login');
    };

    const handleSignupClick = () => {
        navigate('/signup');
    };

    return (
        <Container maxWidth="sm">
            <Box textAlign="center" mt={5}>
                <Typography variant="h4" component="h1" gutterBottom>
                    Welcome
                </Typography>
                <Button variant="contained" color="primary" onClick={handleLoginClick} sx={{ m: 1 }}>
                    Login
                </Button>
                <Button variant="contained" color="secondary" onClick={handleSignupClick} sx={{ m: 1 }}>
                    Sign Up
                </Button>
            </Box>
        </Container>
    );
};

export default LandingPage;
