import { useState } from "react"; 
import ListAdd from "./ListAdd";
import ListCount from "./ListCount";
import ListShow from "./ListShow";

const ToDoList = () => {
    const[list,setList]=useState([]);  
    const[value,setValue]=useState("");  


    return (
        <div>
            <h3>To Do List</h3>
            <ListShow list={list}/>
            <ListAdd value={value} setValue={setValue} setList={setList}/>
            <ListCount list={list}/>
        </div>
    );
}
 
export default ToDoList;