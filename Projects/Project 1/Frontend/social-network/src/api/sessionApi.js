import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/users';
const API_COMMENTS_URL = 'http://localhost:8080/api/comments';
const API_POSTS_URL = 'http://localhost:8080/api/posts';

export const login = async (email, password) => {
    const loginInfo = {
        'email': email,
        'password': password
    };
    const response = await axios.post(`${API_BASE_URL}/login`, loginInfo);
    return response.data;
};

export const signup = async (firstName, lastName, email, password) => {
    const signupInfo = {
        'firstName': firstName,
        'lastName': lastName,
        'email': email,
        'password': password,
        'birthdate': new Date().toISOString(),
        'profilePicUrl': '',
        'createdAt': new Date().toISOString(),
        'updatedAt': new Date().toISOString()
    };
    const response = await axios.post(`${API_BASE_URL}`, signupInfo);
    return response.data;
};

export const getUser = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/${id}`);
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

export const saveComments = async (content, post, user) => {
    const commentInfo = {
        "content": content,
        "createdAt": new Date().toISOString(),
        "post": post,
        "userId": user
    };

    const response = await axios.post(`${API_COMMENTS_URL}`, commentInfo);
    return response.data;
};

export const createPost = async (body, mediaURL, user) => {
    const postInfo = {
        "body": body,
        "createdAt": new Date().toISOString(),
        "mediaUrl": mediaURL,
        "updatedAt": new Date().toISOString(),
        "user": user
    };

    const response = await axios.post(`${API_POSTS_URL}`, postInfo);
    return response.data;
};
