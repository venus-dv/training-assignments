import React from 'react';
import { TextField, Button, Container, Typography } from '@mui/material';

const SignupForm = ({ user, handleChange, handleSubmit }) => {
    return (
        <Container maxWidth="sm">
            <Typography variant="h4" component="h1" gutterBottom>
                Signup
            </Typography>
            <form onSubmit={handleSubmit}>
                <TextField
                    label="First Name"
                    name="first_name"
                    value={user.first_name}
                    onChange={handleChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Last Name"
                    name="last_name"
                    value={user.last_name}
                    onChange={handleChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Email"
                    name="email"
                    value={user.email}
                    onChange={handleChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Password"
                    type="password"
                    name="password"
                    value={user.password}
                    onChange={handleChange}
                    fullWidth
                    margin="normal"
                />
                <Button type="submit" variant="contained" color="primary">
                    Register
                </Button>
            </form>
        </Container>
    );
};

export default SignupForm;
