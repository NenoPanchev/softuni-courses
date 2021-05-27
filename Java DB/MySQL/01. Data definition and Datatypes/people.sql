CREATE DATABASE people;
USE people;

#6
CREATE TABLE people
(
	id INT UNIQUE AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	picture LONGBLOB,
	height FLOAT(2),
	weight FLOAT(2),
	gender CHAR(1) NOT NULL,
	birthdate DATE NOT NULL,
	biography TEXT
);

INSERT INTO people(name, gender, birthdate) 
VALUES ('Gosho', 'm', '1971-03-21'),
('Ivan', 'm', '1991-11-03');

INSERT INTO people(name, height, weight, gender, birthdate, biography)
 VALUES('Maria', 12.12, 2.134, 'f', '1992-11-11', 'Very important person!'),
 ('Ivanka', 12.1212312312, 22.134, 'f', '1962-11-05', 'Very ambitious person!'),
('Nenka', 4.1212312312, 221.134, 'f', '1962-03-05', 'Very stupid person!');

DELETE FROM people;