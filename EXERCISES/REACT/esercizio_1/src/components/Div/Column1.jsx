export function Column1({children}){
    return(
        <div className="grid-item first-column" style={{backgroundColor:"rgb(250, 250, 250)", gridColumn: "1"}}>{children}</div>
    )
}