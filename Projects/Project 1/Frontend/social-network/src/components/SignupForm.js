import React, { useState } from 'react';
import { TextField, Button, Container, Typography } from '@mui/material';
import {signup} from "../api/sessionApi";
import {useNavigate} from "react-router-dom";

const SignupForm = ({ user, handleChange, handleSubmit }) => {

    const navigate = useNavigate();

    const [userDetails, setUser] = useState({
        first_name: '',
        last_name: '',
        email: '',
        password: ''
    });

    const handleFieldChange = (e) => {
        const { name, value } = e.target;
        setUser(prevState => ({ ...prevState, [name]: value }));
    };

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            const data = await signup(
                userDetails.first_name,
                userDetails.last_name,
                userDetails.email,
                userDetails.password
            );

            alert("Thank you for signing up! You'll be redirected and be able to login now")
            navigate('/login');
        } catch (err) {

        }
    };
    
    return (
        <Container maxWidth="sm">
            <Typography variant="h4" component="h1" gutterBottom>
                Signup
            </Typography>
            <form onSubmit={handleRegister}>
                <TextField
                    label="First Name"
                    name="first_name"
                    value={userDetails.first_name}
                    onChange={handleFieldChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Last Name"
                    name="last_name"
                    value={userDetails.last_name}
                    onChange={handleFieldChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Email"
                    name="email"
                    value={userDetails.email}
                    onChange={handleFieldChange}
                    fullWidth
                    margin="normal"
                />
                <TextField
                    label="Password"
                    type="password"
                    name="password"
                    value={userDetails.password}
                    onChange={handleFieldChange}
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
