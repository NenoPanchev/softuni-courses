#1
DELIMITER $$
CREATE FUNCTION `ufn_count_employees_by_town`(`town_name` VARCHAR(45)) 
RETURNS int
    DETERMINISTIC
BEGIN
DECLARE counter INT;
SET counter := (SELECT COUNT(*) 
FROM employees AS e
JOIN addresses AS a
ON a.address_id = e.address_id
JOIN towns AS t
ON a.town_id = t.town_id
WHERE t.`name` = town_name);
RETURN counter;
END $$
DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia');

#2
DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(45))
BEGIN
UPDATE employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
SET salary = salary * 1.05
WHERE d.`name` = department_name;
END 
$$

DELIMITER ;

CALL usp_raise_salaries('Finance');

SELECT first_name, salary FROM employees 
WHERE department_id = 10;


#3
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(emp_id INT)
BEGIN 
	START TRANSACTION;
		IF ((SELECT COUNT(employee_id) 
        FROM employees
		WHERE employee_id = emp_id) != 1)
		THEN 
    ROLLBACK;
		ELSE
		UPDATE employees 
		SET salary = salary * 1.05
		WHERE employee_id = emp_id;
    END IF;
END
$$
DELIMITER ;
CALL usp_raise_salary_by_id(178);

SELECT `salary` FROM employees
WHERE employee_id = 178;

#4
CREATE TABLE deleted_employees (
employee_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
middle_name VARCHAR(20),
job_title VARCHAR(20),
department_id INT,
salary DECIMAL
);
DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
INSERT INTO deleted_employees (first_name, last_name, middle_name, job_title, department_id, salary)
VALUES
(OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END $$

DELIMITER ;

SELECT * FROM deleted_employees;
DELETE FROM employees
WHERE employee_id = 293;