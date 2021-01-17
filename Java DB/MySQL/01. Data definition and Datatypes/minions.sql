CREATE DATABASE minions;

CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    age INT
);

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250)
);

ALTER TABLE minions
ADD town_id INT,
ADD FOREIGN KEY (town_id) REFERENCES towns(id);

INSERT INTO towns(id, name) VALUES (1, 'Sofia');
INSERT INTO towns(id, name) VALUES (2, 'Plovidv');
INSERT INTO towns(id, name) VALUES (3, 'Varna');

INSERT INTO minions(name, age, town_id) VALUES ('Kevin', 22, 1);
INSERT INTO minions(name, age, town_id) VALUES ('Bob', 15, 3);
INSERT INTO minions(name, town_id) VALUES ('Steward', 2);

DELETE FROM minions;
DELETE FROM towns;

DROP TABLE minions;
DROP TABLE towns;