const myName = "Lorenzo";
console.log(myName);

{
    /* differenza tra let e var. Var myName e let myName. Nel primo caso viene segnalato un errore in quanto
     * var ha visibilità anche fuori da questo blocco */
    let myName = "Mario";
    console.log(myName);
}
// myName = "Riccardo";
console.log(myName);

// blocco di codice
{
    /*
    N.B. un array si può dichiarare con costruttore o con il valore letterale 
    var arr = new Array(); // costruttore
    var arr = []; // letterale 
    */
    const arr = ['1', '2', '3', '4', '5'];
    // avendo dichiarato l'array come const non posso riassegnarlo
    console.log(arr);

    // metodo push aggiunge un nuovo elemento alla fine di un array e ritorna la lunghezza del nuovo array
    arr.push('6');
    console.log(arr);

    // ALTRI METODI PER GLI ARRAY

    // metodo reverse(): inverso dell'array 
    newArr = arr.reverse();
    console.log(newArr);

    // metodo pop(): rimuove e restituisce l'ultimo elemento dell'array
    newArr1 = arr.pop();
    console.log(newArr1);

    // metodo shift(): rimuove e restituisce il primo elemento dell'array
    newArr2 = arr.shift();
    console.log(newArr2);

    // verifica arr dopo le funzioni pop() e shift()
    console.log(arr);

    // metodo slice(): restituisce l'array formato dagli elementi, compresi fra inizio e fine - 1, dell'array di partenza (che questa volta risulta invariato).
    newArr3 = arr.slice(0, [2]);
    console.log(newArr3);

    // metodo sort(): ordina in ordine alfabetico un array
    //let newArr4 = ["ANDREA", "RICCARDO", "MATTIA", "LORENZO"];
    let newArr4 = ['1', '3', '9', '7'];
    console.log(newArr4);
    let newArr5 = newArr4.sort();
    console.log(newArr5);

    // metodo unshift(): restituisce la lunghezza dell'array risultante dopo l'inserimento, in testa, degli elementi
    let newArr6 = ["Lorenzo", "Andrea", "Mattia"];
    console.log(newArr6);
    let newArr7 = newArr6.unshift("Francesco", "Alessandra", "Alice");
    console.log(newArr7);

    // toString(): restituisce la stringa contenente gli elementi dell'array
    newArr8 = newArr7.toString();
    console.log(newArr8);

    // concat(): 
    let newArr9 = ["ciao", "mi", "chiamo"];
    newArr10 = newArr9.concat("Lorenzo", "Taverna");
    console.log(newArr10);
}

// due funzioni con array e i suoi metodi
{
    function visualizzaNomi() {
        let listaNomi = ["Lorenzo", "Andrea", "Mattia"];
        console.log(listaNomi);
        document.write(listaNomi);
        document.write("<br>");
        console.log(listaNomi.unshift("Veronica", "Alessia", "Roberto"));
        document.write(listaNomi);
    }

    /*
    function inserisciIlNome() {
        let myArr = ["quando", " compi", " gli", " anni?"];
        anni=window.prompt("inserisci l'età", "?");
        let myArr1 = myArr.concat(anni);
        document.write(myArr1);
    }
    */
}