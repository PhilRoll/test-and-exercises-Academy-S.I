-- -------------------------------------------
-- ESERCIZI 15/04/2024
-- FILIPPO ROTOLO
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