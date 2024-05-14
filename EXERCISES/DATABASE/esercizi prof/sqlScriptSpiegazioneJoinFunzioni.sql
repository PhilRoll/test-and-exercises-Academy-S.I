SELECT e.first_name, e.last_name, e.job_id, e.department_id, d.department_name 
FROM employees e 
JOIN departments d  ON (e.department_id = d.department_id) 
JOIN locations l ON (d.location_id = l.location_id) 
WHERE LOWER(l.city) = 'London';

# -------------------------------------------------------------------------------------------------------------------------------------------

SELECT e.employee_id 'Emp_Id', e.last_name 'Employee', m.employee_id 'Mgr_Id', m.last_name 'Manager' 
FROM employees e 
JOIN employees m 
ON (e.manager_id = m.employee_id);

# -------------------------------------------------------------------------------------------------------------------------------------------

SELECT location_id, street_address, city, state_province, country_name FROM locations NATURAL JOIN countries;

# -------------------------------------------------------------------------------------------------------------------------------------------

SELECT first_name, last_name, hire_date, salary, (DATEDIFF(now(), hire_date))/365  Experience
FROM departments d 
JOIN employees e 
ON (d.manager_id = e.employee_id) 
# datediff funzione sql utilizzata per trovare la differenza in giorni tra due date. now() resistuisce data corrente. 
WHERE (DATEDIFF(now(), hire_date))/365>15;
 
 # -------------------------------------------------------------------------------------------------------------------------------------------
 
SELECT jh.* 
FROM job_history jh 
JOIN employees e 
ON (jh.employee_id = e.employee_id) WHERE salary > 10000;

# -------------------------------------------------------------------------------------------------------------------------------------------

-- conta il numero di righe 
SELECT COUNT(*) AS TotalEmployees
FROM employees;

# -------------------------------------------------------------------------------------------------------------------------------------------

-- Conta il numero di dipendenti con stipendi unici
SELECT COUNT(DISTINCT salary) AS UniqueSalaries
FROM employees;

# -------------------------------------------------------------------------------------------------------------------------------------------

-- Conta il numero totale di stipendi registrati (esclusi i valori NULL)
SELECT COUNT(ALL salary) AS TotalSalariesCount
FROM employees;

# -------------------------------------------------------------------------------------------------------------------------------------------

-- Somma totale degli stipendi unici
SELECT SUM(DISTINCT salary) AS SumUniqueSalaries
FROM employees;

#-------------------------------------------------------------------------------------------------------------------------------------------

-- Somma totale di tutti gli stipendi
SELECT SUM(ALL salary) AS SumAllSalaries
FROM employees;


SELECT department_id, MAX(salary) AS max_salary, MIN(salary) AS min_salary
FROM employees
GROUP BY department_id;