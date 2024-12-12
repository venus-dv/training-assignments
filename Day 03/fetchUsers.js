const getUsers = async ()=> {
    const response = await fetch("https://jsonplaceholder.typicode.com/users")
    const data = await response.json();
    return data;
}

getUsers().then((data)=> {
    console.log(data)
}).catch((error)=> {
    console.log(error)
})