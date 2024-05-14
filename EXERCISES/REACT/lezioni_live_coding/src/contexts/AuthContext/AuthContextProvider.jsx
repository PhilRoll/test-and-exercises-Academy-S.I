import { AuthContext } from "./AuthContext";
import { useState } from "react";

export function AuthContextProvider({children}){

    const [user, setUser] = useState({
        firstName: "Simone",
        lastName: "De Meis",
        email:"simone@gmail.com",
        isAuthorized: true
    });

    return(
        <AuthContext.Provider value={{user,setUser}}>
            {children}
        </AuthContext.Provider>
    );
}