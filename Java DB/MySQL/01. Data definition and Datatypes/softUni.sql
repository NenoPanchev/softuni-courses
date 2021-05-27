DROP DATABASE soft_uni;

CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE addresses (
	id INT PRIMARY KEY AUTO_INCREMENT,
	address_text TEXT, 
	town_id INT,
    CONSTRAINT fk_town_id
    FOREIGN KEY (town_id)
    REFERENCES towns(id)
);

CREATE TABLE departments (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(250) NOT NULL
);

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	middle_name VARCHAR(50),
	last_name VARCHAR(50) NOT NULL,
	job_title VARCHAR(100),
	department_id INT,
	hire_date DATE,
	salary DECIMAL(10, 2),
	address_id INT,
    CONSTRAINT fk_department_id
	FOREIGN KEY (department_id) 
    REFERENCES departments(id),
    
    CONSTRAINT fk_address_id
	FOREIGN KEY (address_id) 
    REFERENCES addresses(id)
);

#13
INSERT INTO towns(name)
VALUES('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO addresses(address_text, town_id)
VALUES ('Opalchenska', 1),
('Morska', 4),
('Ruski', 2),
('More', 2),
('Lek', 3);

INSERT INTO departments(name)
VALUES ('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO employees
VALUES (1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, 3),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, 1),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 2),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00, 4),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 5);

#14
SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

#15
SELECT * FROM towns
ORDER BY name;

SELECT * FROM departments
ORDER BY name;

SELECT * FROM employees
ORDER BY salary DESC;

#16
SELECT name FROM towns ORDER BY name;
SELECT name FROM departments ORDER BY name;
SELECT first_name, last_name, job_title, salary 
FROM employees 
ORDER BY salary DESC; 

#17
UPDATE employees 
SET salary = salary * 1.1;
SELECT salary FROM employees;

#18
TRUNCATE occupancies;