// import { homeStyle } from "../../Styles/homeStyle"
// import myStyle from "./HomePage.module.css"
import { Navbar } from "../Navbar/Navbar"
import { GridContainer } from "../Div/GridContainer"
import { Footer } from "../Footer/Footer"

export function HomePage(){
    return (
        <>
        <header>
            <Navbar/>
        </header>
        <main>
            <GridContainer/>
        </main>
        <Footer/>
        </>
    )
}

// export default HomePage; //stiamo esportando questa function con la parola chiave "default". ci puo essere un solo export impostato come default