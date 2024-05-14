import { Navbar } from "../../Navbar/Navbar";
import { useOutlet } from "react-router-dom";

export function Layout(){

    const outlet = useOutlet();

    return(
        <>
            <Navbar/>
            {outlet}
        </>
    );
}