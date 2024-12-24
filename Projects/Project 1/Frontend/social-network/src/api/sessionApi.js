import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/users';

export const login = async (email, password) => {
    const loginInfo = {
        'email': email,
        'password': password
    };
    const response = await axios.post(`${API_BASE_URL}/login`, loginInfo);
    return response.data;
};

export const getSession = async () => {
    const response = await axios.get(`${API_BASE_URL}/session/get`);
    return response.data;
};

export const invalidateSession = async () => {
    const response = await axios.get(`${API_BASE_URL}/session/invalidate`);
    return response.data;
};
