DROP DATABASE homework;
CREATE DATABASE homework;

CREATE TABLE directors (
	id INT(14) PRIMARY KEY UNIQUE AUTO_INCREMENT,
	director_name VARCHAR(50) NOT NULL,
	notes VARCHAR(250) NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE genres (
	id INT(14) PRIMARY KEY UNIQUE AUTO_INCREMENT,
	genre_name VARCHAR(50) NOT NULL,
	notes VARCHAR(250) NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE categories (
	id INT(14) PRIMARY KEY UNIQUE AUTO_INCREMENT,
	category_name VARCHAR(50) NOT NULL,
	notes VARCHAR(50) NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE movies (
	id INT(14) PRIMARY KEY UNIQUE AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
	director_id INT(14),
	copyright_year TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	length INT(14) DEFAULT 0,
	genre_id INT(14),
	category_id INT(14),
	notes VARCHAR(250) NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

ALTER TABLE movies
ADD CONSTRAINT fk_director_id
FOREIGN KEY (director_id) REFERENCES directors(id);

ALTER TABLE movies
ADD CONSTRAINT fk_genre_id
FOREIGN KEY (genre_id) REFERENCES genres(id);

ALTER TABLE movies
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES categories(id);


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

INSERT INTO movies (title, director_id, copyright_year, length, genre_id, category_id, notes) 
	VALUES ('Americant Ninja', '1', '2017-05-27 16:27:12', '123123', '2', '3', 'Very Stupid MOvie'),
			 ('Ivan Ivanovich', '2', '2017-05-27 16:27:12', '123123', '1', '2', 'Just a MOvie'),
			 ('Mafia', '3', '2017-05-27 16:27:12', '123123', '3', '1', '...'),
			 ('Fifty yards', '4', '2017-05-27 16:27:12', '123123', '5', '5', 'Query'),
			 ('Klashes', '5', '2017-05-27 16:27:12', '123123', '4', '4', 'KAJHSDUhIAJSD');