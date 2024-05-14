import { AuthContext } from "../../contexts/AuthContext/AuthContext";
import { useContext } from "react";
import { getTodos } from "../../services/RESTservice";

export function Home() {

    const { user, setuser } = useContext(AuthContext);

    const handleClick = async () => {
        console.log(await getTodos());
    }

    /*
    //OPPURE (per la seconda versione del metodo):
    const handleClick = () => {
        console.log(getTodos());
    }
        
        */

    return (
        <>
            <div>{user.firstName}</div>
            <div>{user.lastName}</div>
            <div>{user.email}</div>
            <button className="btn btn-warning" onClick={handleClick}>Logga evento</button>
        </>
    );
}