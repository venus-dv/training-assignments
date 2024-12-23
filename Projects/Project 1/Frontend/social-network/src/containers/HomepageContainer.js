import React, { useState, useEffect } from 'react';
import Navbar from '../components/Navbar';
import Feed from '../components/Feed';
import axios from 'axios';

const HomepageContainer = () => {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/posts');
                console.log('Fetched posts: ', response.data);
                setPosts(response.data);
            } catch (error) {
                console.error('Error fetching posts:', error);
            }
        };

        fetchPosts();
    }, []);

    return (
        <div>
            <Navbar />
            <Feed posts={posts} />
        </div>
    );
};

export default HomepageContainer;
