import axios from "axios";

const AxiosDeleteDemo = ({ id, refreshPosts }) => {
    const handleDelete = () => {
        axios.delete(`http://localhost:8000/posts/${id}`)
            .then(() => {
                refreshPosts();
            }
        );
    };

    return <button onClick={handleDelete}>Delete</button>;
};

export default AxiosDeleteDemo;
