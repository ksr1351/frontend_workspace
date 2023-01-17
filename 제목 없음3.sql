SELECT * FROM  mem;

--두개의 테이블을 join해서 가져옴 (employees, departments)
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;