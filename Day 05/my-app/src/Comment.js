import React from "react";

function Comment({ text }) {
    return (
        <div className="comment"> 
        { text }
        </div>
    );
}

export default Comment;