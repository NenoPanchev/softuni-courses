#2
INSERT INTO coaches (first_name, last_name, salary, coach_level)
SELECT first_name, last_name, (p.salary * 2) AS salary, CHAR_LENGTH(first_name)
FROM players AS p
WHERE age >= 45;

#3
UPDATE coaches
SET coach_level = coach_level + 1
WHERE LEFT(first_name, 1) = 'A'
AND id IN (SELECT coach_id FROM players_coaches);

#4
DELETE FROM players
WHERE age >= 45;
SET SQL_SAFE_UPDATES = 0;

#5
SELECT first_name, age, salary
FROM players
ORDER BY salary DESC;

#6
SELECT p.id, CONCAT(p.first_name, ' ', p.last_name) AS full_name,
p.age, p.position, p.hire_date
FROM players AS p
LEFT JOIN skills_data AS sd
ON p.skills_data_id = sd.id
WHERE p.age < 23 AND p.position = 'A'
AND p.hire_date IS NULL
AND sd.strength > 50
ORDER BY p.salary, p.age;

#7
SELECT `name` AS team_name, established, fan_base,
COUNT(p.id) AS players_count
FROM teams AS t
LEFT JOIN players AS p
ON t.id = p.team_id
GROUP BY t.id
ORDER BY players_count DESC, fan_base DESC;

#8
SELECT MAX(sd.speed) AS max_speed, t.`name` AS town_name
FROM towns AS t
LEFT JOIN stadiums AS s
ON s.town_id = t.id
LEFT JOIN teams AS te
ON te.stadium_id = s.id
LEFT JOIN players AS p
ON p.team_id = te.id
LEFT JOIN skills_data AS sd
ON p.skills_data_id = sd.id
WHERE te.`name` != 'Devify'
GROUP BY town_name
ORDER BY max_speed DESC, town_name;

#9
SELECT c.`name`, COUNT(p.id) AS total_count_of_players,
SUM(p.salary) AS total_sum_of_salaries
FROM countries AS c
LEFT JOIN towns AS t
ON t.country_id = c.id
LEFT JOIN stadiums AS s
ON s.town_id = t.id
LEFT JOIN teams AS te
ON te.stadium_id = s.id
LEFT JOIN players AS p
ON p.team_id = te.id
GROUP BY c.id
ORDER BY total_count_of_players DESC, c.`name`;

#10
DELIMITER $$
CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.id)
FROM players AS p
JOIN teams AS t
ON p.team_id = t.id
JOIN stadiums AS s
ON t.stadium_id = s.id
WHERE s.`name` = stadium_name);
END $$
DELIMITER ;
SELECT udf_stadium_players_count ('Jaxworks') as `count`;
SELECT udf_stadium_players_count ('Linklinks') as `count`;

#11
DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	SELECT CONCAT(p.first_name, ' ', p.last_name) AS full_name, p.age, p.salary,
	sd.dribbling, sd.speed, t.`name` AS team_name
	FROM players AS p
	JOIN skills_data AS sd
	ON p.skills_data_id = sd.id
	JOIN teams AS t
	ON p.team_id = t.id
	WHERE sd.speed > min_dribble_points
	AND t.`name` = team_name
	AND sd.speed > (SELECT AVG(speed)
	FROM skills_data)
	ORDER BY sd.speed DESC
	LIMIT 1;
END $$
DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');
