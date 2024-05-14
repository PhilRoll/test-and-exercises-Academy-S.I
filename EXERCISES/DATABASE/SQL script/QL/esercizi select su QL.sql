-- visualizzare tutti i nomi e cognomi degli impiegati
SELECT FIRST_NAME AS nome, LAST_NAME AS cognome FROM employees;
-- -------------------------------------
-- visualizzare gli ID dei dipartimenti senza ripetizioni
SELECT DISTINCT DEPARTMENT_ID AS ID FROM employees;
-- ----------------------------------------
-- visualizzare i primi tre caratteri del nome di ogni impiegato
SELECT SUBSTR(FIRST_NAME, 1, 3) AS primi_tre_caratterI FROM employees;
-- ---------------------------------------
-- visualizzare i nomi e cognomi e lo stipendio per tutti i dipendenti i cui stipendio NON è compreso tra 10.000 e 15.000
SELECT FIRST_NAME AS nome, LAST_NAME AS cognome, EMAIL AS email
FROM employees 
WHERE SALARY<10000.00 AND SALARY> 15000.00;
-- WHERE SALARY NOT BEWTWEEN AND 15000.00;
-- -------------------------------------------
-- scrivere il nome cognome, id reparto dei dipendenti dei reparti 30 e 100 in ordine crescente
SELECT FIRST_NAME AS nome, LAST_NAME AS cognome, DEPARTMENT_ID AS 'ID reparto' 
FROM employees
WHERE DEPARTMENT_ID=30 OR DEPARTMENT_ID=100 ORDER BY DEPARTMENT_ID ASC;
-- WHERE DEPARTEMENT_ID IN (30,100) ORDER BY DEPARTMENT_ID ASC;
-- ------------------------------------------
-- nome cognome e data assunzione per tutti i dipendenti assunti nel 1987
SELECT FIRST_NAME AS nome, LAST_NAME AS cognome, HIRE_DATE AS 'data assunzione' 
FROM employees
WHERE HIRE_DATE BETWEEN '1987-01-01' AND '1987-12-31';
-- WHERE YEAR(HIRE_DATE) = 1987
-- -------------------------------------------
-- cognome dei dipendenti il cui nome ha esattamente 6 caratteri
SELECT LAST_NAME AS cognome FROM employees
WHERE LENGTH(FIRST_NAME)=6; 
-- -------------------------------------------
-- tutti i record dei dipendenti in cui il cognome è  JONES, BLAKE, SCOTT, KING, FORD
SELECT * FROM employees
WHERE LAST_NAME ="JONES" OR LAST_NAME ="BRAKE" OR LAST_NAME ="SCOTT" OR LAST_NAME ="KING" OR LAST_NAME ="FORD";
-- WHERE LAST_NAME IN ("JONES","BRAKE","SCOTT","KING","FORD")
-- ------------------------------------------
-- visualizzare tutti i campi degli impiegati con ordinamento discendente a partire dal nome
SELECT * FROM employees ORDER BY FIRST_NAME DESC;
-- ---------------------------------------------------
-- visualizzare nomi, cognomi, salario e stipendio lordo degli impiegati
SELECT FIRST_NAME AS nome, LAST_NAME AS cognome, SALARY AS 'salario', ROUND(SALARY+(SALARY*COMMISSION_PCT), 2) AS 'stipendio lordo'
FROM employees;
-- ---------------------------------------------------
/*
Si vuole avere un colloquio con tutti i nuovi impiegati dal reparto 1 dopo 90 giorni dalla loro assunzione. 
In particolare, per tutti gli impiegati interessati, si vogliono determinare 
il nome, la data di assunzione e la data del colloquio.
*/
SELECT FIRST_NAME AS nome, HIRE_DATE AS 'data assunzione', DATE_ADD(HIRE_DATE, INTERVAL 90 DAY) AS 'data colloquio'
FROM employees WHERE DEPARTMENT_ID = 1;
-- ---------------------------------------------------------
/*
verifica se i campi FIRST_NAME della tabella employees contengono numeri
*/
INSERT INTO `employees` (`EMPLOYEE_ID`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PHONE_NUMBER`, `HIRE_DATE`, `JOB_ID`, `SALARY`, `COMMISSION_PCT`, `MANAGER_ID`, `DEPARTMENT_ID`) VALUES
('208', 'St3v3n', 'King', 'SKING02', '515.123.4567', '1987-06-17', 'AD_PRES', '24000.00', '0.00', '0', '90');

DELETE FROM employees WHERE FIRST_NAME="Ste[0-9]ven";

SELECT FIRST_NAME AS nome
FROM employees WHERE FIRST_NAME REGEXP '[0-9]';
-- -------------------------------------
/*
Scrivere una query per ottenere lo stipendio mensile (esattamente due cifre decimali) di tutti i dipendenti.
ordinare poi gli stipendi dal più grande al più piccolo.
limitare, poi il numero delle uscite a 10 righe.
*/
SELECT ROUND(SALARY/12, 2) AS 'stipendio mensile'
FROM employees ORDER BY SALARY DESC LIMIT 10;













-- -------------------------------------------
-- ESERCIZI 15/04/2024
-- -------------------------------------------

/*scrivere una query per trovare nome, cognore, lavoro, id reparto 
dei dipentendi che lavorano a Londra ed estrarre anche il nome del reparto
*/
SELECT FIRST_NAME, LAST_NAME, jobs.JOB_TITLE, departments.DEPARTMENT_ID, departments.DEPARTMENT_NAME FROM 
employees INNER JOIN departments ON employees.DEPARTMENT_ID = departments.DEPARTMENT_ID 
INNER JOIN jobs ON employees.JOB_ID = jobs.JOB_ID
INNER JOIN locations ON departments.LOCATION_ID = locations.LOCATION_ID
WHERE locations.CITY = "London";

-- ----------------------------
/*scrivi una query per trovare l'ID dipendente, il cognome insieme al manager_id e al cognome
*/
SELECT e.EMPLOYEE_ID, e.LAST_NAME, m.EMPLOYEE_ID, m.LAST_NAME FROM 
employees e INNER JOIN employees m ON e.MANAGER_ID = m.EMPLOYEE_ID; 

-- ----------------------
/*scrivi una query per visualizzare nome, cognome, data di assunzione, 
stipendio del manager per tutti i manager con esperienza superiore a 15 anni
*/
SELECT employees.FIRST_NAME, employees.LAST_NAME, employees.HIRE_DATE, employees.SALARY, DATEDIFF(CURRENT_DATE(),employees.HIRE_DATE)/365 Experience FROM
departments INNER JOIN employees ON departments.MANAGER_ID=employees.EMPLOYEE_ID
WHERE DATEDIFF(CURRENT_DATE(),employees.HIRE_DATE) > 15*365;



/* scrivi una query per trovare gli indirizzi 
(location_id, street_address, city, state_province, country_name) di tutti i dipartimenti
*/
SELECT locations.LOCATION_ID, locations.STREET_ADDRESS, locations.CITY, locations.STATE_PROVINCE, countries.COUNTRY_NAME FROM
locations INNER JOIN countries ON locations.COUNTRY_ID = countries.COUNTRY_ID;

-- -----------------------------------------------------
/*scrivi una query per visualizzare la cronologia del lavoro che è stata eseguita
da qualsiasi dipendente che attualmente sta prelevando piu di 10.000 di stipendio*/
SELECT job_history.* FROM
job_history JOIN employees ON job_history.EMPLOYEE_ID = employees.EMPLOYEE_ID
WHERE employees.SALARY > 10000;
