const ListAdd = ({ value, setValue, setList }) => {
    
    const submitHandler=(e)=>{
        e.preventDefault();
        setList((prevList)=>{return[...prevList, value];})
        console.log(value)
        setValue("");
    }
    
    return ( 
        <form onSubmit={submitHandler}>
            <input type="text" value={value} onChange={(e)=>setValue(e.target.value)}/>
            <button>Add</button>
        </form>
    );
}
 
export default ListAdd;