import React, { useState } from 'react';
import LoginForm from "../components/LoginForm";
import {login} from "../api/sessionApi";
import {useNavigate} from "react-router-dom";

const LoginPage = () => {
    const [loginDetails, setLoginDetails] = useState({ email: '', password: '' });
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setLoginDetails((prevDetails) => ({
            ...prevDetails,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            const data = await login(loginDetails.email, loginDetails.password);
            console.log('Login attempt with:', loginDetails);
            if (data.length <= 0){
                localStorage.setItem('username', "");
                alert("Email or password is incorrect. Try again.");
            } else {
                localStorage.setItem('username', data);
                localStorage.setItem('email', loginDetails.email);
                navigate('/home');
            }
        } catch (err) {
            setError('Invalid login credentials');
        }
    };

    return (
        <LoginForm
            loginDetails={loginDetails}
            handleChange={handleChange}
            handleSubmit={handleSubmit}
            error={error}
        />
    );
};

export default LoginPage;
