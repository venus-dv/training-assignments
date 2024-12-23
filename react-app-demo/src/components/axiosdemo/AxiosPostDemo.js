import { useState } from "react";
import axios from "axios";

const AxiosPostDemo = ({ refreshPosts }) => {
    const [newPost, setNewPost] = useState({ title: "", body: "" });

    const handleCreate = () => {
        axios.post("http://localhost:8000/posts", newPost)
            .then(res => {
                refreshPosts();
                setNewPost({ title: "", body: "" });
            });
    };

    return (
        <div>
            <h3>Create New Post</h3>
            <input
                type="text"
                placeholder="Title"
                value={newPost.title}
                onChange={(e) => setNewPost({ ...newPost, title: e.target.value })}
            />
            <input
                type="text"
                placeholder="Body"
                value={newPost.body}
                onChange={(e) => setNewPost({ ...newPost, body: e.target.value })}
            />
            <button onClick={handleCreate}>Create</button>
        </div>
    );
};

export default AxiosPostDemo;
