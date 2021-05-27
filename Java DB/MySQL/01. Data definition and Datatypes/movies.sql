DROP DATABASE movies;
CREATE DATABASE movies;
USE movies;

CREATE TABLE directors (
	id INT PRIMARY KEY AUTO_INCREMENT,
	director_name VARCHAR(50) NOT NULL,
	notes VARCHAR(250)
);

CREATE TABLE genres (
	id INT PRIMARY KEY AUTO_INCREMENT,
	genre_name VARCHAR(50) NOT NULL,
	notes VARCHAR(250)
);

CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(50) NOT NULL,
	notes VARCHAR(250)
);

CREATE TABLE movies (
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	director_id INT,
	copyright_year YEAR,
	length INT,
	genre_id INT,
	category_id INT,
    rating FLOAT,
	notes VARCHAR(250)
);

INSERT INTO directors (director_name, notes) 
	VALUES ('Kolio', 'Golqm Igrach'),
			 ('Kiro', 'Nai mnogo obicham da pravq filmi'),
			 ('Stefan', 'Komedii nomer edno'),
			 ('Poruchik', 'Bezizvesten'),
			 ('Rjevski', 'Na Poruchik brat mu');
			 
INSERT INTO genres (genre_name, notes) 
	VALUES ('Comedy', 'Funny Moveis'),
			 ('Adventure', 'Adventure Movies'),
			 ('Crime', 'Best Movies'),
			 ('Drama', 'NO notes'),
			 ('Fantasy', '...');

INSERT INTO categories (category_name, notes) 
	VALUES ('Bulgarian', 'Strange Language, Strange Humour'),
			 ('Serbian', 'Almost like Bulgarian'),
			 ('American', 'A piece of shit'),
			 ('Russian', 'Almost the same'),
			 ('North Korea', 'Ahahahha');

INSERT INTO movies (title, director_id, copyright_year, length, genre_id, category_id, rating, notes) 
	VALUES ('Americant Ninja', 1, '2017', 180, 2, 3, 8.2, 'Very Stupid MOvie'),
			 ('Ivan Ivanovich', 2, '2017', 122, 1, 2, 7.8, 'Just a MOvie'),
			 ('Mafia', 3, '2014', 98, 3, 1, 6.9, '...'),
			 ('Fifty yards', 4, '2015', 101, 5, 5, 5.5, 'Query'),
			 ('Klashes', 5, '2016', 130, 4, 4, 7.4, 'KAJHSDUhIAJSD');