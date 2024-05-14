import React, { useState } from 'react';

export function Contatore2({incremento}){
	const [click, setClick] = useState(0);

	const handleIncrementaClick = () => {
		setClick((c)=> c+incremento);
	}

	return(
		<button onClick={handleIncrementaClick}>
			{ click==0? `Contatore2 (x5)` : `Contatore = ${click}` }
		</button>
	);
}