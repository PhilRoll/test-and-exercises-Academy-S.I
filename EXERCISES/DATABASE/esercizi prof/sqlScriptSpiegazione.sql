/* SQL= structured query language ed è un linguaggio standardaddizato per database basati sul modello relazionale DBMS usato per:
DDL (Data Definition Language), DML (Data Manipulation Language) e DQL (Data Query Language)

-- creare un database
CREATE DATABASE azienda_db;

-- creare una tabella
/*
CREATE TABLE nometabella(
nome_campo tipo_di_dato constraint,
nome_campo tipo_di_dato constraint,
nome_campo tipo_di_dato constraint,
);
*/

/*
CREATE TABLE prova (
id int);

DROP TABLE prova;
*/

use azienda_db;

-- tabella dipendenti
CREATE TABLE dipendenti(
	id int,
    nome varchar(255),
    cognome varchar(255),
    data_assunzione date,
    stipendio decimal
);

-- if not exists verifica se la tabella esiste oppure no. Nel caso esista esce un warning "table dipendenti alredy exists", in caso contrario formerà la tabella
CREATE TABLE IF NOT EXISTS dipendenti(
	id int,
    nome varchar(255),
    cognome varchar(255),
    data_assunzione date,
    stipendio decimal
);

/*constraint sono delle condizioni che si possono aggiungere su una colonna e sono 7: NOT NULL, PRIMARY KEY, UNIQUE, FOREIGN KEY, DEFAULT, CHECK, INDEX
NOT NULL: deve avere per forza un valore;
PRIMARY KEY: indica la chiave primaria. Cos'è? Indica il valore univoco che identifica la riga;
UNIQUE: campo univoco, a differenza della primary key che indica la chiave importantissima per la tabella, unique indica semplicemente un campo che sia unico;
DEFAULT: campo di default ovvero se non viene inserito nulla ci sarà il valore di default. Se c'è not null senza usare default bisogna per forza mettere qualcosa;
CHECK: serve a verificare un campo in fase di inserimento o di modifica;
FOREIGN KEY(): chiave esterna (in inglese foreign sarebbe straniero). La clausola FOREIGN KEY con "REFERENCES" viene utilizzata per stabilire una relazione
tra le tabelle in base ai valori delle chiavi primarie e delle chiavi esterne, garantendo l'integrità referenziale all'interno del db;
*/

CREATE TABLE IF NOT EXISTS dipendenti (
	id INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    data_assunzione DATE NOT NULL,
    stipendio DECIMAL NOT NULL CHECK (stipendio >=1200 AND stipendio<=5000),
    telefono VARCHAR(18) NOT  NULL UNIQUE, 
    mansione VARCHAR(255) NOT NULL DEFAULT 'impiegato',
    PRIMARY KEY(id)
);

/* un dipendente non può avere il telefono di un altro quindi è unico, ma non può fungere da chiave primaria perchè dal momento in cui il dipendente cambia telefono bisognerebbe
cambiare tutto ma non va bene. Con check quando si fa un inserimento il valore deve essere rispettare il controllo.  */

CREATE TABLE IF NOT EXISTS clienti (
	id INT NOT NULL, 
    denominazione VARCHAR(255) NOT NULL,
    p_iva VARCHAR(16) NOT NULL UNIQUE,
    indirizzo VARCHAR(18) NOT NULL,
    telefono VARCHAR(18) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);



/* i clienti ordinano merci ecc, però, si assegna un dipendente al supporto quindi sicuramente ogni nostro cliente ha un dipendente assegnato per il 
supporto. Il cliente X ha come riferimento nell'azienda uno specifico dipendente che si occupa del cliente x, y e z e sarà solo lui a far da tramite */

CREATE TABLE IF NOT EXISTS rapporto_clienti(
	id INT NOT NULL, 
    id_cliente INT NOT NULL,
    id_dipendente INT NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (id_dipendente) REFERENCES dipendenti(id),
	FOREIGN KEY (id_cliente) REFERENCES clienti(id)
);

/* INSERT INTO clienti (colonna1, colonna2, colonna3, ...) VALUES (valore1, valore2, valore3, ...) 
La insert può essere scritta anche in un modo alternativo ovver INSERT INTO clienti VALUES (valori1, valore2, valore3, ...) */

INSERT INTO clienti (id, denominazione, p_iva, indirizzo, telefono) 
VALUES (0, "Xyz impianti", "9087643521", "Via Vasto, Roma", "3489901273");

/* se si effettua l'insert con lo stesso id si avrà un errore "duplicate entry 0 for key clienti.Primary". Se si cambia id, ma si lasciano gli stessi valori
del telefono e p_iva avendo messo UNIQUE  si avrà comunque un errore. */

INSERT INTO clienti VALUES (1, "ABC servizi casa", "1234567809", "Via Croce, Roma", "333388671");

/* fin'ora l'id è sempre stato inserito manualmente, ma è possibile renderlo auto-increment in modo da non doverlo inserire manualmente.  */

/* DROP TABLE clienti, dipendenti, rapporto_clienti;  */

CREATE TABLE IF NOT EXISTS dipendenti (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    data_assunzione DATE NOT NULL,
    stipendio DECIMAL NOT NULL CHECK (stipendio >=1200 AND stipendio<=5000),
    telefono VARCHAR(18) NOT  NULL UNIQUE, 
    mansione VARCHAR(255) NOT NULL DEFAULT 'impiegato',
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS clienti (
	id INT NOT NULL AUTO_INCREMENT, 
    denominazione VARCHAR(255) NOT NULL,
    p_iva VARCHAR(16) NOT NULL UNIQUE,
    indirizzo VARCHAR(18) NOT NULL,
    telefono VARCHAR(18) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS rapporto_clienti(
	id INT NOT NULL AUTO_INCREMENT, 
    id_cliente INT NOT NULL,
    id_dipendente INT NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (id_dipendente) REFERENCES dipendenti(id),
	FOREIGN KEY (id_cliente) REFERENCES clienti(id)
);

INSERT INTO clienti (denominazione, p_iva, indirizzo, telefono) 
VALUES ( "Xyz impianti", "9087643521", "Via Vasto, Roma", "3489901273");
INSERT INTO clienti (denominazione, p_iva, indirizzo, telefono)
VALUES ( "ABC servizi casa", "1234567809", "Via Croce, Roma", "333388671");

/* se si effettua l'insert con lo stesso id si avrà un errore "duplicate entry 0 for key clienti.Primary". Se si cambia id, ma si lasciano gli stessi valori
del telefono e p_iva avendo messo UNIQUE  si avrà comunque un errore. */

/* inserimenti multipli */

INSERT INTO clienti (denominazione, p_iva, indirizzo, telefono) 
VALUES 
( "Giardinaggio fatto in casa", "1234567896", "Via Torti Roma", "9854339500"),
("Officina srl", "9983721344", "Pz Vittoria, Roma", "0084922385"),
("F.lli Rossi Concessionaria", "9123008764", "Via Marte, Milano", "0375093489"),
("Pitture srl", "9857299753", "Via Turati, Udine", "1129759388");

/* SELECT colonna1, colonna2 ... FROM nome_tabella; */

-- asterisco sta per tutto, quindi seleziona tutto
SELECT * FROM clienti;

-- selezionare solo alcuni campi
SELECT denominazione, p_iva FROM clienti;

-- condizioni con WHERE
/* SELECT colonna1 ... colonnaN FROM nome_tabella WHERE condizione; */

SELECT denominazione, telefono
FROM clienti WHERE id = 1; 

/* si può utilizzare anche != per interrogare il db e ottenere tutti i dati che non hanno l'id indicato */

/* senza mettere nulla in impiegato viene preso il valore di default ovvero impiegato */
INSERT INTO dipendenti (nome, cognome, data_assunzione, stipendio, telefono) 
VALUES  
("Lorenzo", "Taverna", "2021-05-20", 1900, "3489614982"),
("Mattia", "Caputo", "2020-03-10", 1900, "3321114223"),
("Marco", "Verdi", "2020-10-13", 1700, "2944101834");

SELECT *
FROM dipendenti
WHERE stipendio > 1700;

SELECT id, nome
 FROM dipendenti
 WHERE data_assunzione = "2021-05-20";

INSERT INTO dipendenti (nome, cognome, data_assunzione, stipendio, telefono, mansione)
VALUES 
("Andrea", "Rossi", "1991-03-10", 2100, "3231112300", "Commerialista"),
("Luca", "Lucio", "2011-06-19", 1500, "3121112300", "Magazzinere");

-- condizioni con WHERE con OPERATORI LOGICI
/* SELECT nome_colonna1 ... nome_colonnaN FROM nome_tabella WHERE condizione1 AND condizione2 AND condizione3 ... AND condizioneN; */

SELECT id, nome, cognome 
FROM dipendenti 
WHERE stipendio > 1700 AND mansione = "impiegato";

SELECT nome, cognome
FROM dipendenti
WHERE id > 2 AND mansione = "impiegato" OR mansione = "magazziniere";

/* si può usare l'operatore logico NOT oppure !=  */
SELECT nome, cognome
FROM dipendenti WHERE NOT mansione = "impiegato";

-- si possono avere delle macro condizioni e possono essere combinati come segue
SELECT * 
FROM dipendenti
WHERE (mansione = "impiegato" AND stipendio > 1500) OR (mansione = "magazziniere" AND stipendio <2500);

-- IN e BETWEEN. IN serve per cerare tra una lista di valori, between tra un valore massimo e uno minimo. Si possono combinare con NOT
/*  SELECT nome_colonna1 ... nome_colonnaN FROM nome_tabella WHERE nome_colonna IN ("valore1", ..., "valoreN");
    SELECT nome_colonna1 ... nome_colonnaN FROM nome_tabella WHERE nome_colonna BETWEEN min_value AND max_value;
 */
 
 SELECT *
 FROM dipendenti
 WHERE mansione IN ("impiegato", "magazziniere");
 
 SELECT * 
 FROM dipendenti
 WHERE stipendio BETWEEN  1300 AND 1800;
 
 -- ORDER BY serve ad effettuare il sorting ovvero l'ordinamento. ASC dalla A alla Z e DESC dalla Z alla A
 /* SELECT nome_colonna1 ... nome_colonnaN FROM nome_tabella ORDER BY nome_colonna ASC DESC; */
 
 SELECT nome, cognome
 FROM dipendenti
 ORDER BY nome DESC;
	
/* se si fa ORDER BY nome, cognome DESC e si ha lo stesso nome, l'ordine verrà assegnato per cognome. In generale la seconda colonna incide su quelle
prime colonne ordinate che hanno lo stesso valore. */

-- LIMIT ovvero numero di righe che si vuole vedere
SELECT * FROM dipendenti ORDER BY stipendio DESC LIMIT 3; 

/* quindi combinando limit con desc si va a vedere i primi tre che guadagnano di più. Si possono saltare N righe prima i prendere quelle che 
interessano attraverso LIMIT offset scrivendolo con la sintassi (ad esempio) LIMIT 1, 2; */

SELECT * FROM dipendenti ORDER BY id DESC LIMIT 1, 2;

-- DISTINCT. Se ci sono multipli valori ed alcuni sono ripetuti, viene preso il singolo valore 
/* SELECT  DISTINCT nome_colonna FROM clienti;  */
 SELECT DISTINCT nome FROM dipendenti;
 
 -- COUNT() permette di contare il numero di record. Si può combinare anche con DISTINCT
 /* SELECT COUNT(nome_colonna) FROM nome_tabella;
	SELECT COUNT (DISTINCT nome_colonna) FROM nome_tabella;
 */
 
 SELECT COUNT(nome) FROM dipendenti;

-- UPDATE. Aggiornare una tabella, modificando i dati presenti nei campi. Si possono utilizzare anche gli operatori logici 
/* UPDATE nome_tabella SET colonna1 = valore1 WHERE condizione; */
UPDATE clienti 
SET indirizzo = "Via Varese" 
WHERE id=1;

-- DELETE 
/* DELETE FROM nome_tabella WHERE condizione; */
DELETE FROM clienti WHERE id = 5;

 -- TRUNCATE
 /* TRUNCATE TABLE tabella; Questo comando sql pulisce interamente la tabella */
 
 -- DIFFERENZA TRA TRUNCATE TABLE E DELETE FROM TABLE
 /* truncate ricrea la tabella aggiornando anche autoincrement, mentre delete cancella senza aggiornare autoincrement. Delete permette l'autoincrement, mentre
 truncate cancella tutte le righe a prescindere. Truncate è un comando di DDL quindi "agisce" sulla struttura del database, mentre delete è un comando di 
 DML ovvero "agisce" sui dati contenuti nelle tabelle del database. Truncate è più veloce perchè cancella a prescindere mentre delete scansiona ogni riga
 */

-- JOIN si basa sull'unione di tabelle diverse basate su un campo comune tra di loro (la chiave esterna)
/* INNER JOIN: restituisce solo le righe che hanno una corrispondenza in entrambe le tabelle unite;
   LEFT JOIN: restituisce tutte le righe della tabella di sinistra insieme alle righe della tabella di destra per le quali è soddisfatta la condzione di join
   RIGHT JOIN: restituisce tutte le righe della tabella di destra insieme alle righe della tabella di sinistra per le quali è soddisfatta la condizione di join
   FULL JOIN: (non disponibile in mysql)
   CROSS JOIN: combinazione di ogni riga di una tabella con ogni riga di un'altra tabella. 
   N.B.
   LEFT,RIGHT E FULL JOIN fanno parte degli outer join ovvero un'estensione della inner join e un outer join restituisce le righe anche se non hanno righe 
   correlate alla tabella unita.
   
   Nella INNER JOIN
   SELECT nome_tabella.campoi ... nome_tabella.campoN, nome_tabella.campoj ... nome_tabella.campoN
   FROM tabellai
   INNER JOIN tabellaj ON condizione;
   */
 
SELECT dipendenti.id, dipendenti.nome 
FROM dipendenti 
INNER JOIN rapporto_clienti
ON dipendenti.id = rapporto_clienti.id_dipendente;
 
SELECT dipendenti.id, dipendenti.nome, rapporto_clienti.id
FROM dipendenti 
LEFT JOIN rapporto_clienti
ON dipendenti.id = rapporto_clienti.id_dipendente;

SELECT dipendenti.id, dipendenti.nome, rapporto_clienti.id
FROM dipendenti 
RIGHT JOIN rapporto_clienti
ON dipendenti.id = rapporto_clienti.id_dipendente;

-- LIKE definiamo una specie di pattern
/* SELECT colonne FROM tabella WHERE campo like pattern; 
comincia con 'C%';
finisce con '%C';
contiene '%C%';
caratteri fissi e comincia con 'C_';
caratteri fissi e finisce con '_C';
caratteri fissi e contiene '_C_';
contiene stringa e finisce con uno '%C_';
contiene stringa e inizia con uno '_C%';
N.B.
Case insensitive
*/

SELECT * 
FROM clienti
WHERE denominazione LIKE 'a%';

SELECT * 
FROM clienti
WHERE denominazione LIKE '%a';

SELECT *
FROM clienti 
WHERE denominazione LIKE '%a%';

SELECT * 
FROM clienti
WHERE denominazione LIKE 'P__________'; 

SELECT * 
FROM clienti
WHERE denominazione LIKE '%s__';

SELECT *
FROM clienti
WHERE denominazione LIKE '%officina sr_';

-- ALTER TABLE

/* -- aggiungee una nuova colonna 
   ALTER TABLE nome_tabella ADD nome_colonna tipo_di_dato constraints; 
   -- cambiare la posizione la posizione della tabella 
   ALTER TABLE nome_tabella MODIFY nome_colonna definizione_colonna AFTER nome_colonna; 
   -- aggiungere un constraint 
   ALTER TABLE nome_tabella ADD UNIQUE (nome_colonna1, ... nome_colonnaN);
   -- cancellare una colonna
   ALTER TABLE nome_tabella DROP COLUMN nome_colonna;
   -- cambiare il tipo di dato di una colonna
   ALTER TABLE nome_tabella MODIFY nome_colonna tipo_di_dato;
   -- rinominare tabella
   ALTER TABLE nome_tabella RENAME nuovoNome_tabella;
*/
ALTER TABLE rapporto_clienti 
ADD costo 
VARCHAR(50) NOT NULL;

ALTER TABLE rapporto_clienti 
MODIFY  costo VARCHAR(100) AFTER id;

ALTER TABLE rapporto_clienti
ADD UNIQUE (costo);

ALTER TABLE rapporto_clienti
DROP COLUMN costo;

ALTER TABLE rapporto_clienti
MODIFY id INT;

/*ALTER TABLE rapporto_clienti
RENAME prova; */

ALTER TABLE prova
RENAME rapporto_clienti;

-- ALIAS modo in cui possiamo chiamare tabelle e colonne per semplificarci la query
/* SELECT t1.nome_colonnai, t1.nome_colonnaN, t2.nome_colonna1 
FROM tabella1 AS t1
INNER JOIN tabella2 AS t2
ON condizione; */

-- GROUP BY aggrega le righe se ci sono doppioni. Si può aggiungere un COUNT 
/* SELECT nome_tabella1.nome_ufficio 
FROM nome_tabella1
LEFT JOIN nome_tabella2 
ON condizione 
GROUP BY nome_tabella1.nome_ufficio; */

-- HAVING filtare i risultati di una query dopo l'applicazione di una clausola GROUP BY. 
/* SELECT colonnai, ..., colonnaN 
FROM tabella
GROUP BY colonna1
HAVING condizione; 
*/

-- DATE E ORA
/* In sql ci sono 5 tipi di date ovvero DATE, TIME, DATEMITE, TIMESTAMP, YEAR.
CREATE TABLE IF NOT EXISTS prova (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL UNIQUE,
data_nascita DATE NOT NULL, 
data_inserimento DATETIME DEFAULT CURRENT_TIMESTAMP,
data_modifica TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- ON UPDATE lo fa solo per l'update
);
Si possono estrarre diverse info riguardo alle date e all'orario:
YEAR(), MONTH(), DAYMONTH(), MONTHNAME(), DAYNAME(), HOUR(), MINUTE(), SECOND()
-- estrarre ad esempio solo l'anno 
SELECT nome, YEAR  (data_nascita) FROM prova;
*/



