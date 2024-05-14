USE esercizio02;

CREATE TABLE Province(
	sigla VARCHAR(255) PRIMARY KEY NOT NULL,
    nome_provincia VARCHAR(255) NOT NULL,
    numero_abitanti INT
);

CREATE TABLE Persone(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    eta INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    sesso enum('uomo','donna') NOT NULL
);

RENAME TABLE province TO Regioni;
-- in alternativa: ALTER TABLE province RENAME Regioni;

ALTER TABLE regioni ADD COLUMN via_principale VARCHAR(255) NOT NULL;


-- altre prove
ALTER TABLE Regioni RENAME COLUMN nome_provincia TO regioni;
ALTER TABLE Regioni RENAME COLUMN regioni TO nome_provincia;
ALTER TABLE Persone ADD email VARCHAR(255);
ALTER TABLE persone DROP COLUMN email;



CREATE TABLE Studenti(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cognome VARCHAR(255)
);

CREATE TABLE Corsi(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(255),
    descrizione VARCHAR(255)
);

CREATE TABLE Iscrizioni(
	data_inizio DATE,
    data_fine DATE,
    studente_id INT,
    corso_id INT,
    PRIMARY KEY(studente_id, corso_id),
    FOREIGN KEY(studente_id) REFERENCES Studenti(id),
    FOREIGN KEY(corso_id) REFERENCES Corsi(id)
);

CREATE TABLE job(
	job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	job_title VARCHAR(255),
	min_salary DECIMAL(10,2),
	max_salary DECIMAL(10,2),
	CHECK(min_salary>=0 AND max_salary<=25000)
);

-- prova funzionamento del check
INSERT INTO job (job_title, min_salary, max_salary) VALUES ("pizzaiolo",-10,200);
INSERT INTO job (job_title, min_salary, max_salary) VALUES ("dottore",0,25001);
INSERT INTO job (job_title, min_salary, max_salary) VALUES ("insegnante",-1,25001);
INSERT INTO job (job_title, min_salary, max_salary) VALUES ("macellaio",0,25000);


-- -----------------


CREATE TABLE job(
	job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	job_title VARCHAR(255) DEFAULT "",
	min_salary DECIMAL(10,2) DEFAULT 8000,
	max_salary DECIMAL(10,2)  DEFAULT null
);

INSERT INTO job (job_title) VALUES ("pizzaiolo");
INSERT INTO job (max_salary) VALUES (90000);
INSERT INTO job () VALUES ();


-- -----------------


CREATE TABLE job(
	job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_inizio DATE,
    data_fine DATE,
    id_lavoro INT,
    ID_dipartimento INT
);

INSERT INTO job (data_inizio, data_fine) VALUES (STR_TO_DATE('12/02/2023', '%d/%m/%Y'),STR_TO_DATE('12/02/2023', '%d/%m/%Y'));

-- --------------------------------------------

CREATE TABLE persona(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    email VARCHAR(255),
    indirizzo VARCHAR(255)
);
-- insert di 2 record
INSERT INTO persona (nome,cognome,email,indirizzo) VALUES ("mario","rossi", "mario.rossi@email.com", "via Roma 1");
INSERT INTO persona (nome,cognome,indirizzo) VALUES ("luigi","verdi", "via Roma 2");
-- update di un record con la conditio
UPDATE persona SET email = "luigi.verdi@email.com" WHERE nome = "luigi" && cognome = "verdi";
-- cancellazione di un record con la condition
DELETE FROM persona WHERE cognome = "verdi";
-- inserimento multiplo (3 record)
INSERT INTO persona (nome,cognome,email,indirizzo) VALUES
("luca","bianchi", "luca.bianchi@email.com", "via Roma 3"),
("lara","neri", "lara.neri@email.com", "via Roma 4"),
("pino","silvestri", "pino.silvestri@email.com", "via Roma 5");
-- ridenominazione di una colonna
ALTER TABLE persona RENAME COLUMN indirizzo TO via;
ALTER TABLE persona RENAME COLUMN via TO indirizzo;
	
-- ---------------------

CREATE TABLE impiegati(
	id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    tipologia VARCHAR(255),
    stipendio DECIMAL(10,2)
);
