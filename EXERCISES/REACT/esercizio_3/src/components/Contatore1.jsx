import React, { useState } from 'react';

export function Contatore1({incremento}){
	const [click, setClick] = useState(0);

	const handleIncrementaClick = () => {
		setClick((c)=> c+incremento);
	}

	return(
		<button onClick={handleIncrementaClick}>
			{ click==0 ? `Contatore1 (x1)` : `Hai cliccato ${click} ${click==1 ? `volta` : `volte`}` }
		</button>
	);
}