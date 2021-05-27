CREATE DATABASE users;
USE users;

#7
CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL UNIQUE,
	password VARCHAR(26) NOT NULL,
	profile_picture BLOB(900),
	last_login_time TIMESTAMP,
	is_deleted BOOL
);
	
INSERT INTO users(username, password, last_login_time, is_deleted)
	VALUES('vankata_91', '12346qwerty', '2007-11-11', false),
('machinata', '12346qwerty', '1991-11-11', false),
('piqsamorakiq', '12346qwerty', '2016-01-11', false),
('mlqkoto', '12346qwerty', '2017-11-11', true),
('otperniksam', '12346qwerty', '2016-11-11', false);
	

#8
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users 
PRIMARY KEY (id, username);

#9
ALTER TABLE users
MODIFY COLUMN last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL;
	    
#10
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users 
PRIMARY KEY (id),
MODIFY COLUMN username
VARCHAR(30) UNIQUE NOT NULL;
	
DELETE FROM users;