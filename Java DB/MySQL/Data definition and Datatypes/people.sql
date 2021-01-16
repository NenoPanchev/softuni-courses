CREATE DATABASE people;


CREATE TABLE people
(
	id INT(14) UNIQUE AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	picture LONGBLOB NULL,
	height FLOAT(10, 2) NULL,
	weight FLOAT(10, 2) NULL,
	gender TINYINT(1) NOT NULL,
	birthdate DATE NOT NULL,
	biography LONGTEXT NULL
);

INSERT INTO people(name, gender, birthdate) VALUES ('Gosho', 1, '1971-03-21');

INSERT INTO people(name, gender, birthdate) VALUES ('Ivan', 1, '1991-11-03');

INSERT INTO people(name, height, weight, gender, birthdate, biography)
 VALUES('Maria', 12.12, 2.134, 0, '1992-11-11', 'Very important person!');
 
INSERT INTO people(name, height, weight, gender, birthdate, biography) 
VALUES('Ivanka', 12.1212312312, 22.134, 0, '1962-11-05', 'Very ambitious person!');

INSERT INTO people(name, height, weight, gender, birthdate, biography) 
VALUES('Nenka', 4.1212312312, 221.134, 0, '1962-03-05', 'Very stupid person!');

DELETE FROM people;