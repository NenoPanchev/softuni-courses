CREATE DATABASE minions;
USE minions;

#1
CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    age INT
);

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250)
);

#2
ALTER TABLE minions
ADD town_id INT,
ADD FOREIGN KEY (town_id) REFERENCES towns(id);

#3
INSERT INTO towns(name) VALUES ('Sofia'), 
('Plovdiv'),
('Varna');

INSERT INTO minions(name, age, town_id) VALUES ('Kevin', 22, 1);
INSERT INTO minions(name, age, town_id) VALUES ('Bob', 15, 3);
INSERT INTO minions(name, town_id) VALUES ('Steward', 2);

#4
TRUNCATE minions;

#5
DROP TABLE minions;
DROP TABLE towns;