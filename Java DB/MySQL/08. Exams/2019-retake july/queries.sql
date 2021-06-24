#2
INSERT INTO likes (article_id, comment_id, user_id)
SELECT IF(id % 2 = 0, CHAR_LENGTH(username), NULL),
IF(id % 2 != 0, CHAR_LENGTH(email), NULL),
id
FROM users
WHERE id BETWEEN 16 AND 20;

#3
UPDATE comments
SET `comment` = 
(CASE
	WHEN id % 2 = 0 THEN 'Very good article.'
	WHEN id % 3 = 0 THEN 'This is interesting.'
	WHEN id % 5 = 0 THEN 'I definitely will read the article again.'
	WHEN id % 7 = 0 THEN 'The universe is such an amazing thing.'
    ELSE 'comment' 
    END
)
WHERE id BETWEEN 1 AND 15; 

#4
DELETE FROM articles
WHERE category_id IS NULL;

#5
SELECT art.title, art.summary 
FROM 
(
	SELECT a.id, a.title, CONCAT(SUBSTRING(content, 1, 20), '...') AS summary
	FROM articles AS a
	ORDER BY CHAR_LENGTH(content) DESC
	LIMIT 3
) AS art
ORDER BY art.id;

#6
SELECT ua.article_id, a.title
FROM articles AS a
JOIN users_articles AS ua
ON a.id = ua.article_id
WHERE ua.article_id = ua.user_id;

#7
SELECT c.category, COUNT(DISTINCT a.id) AS articles, COUNT(l.id) AS likes
FROM categories AS c
LEFT JOIN articles AS a
ON a.category_id = c.id
LEFT JOIN likes AS l
ON l.article_id = a.id
GROUP BY c.id
ORDER BY likes DESC, articles DESC, c.id;

#8
SELECT a.title, COUNT(c.id) AS comments
FROM categories AS ca
JOIN articles AS a
ON a.category_id = ca.id
JOIN comments AS c
ON c.article_id = a.id
WHERE ca.id = 5
GROUP BY a.title
ORDER BY comments DESC
LIMIT 1;

#9
SELECT CONCAT(LEFT(c.`comment`, 20), '...') AS summary
FROM comments AS c
LEFT JOIN likes AS l
ON l.comment_id = c.id
WHERE l.comment_id IS NULL
ORDER BY c.id DESC;

#10
DELIMITER $$
CREATE FUNCTION udf_users_articles_count(given_username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(ua.user_id)
FROM users AS u
JOIN users_articles AS ua
ON ua.user_id = u.id
WHERE u.username = given_username);
END $$
DELIMITER ;

SELECT u.username, udf_users_articles_count('UnderSinduxrein')
AS count
FROM articles AS a
JOIN users_articles ua
ON a.id = ua.article_id
JOIN users u
ON ua.user_id = u.id
WHERE u.username = 'UnderSinduxrein'
GROUP BY u.id;

#11
DELIMITER $$
CREATE PROCEDURE udp_like_article(given_username VARCHAR(30), given_title VARCHAR(30)) 
BEGIN 
START TRANSACTION;
	IF (SELECT COUNT(*) FROM users WHERE username = given_username) = 0 
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent user.';
	ROLLBACK;

	ELSEIF (SELECT COUNT(*) FROM articles WHERE title = given_title) = 0 
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent article.';
	ROLLBACK;
ELSE
INSERT INTO likes (article_id, user_id)
SELECT
(SELECT u.id FROM users AS u WHERE u.username = given_username),
(SELECT a.id FROM articles AS a WHERE a.title = given_title);
END IF;
END $$
DELIMITER ;

CALL udp_like_article('Pesho123', 'Donnybrook, Victoria');
CALL udp_like_article('BlaAntigadsa', 'Na Pesho statiqta');

CALL udp_like_article('BlaAntigadsa', 'Donnybrook, Victoria');
SELECT a.title, u.username
FROM articles a
JOIN likes l
ON a.id = l.article_id
JOIN users u
ON l.user_id = u.id
WHERE u.username = 'BlaAntigadsa' AND a.title = 'Donnybrook, Victoria';


