#2
INSERT INTO products_stores
SELECT p.id, 1
FROM products AS p
LEFT JOIN products_stores AS ps
ON ps.product_id = p.id
WHERE ps.store_id IS NULL;

#3
UPDATE employees
SET manager_id = 3, salary = salary - 500
WHERE YEAR(hire_date) > '2003'
AND store_id NOT IN(5, 14);
SET SQL_SAFE_UPDATES = 1;

#4
DELETE FROM employees
WHERE manager_id IS NOT NULL
AND salary >= 6000;

#5
SELECT first_name, middle_name, last_name, salary, hire_date
FROM employees
ORDER BY hire_date DESC;

#6
SELECT pr.`name` AS product_name,
price, best_before,
CONCAT(LEFT(`description`, 10), '...') AS short_description,
url
FROM products AS pr
JOIN pictures AS p
ON pr.picture_id = p.id
WHERE YEAR(added_on) < '2019'
AND price > 20
AND CHAR_LENGTH(`description`) > 100
ORDER BY price DESC; 

#7
SELECT s.`name`, COUNT(p.id) AS product_count, ROUND(AVG(price), 2) AS `avg`
FROM stores AS s
LEFT JOIN products_stores AS ps
ON s.id = ps.store_id
LEFT JOIN products AS p
ON ps.product_id = p.id
GROUP BY s.id
ORDER BY product_count DESC, `avg` DESC, s.id;

#8
SELECT CONCAT_WS(' ', first_name, last_name) AS Full_name,
s.`name` AS Store_name, a.`name` AS address, salary
FROM addresses AS a
JOIN stores AS s
ON s.address_id = a.id
JOIN employees AS e
ON e.store_id = s.id
WHERE salary < 4000
AND a.`name` LIKE('%5%')
AND CHAR_LENGTH(s.`name`) > 8
AND RIGHT(last_name, 1) = 'n';

#9
SELECT REVERSE(s.`name`) AS reversed_name,
CONCAT(UPPER(t.`name`), '-', a.`name`) AS full_address,
COUNT(e.id) AS employees_count
FROM towns AS t
JOIN addresses AS a
ON a.town_id = t.id
JOIN stores AS s
ON s.address_id = a.id
JOIN employees AS e
ON e.store_id = s.id
GROUP BY s.id
HAVING employees_count >= 1
ORDER BY full_address;

#10
DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT_WS(' ', first_name, CONCAT(middle_name, '.'), last_name, 'works in store for',
TIMESTAMPDIFF(YEAR, hire_date, '2020-10-18'), 'years')
FROM employees AS e
JOIN stores AS s
ON e.store_id = s.id
WHERE s.`name` = store_name
ORDER BY salary DESC
LIMIT 1);
END $$
DELIMITER ;

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

#11
DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
	UPDATE products AS p
JOIN products_stores AS ps
ON ps.product_id = p.id
JOIN stores AS s 
ON ps.store_id = s.id
JOIN addresses AS a
ON s.address_id = a.id
SET price = price + (SELECT IF(LEFT(a.`name`, 1) = '0', 100, 200))
WHERE a.`name` = address_name;
END $$
DELIMITER ;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;


SELECT IF(LEFT(a.`name`, 1) = '0', 100, 200)
FROM addresses AS a
WHERE a.id = 2;

UPDATE products AS p
JOIN products_stores AS ps
ON ps.product_id = p.id
JOIN stores AS s 
ON ps.store_id = s.id
JOIN addresses AS a
ON s.address_id = a.id
SET price = price + (SELECT IF(LEFT(a.`name`, 1) = '0', 100, 200))
WHERE a.`name` = address_name;
