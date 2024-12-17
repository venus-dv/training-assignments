import React, { useState } from 'react';


const StateDemoComponent = () => {
    const [name, setName] = useState("Venus")
    // let name = "Venus";
    const changeName=(inputname, age1)=>{
        setName(inputname)
        setAge(age1)
    }
    const[age, setAge] = useState(27)
    return ( 
        <>
            <h2>{name} is {age} years old</h2>
            <button onClick={()=>changeName("Velazquez", 28)}>Change Name</button>
        </>
     );
}
 
export default StateDemoComponent;