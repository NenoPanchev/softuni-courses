#2
INSERT INTO clients (full_name, phone_number)
SELECT CONCAT(first_name, ' ', last_name),
CONCAT('(088) 9999', id * 2)
FROM drivers
WHERE id BETWEEN 10 AND 20;

#3
UPDATE cars 
SET `condition` = 'C'
WHERE make NOT LIKE('%Mercedes-Benz%')
AND `year` <= 2010
AND (mileage >= 800000 OR mileage IS NULL);

#4
DELETE FROM clients
WHERE id NOT IN (SELECT client_id FROM courses)
AND CHAR_LENGTH(full_name) > 3;

#5
SELECT make, model, `condition` FROM cars;

#6
SELECT first_name, last_name, make, model, mileage
FROM drivers AS d
JOIN cars_drivers AS cd
ON cd.driver_id = d.id
JOIN cars AS c 
ON cd.car_id = c.id
WHERE mileage IS NOT NULL
ORDER BY mileage DESC, first_name;

#7
SELECT c.id AS car_id, make, mileage,
COUNT(co.id) AS count_of_courses,
ROUND(AVG(bill), 2) AS avg_bill
FROM cars AS c
LEFT JOIN courses AS co
ON co.car_id = c.id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;

#8
SELECT full_name, COUNT(c.id) AS count_of_cars,
SUM(bill) AS total_sum
FROM clients AS c
JOIN courses AS co
ON co.client_id = c.id
WHERE full_name LIKE ('_a%')
GROUP BY c.id
HAVING count_of_cars > 1
ORDER BY full_name;

#9
SELECT a.`name`,
IF (HOUR(`start`) BETWEEN 6 AND 20, 'Day', 'Night') AS day_time,
bill, full_name, make, model, cat.`name` AS category_name
FROM addresses AS a
JOIN courses AS co
ON co.from_address_id = a.id
JOIN clients AS cl
ON co.client_id = cl.id
JOIN cars AS c
ON co.car_id = c.id
JOIN categories AS cat
ON c.category_id = cat.id
ORDER BY co.id;

#10
DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.id)
FROM clients AS cl
LEFT JOIN courses AS co
ON co.client_id = cl.id
WHERE cl.phone_number = phone_num);
END $$
DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 
SELECT udf_courses_by_client ('(831) 1391236') as `count`;
SELECT udf_courses_by_client ('(704) 2502909') as `count`;

#11
DELIMITER $$
CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR(100))
BEGIN
	SELECT a.`name`, full_name AS full_names,
(CASE
WHEN bill <= 20 THEN 'Low'
WHEN bill BETWEEN 21 AND 30 THEN 'Medium'
ELSE 'High'
END) AS level_of_bill,
make, `condition`, cat.`name` AS cat_name
FROM addresses AS a
JOIN courses AS co
ON co.from_address_id = a.id
JOIN clients AS cl
ON co.client_id = cl.id
JOIN cars AS c
ON co.car_id = c.id
JOIN categories AS cat
ON c.category_id = cat.id
WHERE a.`name` = address_name
ORDER BY make, full_name;
END $$
DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');
CALL udp_courses_by_address('66 Thompson Drive');