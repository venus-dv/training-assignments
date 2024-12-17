import {useEffect} from "react";
import { useState } from "react";
import axios from "axios";
import DisplayPost from "./DisplayPost";

const AxiosGetDemo = () => {
    
    const [posts,setPosts]=useState([])
    
    useEffect(()=>{
        // axios.get("https://jsonplaceholder.typicode.com/posts")
        axios.get("http://localhost:8000/posts")
        .then(res=>{
            setPosts(res.data)
        })
    },[])
    
    return (
        <>
        <h2>Axios Demo</h2>
        <DisplayPost posts={posts}/>
        </>
    );
}

export default AxiosGetDemo;