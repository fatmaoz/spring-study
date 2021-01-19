select *
from departments;

SELECT *
FROM employees;

SELECT *
FROM regions;

SELECT employee_id,first_name,department
FROM employees;

SELECT *
FROM employees
WHERE department='Sports';

SELECT *
FROM employees
WHERE department LIKE '%nit%';


SELECT *
FROM employees
WHERE department LIKE 'F%nit%';

SELECT *
FROM employees
WHERE salary<10000;

SELECT *
FROM employees
WHERE salary>=10000;

SELECT *
FROM employees
WHERE salary<=10000;


SELECT *
FROM employees
WHERE department='Clothing'
AND salary>9000;

SELECT *
FROM employees
WHERE department='Clothing'
AND salary>9000
AND region_id=2;

SELECT *
FROM employees
WHERE department='Clothing'
OR salary>9000;


SELECT *
FROM employees
WHERE salary<4000
AND (department='Clothing'
OR department='Pharmacy');

SELECT *
FROM employees
WHERE department !='Sports';

--Same thing with the up line
SELECT *
FROM employees
WHERE department <>'Sports';

SELECT *
FROM employees
WHERE NOT department <>'Sports';

SELECT *
FROM employees
WHERE email IS Null;

SELECT *
FROM employees
WHERE email IS NOT NULL;

SELECT *
FROM employees
WHERE department='Sports'
OR department='First Aid'
OR department='Toys'
OR department='Garden';

--instead of up line:
SELECT *
FROM employees
WHERE department IN ('Sports','First Aid','Toys');

SELECT *
FROM employees
WHERE  salary BETWEEN 80000 AND 100000;
--Write a query that returns the first name and email of females that work in the tools department
--having a salary greater than 110,000
SELECT first_name
FROM employees
WHERE gender='F'
AND department='Tools'
AND salary>110000;

--Write a query that returns the first name and hire date of those employees who earn more than 165000
--as well as those employees that work in the sports department and also happen to be man
SELECT *
FROM employees
WHERE salary>165000
   OR(department='Sports' AND gender='M');

SELECT *
FROM employees
ORDER BY employee_id DESC;

SELECT Distinct department
FROM employees;

SELECT DISTINCT department
FROM employees
FETCH FIRST 3 ROWS ONLY ;

SELECT salary as yearly_salary
FROM employees;

SELECT student_name,age
FROM students
ORDER BY age DESC
FETCH FIRST 4 ROWS ONLY;


SELECT *
FROM students
WHERE age<=20
AND (student_no BETWEEN 3 and 5 OR student_no=7)
OR  (age>20 AND student_no>=4);


SELECT UPPER(first_name),LOWER(department)
FROM employees;

SELECT length(first_name)
FROM employees;

SELECT TRIM('  HELLO THERE     ');

SELECT LEngth('  HELLO THERE     ');
SELECT length(TRIM('  HELLO THERE     '));

SELECT first_name || ' ' || last_name AS full_name
from employees;

SELECT (salary>140000)
from employees;

SELECT (salary>140000) AS hihg_paid
from employees
ORDER BY salary DESC;

SELECT department,(department LIKE'%oth%')
FROM employees;

SELECT 'This is test data' test_data;

SELECT substring('this is test data' FROM 1 FOR 4) as test_data;
SELECT substring('this is test data' From 9) as test_data;

SELECT department, replace(department,'Clothing','Clothes')
FROM departments;--it doesnt change in database


SELECT MAX(salary)
FROM employees;

SELECT MIN(salary)
FROM employees;

SELECT AVG(salary)
FROM employees;

SELECT round(AVG(salary))
from employees;

SELECT count(employee_id)
FROM employees;
SELECT COUNT(email)
FROM employees;

SELECT SUM(salary)
FROM employees;


SELECT SUM(salary)
FROM employees
WHERE department='Clothing';

--Write a query that returns all of the records and columns from the professors table
--but shortens the department names to only the first three characters in upper case
SELECT last_name,UPPER(SUBSTRING(department,1,3)) as department,salary,hire_date
FROM professors;

--Write a query that returns the highest and lowest salary from the professsors table exlucing the professor named 'Wilson'
SELECT MAX(salary) max_salary,MIN(salary) min_salary
FROM professors
WHERE last_name != 'Wilson';

--total department:
SELECT COUNT(*),department
FROM employees
GROUP BY department;

--total salary according to deparm=tment
SELECT SUM(salary) as total_salary,department
FROM employees
GROUP BY department;

--for each department min,max,avg salary
SELECT MIN(salary) min_salary,MAX(salary) max_salary,AVG(salary) avg_salary, COUNT(*) total_number_employees,department
FROM employees
GROUP BY department;

SELECT SUM(salary) as total_salary,department
FROM employees
WHERE region_id IN(4,5,6,7)
GROUP BY department;

SELECT department,COUNT(*)
FROM employees
GROUP BY department
ORDER BY department;

SELECT department,COUNT(*)
FROM employees
GROUP BY department
HAVING COUNT(*)<36
ORDER BY department;
--**************************GUZEL:
--show all unique domain and number of employees
SELECT COUNT(*),SUBSTRING(email,POSITION('@' IN email) +1) email_domain
FROM employees
WHERE email IS NOT NULL
GROUP BY email_domain;


--SUBQUERIES
SELECT *
FROM employees
WHERE department NOT IN (Select department FROM departments);

SELECT *
FROM (SELECT * FROM employees WHERE salary>150000) a;

SELECT *
FROM employees
WHERE department IN(SELECT department FROM departments WHERE division='Electronics')

SELECT *
FROM employees
WHERE region_id IN(SELECT region_id FROM regions WHERE country='Asia' OR country='Canada');

--Return all employees work in ASIA or CANADA make more than 130000
SELECT *
FROM employees
WHERE region_id IN(SELECT region_id FROM regions WHERE country='Asia' OR country='Canada');

--First name where work in ASIA or CANADA  and how much less making from the highest employee in the company
SELECT first_name,(SELECT MAX(salary) FROM employees) - salary
FROM employees
WHERE region_id IN(SELECT region_id FROM regions WHERE country='Asia' OR country='Canada');

--Write a query that returns all of those employees that work in the kids division AND
--the dates at which those employees were hired is greater than all of the hire_dates of employees
--who work in the maintenance department
SELECT *
FROM employees
WHERE department = ANY(SELECT department FROM departments WHERE division='Kids')
  AND hire_date > ALL(SELECT hire_date FROM employees WHERE department='Maintenance');

--Write a query that returns the names of those students that are taking the courses Physics and US History
SELECT student_name
FROM students
WHERE student_no IN(SELECT student_no FROM student_enrollment
                    WHERE course_no IN(SELECT course_no FROM courses
                                       WHERE course_title IN('Physics','US History')));

--Case= if else statment
SELECT first_name,salary,
       CASE
           WHEN salary<100000 THEN 'UNDER PAID'
           WHEN salary>100000 THEN 'PAID WELL'
           ELSE 'UNPAID'
           END as category --yeni bir column olusturuyor
FROM employees;

SELECT category,COUNT(*)
FROM (SELECT first_name,
             CASE
                 WHEN salary<100000 THEN 'UNDER PAID'
                 WHEN salary>100000 AND salary<160000 THEN 'PAID WELL'
                 ELSE 'EXECUTIVE'
             END as category
      FROM employees) a
GROUP BY category;

SELECT first_name,country
FROM employees e,regions r
WHERE r.region_id=e.region_id;

SELECT first_name,email,division,d.department
FROM employees e,departments d,regions r
WHERE e.department = d.department
  AND e.region_id=r.region_id;

SELECT first_name,country
FROM employees INNER JOIN regions
                          ON employees.region_id=regions.region_id;

SELECT  first_name,email,division
FROM employees e INNER JOIN  departments d
                             ON e.department=d.department
WHERE email IS NOT NULL;

SELECT first_name,email,division,country
FROM employees e INNER JOIN departments d
                            ON e.department=d.department INNER JOIN  regions r
                                                                     ON e.region_id=r.region_id
WHERE email IS NOT NULL;

SELECT distinct department from employees;--31

SELECT distinct department from departments;--24

SELECT distinct e.department,d.department
FROM employees e LEFT JOIN  departments d
                            ON e.department=d.department;

SELECT distinct e.department,d.department
FROM employees e RIGHT JOIN  departments d
                             ON e.department=d.department;
