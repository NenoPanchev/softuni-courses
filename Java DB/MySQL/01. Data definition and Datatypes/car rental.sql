CREATE DATABASE car_rental;

DROP DATABASE car_rental;

CREATE TABLE categories (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	category VARCHAR(250) NOT NULL,
	daily_rate DECIMAL(10,2) DEFAULT 0,
	weekly_rate DECIMAL(10,2)  DEFAULT 0,
	monthly_rate DECIMAL(10,2) DEFAULT 0,
	weekend_rate DECIMAL(10,2) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8; 

CREATE TABLE cars (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	plate_number VARCHAR(50) NOT NULL,
	make VARCHAR(250) NOT NULL,
	model VARCHAR(250) NOT NULL,
	car_year INT(5) NOT NULL,
	category_id INT(14),
	doors INT(2) NULL,
	picture BLOB,
	car_condition VARCHAR(250) NULL,
	available BOOL DEFAULT false
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8; 

CREATE TABLE employees (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL,
	title VARCHAR(250) NOT NULL,
	notes VARCHAR(250) NULL
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8; 

CREATE TABLE customers (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	driver_licence_number INT(14) NOT NULL,
	full_name VARCHAR(250) NOT NULL,
	address VARCHAR(250) NOT NULL,
	city VARCHAR(250) NOT NULL,
	zip_code INT(12) NOT NULL,
	notes VARCHAR(250) NULL
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8; 

CREATE TABLE rental_orders (
	id INT(14) PRIMARY KEY AUTO_INCREMENT,
	employee_id INT(14),
	customer_id INT(14),
	car_id INT(14),
	car_condition VARCHAR(250) NULL,
	tank_level FLOAT(12, 2) NOT NULL,
	kilometrage_start INT(12) NOT NULL,
	kilometrage_end INT(12) NOT NULL,
	total_kilometrage INT(12) NOT NULL,
	start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	end_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	total_days INT(8) DEFAULT 0,
	rates_applied DECIMAL(14, 2) NOT NULL,
	tax_rate DECIMAL(14, 2) NOT NULL,
	order_status VARCHAR(250) DEFAULT 'inactive',
	notes VARCHAR(250) NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8; 

ALTER TABLE rental_orders
ADD CONSTRAINT fk_employee_id
FOREIGN KEY (employee_id) REFERENCES employees(id);

ALTER TABLE rental_orders
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customers(id);

ALTER TABLE rental_orders
ADD CONSTRAINT fk_car_id
FOREIGN KEY (employee_id) REFERENCES employees(id);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate) 
	VALUES('Autos', 1.12, 1.51, 1.22, 2.11),
			('Bus', 2.12, 3.112, 5.22, 6.11),
			('Truck', 10.1, 11.1, 12.1, 15.15);
			
INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, car_condition, available) 
	VALUES('PB6612MM', 'Ford', 'Fiesta', '1992', '1', 4, 'Good Condition', true),
			('CM3122MM', 'Seat', 'Ibiza', '2007', '2', 3, 'Bad Condition', true),
			('A6142MM', 'Volkswagen', 'Golf III', '1996', '3', 2, 'Golf Bate', false);
			
INSERT INTO employees(first_name, last_name, title, notes) 
	VALUES ('Ivan', 'Petrov', 'Seller', 'Mnogo gotin pich'),
			 ('Nikolay', 'Ivanov', 'Boss', 'Bash maistora'),
			 ('Kolio', 'Malkinov', 'Kafedjiq', 'Samo pie kafeta');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes)
	VALUES (123123123, 'Ivan Ivanov', 'DIanabad', 'Sofia', 1000, 'DObro minalo'),
			 (321321321, 'Tinko PIcha', 'Karshiaka', 'Plovdiv', 4000, 'Super Ailqk pich'),
			 (748737812, 'Kolio Gochev', 'Burgas 63', 'Burgas', 6000, 'Burgaska Batka');


INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rates_applied, tax_rate, order_status, notes) 
	VALUES ('1', '1', '1', 'Good', 35.2, 158000, 158200, 158200, '2017-03-03', '2017-04-04', 31, 2.14, 5.2, 'active', 'No Porblems'),
			 ('2', '3', '2', 'Good', 35.2, 158000, 158200, 158200, '2017-03-03', '2017-04-04', 31, 2.14, 5.2, 'active', 'No Porblems'),
			 ('3', '2', '3', 'Good', 35.2, 158000, 158200, 158200, '2017-03-03', '2017-04-04', 31, 2.14, 5.2, 'active', 'No Porblems');