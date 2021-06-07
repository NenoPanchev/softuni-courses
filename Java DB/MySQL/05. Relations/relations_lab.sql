#1
CREATE TABLE `mountains` (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `peaks` (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
mountain_id INT NOT NULL
);
ALTER TABLE peaks
ADD CONSTRAINT fk_peak_mountain
FOREIGN KEY (mountain_id)
REFERENCES mountains(id);

#2
SELECT v.driver_id, v.vehicle_type, CONCAT(first_name,' ', last_name) AS `driver_name`
FROM vehicles AS v 
JOIN campers AS c
ON v.driver_id = c.id;

#3
SELECT r.`starting_point` AS `route_starting_point`,
r.`end_point` AS `route_ending_point`,
r.`leader_id`,
CONCAT(`first_name`, ' ', `last_name`) AS `leader_name`
FROM `routes` AS r
JOIN `campers` AS c
ON r.`leader_id` = c.`id`;

#4
DROP TABLE mountains;
DROP TABLE peaks;

CREATE TABLE `mountains` (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `peaks` (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
mountain_id INT NOT NULL,
CONSTRAINT fk_peak_mountain
FOREIGN KEY (mountain_id)
REFERENCES mountains(id)
ON DELETE CASCADE
);

INSERT INTO `mountains`
VALUES
(1, 'Rila'),
(2, 'Pirin'),
(3, 'Stara Planina');

INSERT INTO peaks
VALUES
(1, 'Musala', 1),
(2, 'Vryh 2', 2),
(3, 'Botev', 3),
(4, 'Sedinka', 3);

SET SQL_SAFE_UPDATES = 1;

DELETE FROM mountains
WHERE `name` = 'Stara Planina';

#5
CREATE DATABASE `project_management`;
USE `project_management`;

CREATE TABLE `clients` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`client_name` VARCHAR(100) NOT NULL
);

CREATE TABLE `projects` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`client_id` INT NOT NULL,
`project_lead_id` INT NOT NULL,
CONSTRAINT fk_client_id
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`project_id` INT NOT NULL,
CONSTRAINT fk_project_id
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT fk_project_employee_id
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`);