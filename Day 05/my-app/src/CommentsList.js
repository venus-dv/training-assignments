import React from "react";
import Comment from './Comment';

function CommentsList({ comments }) {
    return (
        <div className='comments-list'>
            {comments.map((comment, index) => (
                <Comment key={index} text={comment} />
            ))}
        </div>
    );
}

export default CommentsList;