import { useEffect, useState } from "react";
import axios from "axios";
import DisplayPost from "./DisplayPost";
import AxiosPostDemo from "./AxiosPostDemo";
import AxiosPutDemo from "./AxiosPutDemo";

const AxiosGetDemo = () => {
    const [posts, setPosts] = useState([]);

    const refreshPosts = () => {
        axios.get("http://localhost:8000/posts")
            .then(res => {
                setPosts(res.data);
            });
    };

    useEffect(() => {
        refreshPosts();
    }, []);

    return (
        <>
            <h2>Axios Demo</h2>
            <AxiosPostDemo refreshPosts={refreshPosts} />
            <AxiosPutDemo refreshPosts={refreshPosts} />
            <DisplayPost posts={posts} refreshPosts={refreshPosts} />
        </>
    );
}

export default AxiosGetDemo;
