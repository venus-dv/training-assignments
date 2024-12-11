let fetchRes = fetch("https://jsonplaceholder.typicode.com/todos/1")

fetchRes.then(res=>
    res.json()).then(
        data=>{
            console.log(data)
        }
    )