DROP DATABASE soft_uni;

CREATE DATABASE soft_uni;

CREATE TABLE towns (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE addresses (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	address_text TEXT, 
	town_id INT(14)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE departments (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE employees (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(250),
	middle_name VARCHAR(250),
	last_name VARCHAR(250),
	job_title VARCHAR(100),
	department_id INT(14),
	hire_date DATETIME,
	salary DECIMAL(10, 2),
	address_id INT(14)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

ALTER TABLE employees
ADD CONSTRAINT fk_department_id
FOREIGN KEY (department_id) REFERENCES departments(id);

SELECT towns.name FROM towns ORDER BY towns.name;
SELECT departments.name FROM departments ORDER BY departments.name;
SELECT employees.first_name, employees.last_name, employees.job_title, employees.salary FROM employees ORDER BY employees.salary DESC; 

UPDATE employees SET employees.salary=employees.salary * 1.1;
SELECT employees.salary FROM employees;