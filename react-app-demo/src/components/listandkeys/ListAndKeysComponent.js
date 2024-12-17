import { useState } from "react";
import CommentDisplayComponent from "../CommentDisplayComponent";
import { useEffect } from "react";

const ListAndKeysComponent = () => {
    const[comments, setComments]= useState([
        {"id": 1, "title": "delectus aut autem", "name": "Ray Romano" },
        {"id": 2, "title": "quis ut nam facilis et officia qui", "name" : "Alice Cullen"},
        {"id": 3, "title": "fugiat veniam minus", "name" : "Alex Watson"}
    ])
    const handleDelete=(id)=>{
        const newComment=comments.filter(comment=>comment.id!==id);
        setComments(newComment);
    }

    const[name,setName]=useState("Jasdhir");

    useEffect(()=>{
        console.log("use effect called ....")
    },[name])

    return (
        <>
        <h2>List and Keys</h2>
            <CommentDisplayComponent comments={comments} handleDelete={handleDelete}/>
            <button onClick={()=>setName('Venus')}>Change Name</button>
        </>
    );
}
export default ListAndKeysComponent;
