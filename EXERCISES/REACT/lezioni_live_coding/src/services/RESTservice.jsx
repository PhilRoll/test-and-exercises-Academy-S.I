//ESEMPIO DI GET
export async function getTodos(){

    const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
        mode: "cors",
        method: "GET"
    });


    return await response.json();
} 

//OPPURE:
/*
//ESEMPIO DI GET
export async function getTodos(){

    const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
        mode: "cors",
        method: "GET"
    });
    console.log(await response.json);
}
*/


const obj = {
    userId: 1,
    id: 1,
    title: "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    body: "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}

const jsonBody = JSON.stringify(obj);


//ESEMPIO DI POST
export async function postTodos(){
    const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
        mode: "cors",
        method: "GET",
        headers: {
            "Content-Type": "application/json", // Specifica che il corpo della richiesta è JSON
            "Authorization": "Bearer token_value" // Esempio di header di autorizzazione
            // Puoi aggiungere altri header secondo necessità
        },
        body: jsonBody,
    });


    console.log(response.json().status);
} 