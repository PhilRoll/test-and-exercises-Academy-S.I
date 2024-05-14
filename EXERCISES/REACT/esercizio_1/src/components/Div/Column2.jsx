export function Column2({ children }) {
    return (
        <div className="grid-item second-column" style={{ backgroundColor: "rgb(228, 228, 228)", gridColumn: "2 / span 1", gridRow: "1 / span 2" }}>{children}</div>
    )
}