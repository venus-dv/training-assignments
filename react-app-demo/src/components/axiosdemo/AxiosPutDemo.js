import { useState } from "react";
import axios from "axios";

const AxiosPutDemo = ({ refreshPosts }) => {
    const [editPost, setEditPost] = useState({ id: "", title: "", body: "" });

    const handleUpdate = () => {
        axios.put(`http://localhost:8000/posts/${editPost.id}`, editPost)
            .then(res => {
                refreshPosts();
                setEditPost({ id: "", title: "", body: "" });
            });
    };

    return (
        <div>
            <h3>Update Post</h3>
            <input
                type="text"
                placeholder="ID"
                value={editPost.id}
                onChange={(e) => setEditPost({ ...editPost, id: e.target.value })}
            />
            <input
                type="text"
                placeholder="Title"
                value={editPost.title}
                onChange={(e) => setEditPost({ ...editPost, title: e.target.value })}
            />
            <input
                type="text"
                placeholder="Body"
                value={editPost.body}
                onChange={(e) => setEditPost({ ...editPost, body: e.target.value })}
            />
            <button onClick={handleUpdate}>Update</button>
        </div>
    );
};

export default AxiosPutDemo;
