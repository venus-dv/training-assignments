import React from 'react';
import { AppBar, Toolbar, Button, Typography, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const Navbar = () => {
    const navigate = useNavigate();

    const handleNavigation = (path) => {
        navigate(path);
    };

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" sx={{ flexGrow: 1 }}>
                    ChitChat
                </Typography>
                <Box>
                    <Button color="inherit" onClick={() => handleNavigation('/profile')}>Profile</Button>
                    <Button color="inherit" onClick={() => handleNavigation('/signout')}>Sign Out</Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;
