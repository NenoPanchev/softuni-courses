DELIMITER $$
CREATE PROCEDURE usp_get_count_of_books_written_by_author(fname VARCHAR(30), lname VARCHAR(30))
BEGIN
SELECT COUNT(*) FROM authors AS a
JOIN books AS b ON b.author_id = a.id
WHERE a.first_name = fname AND a.last_name = lname;
END $$

DELIMITER ;