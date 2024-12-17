const ListShow = ({ list }) => {
    return ( 
     <>
        {
            list.map((item, index)=>(
                <li key={index}>{item}</li>
            ))
        }
     </>   
    );
}
 
export default ListShow;