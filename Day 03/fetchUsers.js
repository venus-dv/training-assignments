const getUsers = async ()=> {
    const response = await fetch("https://jsonplaceholder.typicode.com/users")
    const data = await response.json();
    return data;
}

const display = (users) => {
    const container = document.getElementById("userInfo");

    const userElements = users.map(user => {
        const userElement = document.createElement("div");
        userElement.innerHTML = `Name: ${user.name}<br>Email: ${user.email}<br>Phone Number: ${user.phone}`;
        return userElement;
    });

    container.append(...userElements);
};

getUsers().then((data)=> {
    display(data);
}).catch((error)=> {
    console.log(error)
})