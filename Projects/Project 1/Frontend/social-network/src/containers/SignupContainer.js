import React, { useState } from 'react';
import axios from 'axios';
import SignupForm from '../components/SignupForm';

const SignupContainer = () => {
    const [user, setUser] = useState({
        first_name: '',
        last_name: '',
        email: '',
        password: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
    };

    const headers = {
        "Content-Type": "application/json"
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/users/', user, {headers: headers});
            console.log(response.data);
            // Handle successful registration (e.g., redirect to login page or show success message)
        } catch (error) {
            console.error('Error registering user:', error);
            // Handle error (e.g., show error message)
        }
    };

    return <SignupForm user={user} handleChange={handleChange} handleSubmit={handleSubmit} />;
};

export default SignupContainer;
