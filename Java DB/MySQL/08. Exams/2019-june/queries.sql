#2
INSERT INTO cards (card_number, card_status, bank_account_id)
(SELECT reverse(full_name), 'Active', id
FROM clients
WHERE id BETWEEN 191 AND 200);

#3
SELECT c.full_name, c.id, e.id, e.first_name, e.last_name
FROM clients AS c
JOIN employees_clients As ec
ON ec.client_id = c.id
JOIN employees AS e
ON ec.employee_id = e.id
WHERE c.id = e.id;

SELECT employee_id
FROM employees_clients
GROUP BY employee_id
ORDER BY COUNT(client_id), employee_id
LIMIT 1;

UPDATE employees_clients AS ec
SET ec.employee_id = 
(
	SELECT ecc.employee_id FROM (SELECT * FROM employees_clients) AS ecc
	GROUP BY employee_id
	ORDER BY COUNT(ecc.client_id), ecc.employee_id
	LIMIT 1
)
WHERE ec.employee_id = ec.client_id;

#4
DELETE FROM employees
WHERE id NOT IN (SELECT employee_id FROM employees_clients);

#5
SELECT id, full_name
FROM clients
ORDER BY id;

#6
SELECT id, CONCAT(first_name, ' ', last_name) AS full_name,
CONCAT('$', salary), started_on
FROM employees
WHERE salary >= 100000
AND started_on >= '2018-01-01'
ORDER BY salary DESC, id;

#7
SELECT c.id, CONCAT(c.card_number, ' : ', cl.full_name) AS card_token
FROM cards AS c
LEFT JOIN bank_accounts AS ba
ON c.bank_account_id = ba.id
LEFT JOIN clients AS cl
ON ba.client_id = cl.id
ORDER BY c.id DESC;

#8
SELECT concat(e.first_name, ' ', e.last_name) AS `name`,
e.started_on, COUNT(ec.client_id) AS count_of_clients
FROM employees AS e
JOIN employees_clients AS ec
ON e.id = ec.employee_id
GROUP BY ec.employee_id
ORDER BY count_of_clients DESC
LIMIT 5;

#9
SELECT b.`name`, COUNT(c.id) AS count_of_cards
FROM branches AS b
LEFT JOIN employees AS e
ON e.branch_id = b.id
LEFT JOIN employees_clients AS ec
ON e.id = ec.employee_id
LEFT JOIN clients AS cl
ON cl.id = ec.client_id
LEFT JOIN bank_accounts AS ba
ON ba.client_id = cl.id
LEFT JOIN cards AS c
ON c.bank_account_id = ba.id
GROUP BY b.`name`
ORDER BY count_of_cards DESC, b.`name`;

#10
DELIMITER $$
CREATE FUNCTION udf_client_cards_count(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(c.id)
FROM clients AS cl
JOIN bank_accounts AS ba ON ba.client_id = cl.id
JOIN cards AS c ON c.bank_account_id = ba.id
WHERE cl.full_name = `name`);
END $$
DELIMITER ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM
clients c
WHERE c.full_name = 'Baxy David';

#12
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(given_name VARCHAR(50))
BEGIN
SELECT cl.full_name, cl.age, ba.account_number, concat('$', ba.balance) AS balance
FROM clients AS cl
JOIN bank_accounts AS ba
ON ba.client_id = cl.id
WHERE cl.full_name = given_name;
END $$
DELIMITER ;

CALL udp_clientinfo('Hunter Wesgate');