import { useParams } from "react-router-dom";

export function Course(){

    const {id} = useParams();       //versione destrutturata
    //const param = useParams();    // versione normale

    return(
        <div> sono il corso n. {id}</div>
        //<div> sono il corso n. {param.id}</div>
    );
}