import { useEffect } from 'react'
import { Contatore1 } from './components/Contatore1'
import { Contatore2 } from './components/Contatore2'



export function App() {

  useEffect(() => {
    document.title = 'App React'
  }, []);

  return (
    <div>
      <Contatore1 incremento={1} />
      <Contatore2 incremento={5} />
    </div>
  )
}

