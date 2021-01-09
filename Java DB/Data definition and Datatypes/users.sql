CREATE DATABASE users;

CREATE TABLE users (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(26) NOT NULL,
	profile_picture BLOB(900),
	last_login_time TIMESTAMP,
	is_deleted BOOL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('vankata_91', '12346qwerty', '2007-11-11', false);
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('machinata', '12346qwerty', '1991-11-11', false);
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('piqsamorakiq', '12346qwerty', '2016-01-11', false);
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('mlqkoto', '12346qwerty', '2017-11-11', true);
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('otperniksam', '12346qwerty', '2016-11-11', false);
	
ALTER TABLE users
MODIFY COLUMN last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL;

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (id, username);

ALTER TABLE users
DROP PRIMARY KEY;

	
	
DELETE FROM users;