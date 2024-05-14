const saluto1 = "Hello World!";
const elemento1 = <h1 style={{color:"magenta"}}>{saluto1}</h1>;

const saluto2 = "ciao mondo 2!";
const elemento2 = <h1 style={{color:"red"}}>{saluto2}</h1>;

const selezione = false;

export function Saluto(){
    return (
        <>
            {selezione ? elemento1 : elemento2}
        </>
    );
}