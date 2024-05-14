import React from 'react'
import ReactDOM from 'react-dom/client'
import { Saluto } from './components/Saluto'
import { Contatore } from './components/Contatore'
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.bundle"


ReactDOM.createRoot(document.getElementById('root')).render(
    <>
        <Saluto />
        <Contatore incremento={1}/>
    </>

)
