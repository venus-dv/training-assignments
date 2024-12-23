const CommentDisplayComponent = ({comments,handleDelete}) => {
    // const comments = props.comment;
    return (
        <>
        {
            comments.map((comment) =>(
                <div key={comment.id}>
                <h3>{comment.title}</h3>
                <p>{comment.name}</p>
                <button onClick={()=>handleDelete(comment.id)}>Delete Comment</button>
                </div>
            )) }
        </>
    );
}

export default CommentDisplayComponent;