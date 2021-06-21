#1
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
SELECT first_name, last_name FROM employees
WHERE salary > 35000
ORDER BY first_name, last_name, employee_id;
END $$

DELIMITER ;
CALL usp_get_employees_salary_above_35000;

#2
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(sal DECIMAL(19, 4))
BEGIN
SELECT first_name, last_name FROM employees
WHERE salary >= sal
ORDER BY first_name, last_name, employee_id;
END $$

DELIMITER ;
CALL usp_get_employees_salary_above(45000);

#3
SELECT `name` FROM towns
WHERE `name` LIKE ('b%')
ORDER BY `name`;

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(starts_with VARCHAR(10))
BEGIN
SELECT `name` FROM towns
WHERE `name` LIKE CONCAT(starts_with, '%')
ORDER BY `name`;
END $$
DELIMITER ;
CALL usp_get_towns_starting_with('b');

#4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(given_town VARCHAR(30))
BEGIN
SELECT e.first_name, e.last_name
FROM employees AS e
JOIN addresses AS a
ON a.address_id = e.address_id
JOIN towns AS t
ON t.town_id = a.town_id
WHERE t.`name` = given_town
ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;
CALL usp_get_employees_from_town('Sofia');

#5
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(given_salary DECIMAL)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
RETURN (CASE
WHEN given_salary < 30000 THEN 'Low'
WHEN given_salary BETWEEN 30000 AND 50000 THEN 'Average'
WHEN given_salary > 50000 THEN 'High'
END);
END $$
DELIMITER ;
SELECT ufn_get_salary_level(60000);

#6
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
SELECT first_name, last_name FROM employees
WHERE (SELECT ufn_get_salary_level(salary)) = salary_level
ORDER BY first_name DESC, last_name DESC;
END $$
DELIMITER ;
CALL usp_get_employees_by_salary_level('high');

#7
SELECT 'bob' REGEXP CONCAT('^[', 'oistmiahf', ']+$');
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN 
RETURN (SELECT word REGEXP(CONCAT('^[', set_of_letters, ']+$')));
END $$
DELIMITER ;
SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
SELECT ufn_is_word_comprised('oistmiahf', 'halves');
SELECT ufn_is_word_comprised('bobr', 'Rob');
SELECT ufn_is_word_comprised('pppp', 'Guy');
SELECT 1 = (SELECT ufn_is_word_comprised('oistmiahf', 'Sofia'));

#8
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT CONCAT(first_name, ' ', last_name) AS full_name
FROM account_holders
ORDER BY full_name, id;
END $$
DELIMITER ;
CALL usp_get_holders_full_name();

#9
SELECT ah.first_name, ah.last_name
FROM account_holders AS ah
JOIN accounts AS a
ON a.account_holder_id = ah.id
GROUP BY a.account_holder_id
HAVING SUM(a.balance) > 7000;

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(given_balance DECIMAL)
BEGIN
SELECT ah.first_name, ah.last_name
FROM account_holders AS ah
JOIN accounts AS a
ON a.account_holder_id = ah.id
GROUP BY a.account_holder_id
HAVING SUM(a.balance) > given_balance
ORDER BY ah.id;
END $$
DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);

#10
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest_rate DOUBLE, years INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
RETURN (SELECT sum * (POW((1 + yearly_interest_rate), years)));
END $$
DELIMITER ;
SELECT 1000 * (POW((1 + 0.5), 5));
SELECT ufn_calculate_future_value(1000, 0.5, 5);

#11
SELECT a.id AS account_id, ah.first_name, ah.last_name, a.balance AS current_balance,
(SELECT ufn_calculate_future_value(a2.balance, 0.1, 5)
FROM accounts AS a2
WHERE a.id = a2.id) AS balance_in_5_years
FROM accounts AS a
JOIN account_holders AS ah
ON a.account_holder_id = ah.id
WHERE a.id = 1;

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(given_acc_id INT, given_interest DECIMAL(19, 4))
BEGIN
SELECT a.id AS account_id, ah.first_name, ah.last_name, a.balance AS current_balance,
(SELECT ufn_calculate_future_value(a2.balance, given_interest, 5)
FROM accounts AS a2
WHERE a.id = a2.id) AS balance_in_5_years
FROM accounts AS a
JOIN account_holders AS ah
ON a.account_holder_id = ah.id
WHERE a.id = given_acc_id;
END $$
DELIMITER ;
CALL usp_calculate_future_value_for_account(1, 0.1);

#12
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(given_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
IF (SELECT COUNT(*) 
        FROM accounts
		WHERE id = given_account_id) = 1
        AND money_amount > 0
THEN 
	UPDATE accounts
	SET balance = balance + money_amount
	WHERE id = given_account_id;
	COMMIT;
ELSE
	ROLLBACK;
END IF;
END $$
DELIMITER ;

CALL usp_deposit_money(1, 10);

#13
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(given_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
IF (SELECT COUNT(*) 
        FROM accounts
		WHERE id = given_account_id) = 0
        OR money_amount <= 0
        OR (SELECT balance FROM accounts
        WHERE id = given_account_id) < money_amount
THEN 
ROLLBACK;
ELSE
	UPDATE accounts
	SET balance = balance - money_amount
	WHERE id = given_account_id;
END IF;
END $$
DELIMITER ;

CALL usp_withdraw_money(1, 10);

#14
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
IF from_account_id IN (SELECT id FROM accounts)
	AND to_account_id IN (SELECT id FROM accounts)
	AND amount > 0
	AND (SELECT balance FROM accounts WHERE id = from_account_id) >= amount
    AND from_account_id != to_account_id
    THEN
    UPDATE accounts
	SET balance = balance - amount
	WHERE id = from_account_id;
    UPDATE accounts
	SET balance = balance + amount
	WHERE id = to_account_id;
COMMIT;
ELSE
ROLLBACK;
END IF;
END $$
DELIMITER ;
CALL usp_transfer_money(2, 1, 10);

DELIMITER $$
CREATE PROCEDURE usp_transfer_money1(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
IF from_account_id NOT IN (SELECT id FROM accounts)
	OR to_account_id NOT IN (SELECT id FROM accounts)
	OR amount <= 0
	OR (SELECT balance FROM accounts WHERE id = from_account_id) < amount
    OR from_account_id = to_account_id
    THEN
ROLLBACK;
	ELSE
    UPDATE accounts
	SET balance = balance - amount
	WHERE id = from_account_id;
    UPDATE accounts
	SET balance = balance + amount
	WHERE id = to_account_id;
END IF;
END $$
DELIMITER ;
CALL usp_transfer_money1(2, 1, 10);

#15
CREATE TABLE `logs` (
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT NOT NULL,
old_sum DECIMAL(19, 4),
new_sum DECIMAL(19, 4)
);

DELIMITER $$
CREATE TRIGGER tr_log_balance_changes
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
INSERT INTO `logs` (account_id, `old_sum`, `new_sum`)
VALUES
(OLD.id, OLD.balance, NEW.balance);
END $$
DELIMITER ;
CALL usp_deposit_money(1, 10);
SELECT * FROM `logs`;

#16
CREATE TABLE notification_emails (
id INT PRIMARY KEY AUTO_INCREMENT,
recipient INT,
`subject` VARCHAR(100),
body TEXT
);

DROP TRIGGER tr_emails_when_inserting_to_logs;

DELIMITER $$
CREATE TRIGGER tr_emails_when_inserting_to_logs
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
INSERT INTO notification_emails (recipient, `subject`, body)
VALUES
(NEW.account_id, CONCAT('Balance change for account: ', NEW.account_id), 
CONCAT('On ', DATE_FORMAT(CURRENT_TIMESTAMP(), '%b %d %Y at %r'), ' your balance was changed from ',
NEW.old_sum, ' to ', NEW.new_sum, '.'));
END $$
DELIMITER ;

INSERT INTO notification_emails (recipient, `subject`, body)
VALUES
(1, CONCAT('Balance change for account: ', 1), 
CONCAT('On ', DATE_FORMAT(CURRENT_TIMESTAMP(), '%b %d %Y at %r'), ' your balance was changed from ',
ROUND(133.12), ' to ', ROUND(143.12), '.'));

CALL usp_deposit_money(1, 10);
CALL usp_withdraw_money(1, 10);
SELECT * FROM `logs`;
SELECT * FROM `notification_emails`;
TRUNCATE TABLE notification_emails;