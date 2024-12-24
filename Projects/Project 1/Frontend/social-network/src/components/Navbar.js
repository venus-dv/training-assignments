import React, {useEffect, useState} from 'react';
import { AppBar, Toolbar, Button, Typography, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import {invalidateSession} from "../api/sessionApi";

const Navbar = () => {
    const navigate = useNavigate();

    const [username, setUsername] = useState(null);

    useEffect(() => {
        const storedUsername = localStorage.getItem('username');
        if (storedUsername) {
            setUsername(storedUsername);
        }
    })

    const handleNavigation = (path) => {
        navigate(path);
    };

    const handleLogout = async () => {
        try {
            const data = await invalidateSession();
            localStorage.setItem('username', null)
            navigate('/')
        } catch (err) {
            console.error('Invalid login credentials');
        }
    };

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" sx={{ flexGrow: 1 }}>
                    ChitChat
                </Typography>
                <p>Welcome, {username}</p>
                <Box>
                    <Button color="inherit" onClick={() => handleNavigation('/profile')}>Profile</Button>
                    <Button color="inherit" onClick={() => handleLogout()}>Sign Out</Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;
