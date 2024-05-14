import { Column1 } from "./Column1"
import { Column2 } from "./Column2"
import { Item1 } from "../Fields/Item1"
import { Item2 } from "../Fields/Item2"

const values = [
    {
    titolo: "titolo1",
    testo: "testo1"
    },
    {
        titolo: "titolo2",
        testo: "testo2"
    }
]


export function GridContainer() {
    return (
        <div className="container" style={{ display: "grid", gridTemplateColumns: "75% 25%" }}>
            {values.map((value) => (
                <Column1>
                    <Item1 titolo={value.titolo} testo={value.testo} />
                </Column1>
            ))}
            <Column2>
                <Item2 />
            </Column2>
        </div>
    );
}