DROP DATABASE gamebar;
CREATE DATABASE gamebar;

#1
CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
    `category_id` INT NOT NULL
);

#2
INSERT INTO employees (first_name, last_name) 
	VALUES ('Kolio', 'Grigorov'),
			 ('Kiro', 'Petrov'),
			 ('Stefan', 'Petkov');

#3
ALTER TABLE employees
ADD COLUMN middle_name VARCHAR(50);

#4
ALTER TABLE products
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES categories(id);

#5
ALTER TABLE employees
MODIFY COLUMN middle_name VARCHAR(100);