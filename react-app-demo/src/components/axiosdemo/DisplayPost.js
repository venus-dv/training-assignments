import AxiosDeleteDemo from "./AxiosDeleteDemo";

const DisplayPost = ({ posts, refreshPosts }) => {
    return (
        posts.map((post) => (
            <div key={post.id}>
                <h3>{post.title}</h3>
                <p>{post.body}</p>
                <AxiosDeleteDemo id={post.id} refreshPosts={refreshPosts} />
            </div>
        ))
    );
}

export default DisplayPost;
