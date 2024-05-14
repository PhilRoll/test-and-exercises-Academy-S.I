import { useState } from "react";

export function ContactForm(){

    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        userEmail: "",
        userPassword: "",
        message: ""
    })

    /*
    //per singolo elemento:
    const handleFirstNameChange = (e) => {
        setFormData({...formData, firstName: e.target.value})
    }*/

    const handleChange = (evento) =>{
        const {name, value, checked, type} = evento.target;
        /*if(type="checkbox"){
            setFormData({...formData, [name]: value});
        }*/
        setFormData({...formData, [name]: value});

    }

    const handleSubmit = (e) => {
        e.preventDefault();
        //validazione dei dati
        if(!formData.firstName.match()){}
        console.table(formData);
    }

    return(
        <form onSubmit={handleSubmit}>
            <input type="text" name="firstName" placeholder="nome" value={formData.firstName} onChange={handleChange}/>
            <input type="text" name="lastName" placeholder="cognome" value={formData.lastName} onChange={handleChange}/>
            <input type="email" name="userEmail" placeholder="email" value={formData.userEmail} onChange={handleChange}/>
            <input type="password" name="userPassword" placeholder="password" value={formData.userPassword} onChange={handleChange}/>
            <textarea name="message" cols="" row="10" placeholder="message" value={formData.message} onChange={handleChange}></textarea>

            <button type="submit" className="btn btn-warning">Logga le informazioni</button>
        </form>
    );
}