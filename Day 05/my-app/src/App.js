import './App.css';
import React from 'react';
import CommentsList from './CommentsList';
function App() {
  const post = {
    comments: [
      "This is my first comment.",
      "Whoa look at my second comment.",
      "How many more could there possibly be?",
      "I guess it just keeps going...",
      "Okay maybe it's done now..."
    ]
  };
  return (
    <div className="App">
      <header className="App-header">
        <title>Welcome</title>
        <h1>Welcome...</h1>
        <p>look at those comments down there ....</p>
        </header>
        
        <h2>Post Comments</h2>
        <CommentsList comments={post.comments} />
      
    </div>
  );
}

export default App;
