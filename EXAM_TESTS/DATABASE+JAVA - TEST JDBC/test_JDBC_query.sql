USE test_jdbc;

CREATE TABLE IF NOT EXISTS prestiti(
	id INT PRIMARY KEY NOT NULL, 
    inizio DATE,
    fine DATE,
    id_U INT NOT NULL,
    id_L INT NOT NULL,
    FOREIGN KEY (id_U) REFERENCES utente(id),
	FOREIGN KEY (id_L) REFERENCES libro(id)
);


-- query1
SELECT titolo, autore, inizio, fine FROM
libro JOIN prestiti ON libro.id = prestiti.id_L JOIN utente ON prestiti.id_U = utente.id 
WHERE utente.cognome = "Vallieri" ORDER BY prestiti.inizio DESC;

-- query2
SELECT utente.nome, utente.cognome, COUNT(prestiti.id_L) AS numero_di_libri_prestati FROM 
libro JOIN prestiti ON libro.id = prestiti.id_L
JOIN utente ON prestiti.id_U = utente.id
GROUP BY utente.nome, utente.cognome ORDER BY numero_di_libri_prestati DESC LIMIT 3;


-- query 3
SELECT nome, cognome, titolo FROM
utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
WHERE prestiti.fine IS null;


-- query 4
SELECT nome, cognome, titolo, inizio, fine FROM
utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
WHERE prestiti.inizio ='2023-04-16' AND prestiti.fine='2024-04-16' AND utente.nome LIKE 'a%';

-- query 6
SELECT nome, cognome, titolo, inizio, fine FROM
utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
WHERE datediff(prestiti.fine, prestiti.inizio)>15 
OR (prestiti.fine IS NULL AND datediff(current_date(), prestiti.inizio)>15);