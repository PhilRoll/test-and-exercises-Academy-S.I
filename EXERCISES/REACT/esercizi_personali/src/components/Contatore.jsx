import {useEffect, useState} from "react"

export function Contatore({incremento}){
	const [numeroClick, setNumeroClick] = useState(0);

	useEffect(()=> {document.title = numeroClick}, [numeroClick])

	const handleAumentaClick = () => {
		setNumeroClick((numeroClickPrecedente )=> numeroClickPrecedente+incremento);
	}

	const handleResetClick = () => {
		setNumeroClick(0)
	}


	return(
	<div className="d-grid gap-2">
		<button onClick={handleAumentaClick} type="button" className="btn btn-primary btn-lg">
		{
		numeroClick==0 ? `Cliccami` : `Cliccato ${numeroClick} ${numeroClick==1 ? `volta` : `volte`}`
		}
		</button>
		<button onClick={handleResetClick} type="button" className="btn btn-secondary">Reset contatore</button>
	</div>
	);
}