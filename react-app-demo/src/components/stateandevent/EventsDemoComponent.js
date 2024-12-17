const EventDemoComponent = () => {
    const handleClick=()=>{
        console.log("Hello Event")
    }
    const handleClickAgain=(name)=>{
        console.log("Hello Event " + name)
    }
    return ( 
        <>
            <h2>Events Demo</h2>
            <button onClick={handleClick}>Click Me</button>
            <button onClick={()=>handleClickAgain("Venus")}>Click Me Again</button>

        </>
     );
}
 
export default EventDemoComponent;