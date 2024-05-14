import { ContactForm } from "../../components/ContactForm/ContactForm";
import myStyle from "./Contacts.module.css";

export function Contacts(){

    return(
    <div className={`${myStyle.backgroundColore} btn`}><ContactForm/></div>);
}