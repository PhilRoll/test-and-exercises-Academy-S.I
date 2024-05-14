import { Card } from './components/Card'

const values = [
  {
    titolo: "titolo1",
    sottotitolo: "sottotitolo1",
    body: "corpo 1"
  },
  {
    titolo: "titolo2",
    sottotitolo: "sottotitolo2",
    body: "corpo 2"
  },
  {
    titolo: "titolo3",
    sottotitolo: "sottotitolo3",
    body: "corpo 3"
  }
]


export function App() {
  return (
    <>
      <div className="container">
        {values.map(value => (
          <Card
            titolo={value.titolo}
            sottotitolo={value.sottotitolo}
            body={value.body}
          />
        ))}
      </div>
    </>
  );
}