import React, { useState, useEffect } from 'react';
import Navbar from '../components/Navbar';
import Feed from '../components/Feed';
import axios from 'axios';
import { Button, TextField } from '@mui/material';
import {getUser, createPost} from "../api/sessionApi";

const HomepageContainer = () => {
    const [posts, setPosts] = useState({
        body: "",
        createdAt: "",
        mediaUrl: "",
        updatedAt: "",
        user: {
            first_name: "",
            last_name: '',
            email: '',
            password: '',
            birthdate: '',
            profilePicUrl: '',
            bio: '',
            createdAt: '',
            updatedAt: ''
        }
    });

    const [username, setUsername] = useState(null);
    const [formVisible, setFormVisible] = useState(false);
    const [description, setDescription] = useState('');
    const [mediaUrl, setMediaUrl] = useState('');

    const openCreatePostMenu = () => setFormVisible(true);
    const closeCreatePostMenu = () => setFormVisible(false);

    const fetchPosts = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/posts');

            const reversedPosts = response.data.reverse();
            setPosts(reversedPosts);
        } catch (error) {
            console.error('Error fetching posts:', error);
        }
    };

    useEffect(() => {
        const storedUsername = localStorage.getItem('username');
        if (storedUsername) {
            setUsername(storedUsername);
        }

        fetchPosts();
    }, []);

    const handleSubmit = async () => {
        try {
            const storedUserId = localStorage.getItem('userId');
            const user = await getUser(storedUserId);

            await createPost(description, mediaUrl, user);

            setDescription('');
            setMediaUrl('');
            closeCreatePostMenu();
            fetchPosts();
        } catch (err) {
            console.error('Invalid login credentials');
        }
    };

    return (
        <div>
            <Navbar/>
            <Button color="inherit" onClick={openCreatePostMenu}>Create Post</Button>
            {formVisible && (
                <div style={{padding: '16px', border: '1px solid #ccc', marginTop: '16px'}}>
                    <TextField
                        label="Post Description"
                        variant="outlined"
                        fullWidth
                        multiline
                        rows={4}
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        style={{marginBottom: '8px'}}
                    />
                    <TextField
                        label="Media URL (Optional)"
                        variant="outlined"
                        fullWidth
                        value={mediaUrl}
                        onChange={(e) => setMediaUrl(e.target.value)}
                        style={{marginBottom: '16px'}}
                    />
                    <div>
                        <Button onClick={closeCreatePostMenu} color="secondary" style={{marginRight: '8px'}}>
                            Cancel
                        </Button>
                        <Button onClick={handleSubmit} color="primary">
                            Post
                        </Button>
                    </div>
                </div>
            )}
            <Feed posts={posts}/>
        </div>
    );
};

export default HomepageContainer;
