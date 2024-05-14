

export function Card({ titolo, sottotitolo, body }) {
    return (
        <div className="card" style={{width: "18rem"}}>
            <div className="card-body">
                <h5 className="card-title">{titolo}</h5>
                <h6 className="card-subtitle mb-2 text-body-secondary">{sottotitolo}</h6>
                <p className="card-text">{body}</p>
            </div>
        </div>

    );
}