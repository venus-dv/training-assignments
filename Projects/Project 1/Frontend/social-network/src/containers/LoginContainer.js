import React, { useState } from 'react';
import LoginPage from '../components/LoginPage';

const LoginContainer = () => {
    const [credentials, setCredentials] = useState({
        email: '',
        password: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials({
            ...credentials,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Implement login logic here
            console.log('Login', credentials);
        } catch (error) {
            console.error('Error logging in:', error);
        }
    };

    return (
        <LoginPage
            credentials={credentials}
            handleChange={handleChange}
            handleSubmit={handleSubmit}
        />
    );
};

export default LoginContainer;
