#1
INSERT INTO travel_cards (card_number, job_during_journey, colonist_id, journey_id)
SELECT IF(birth_date >= '1980-01-01', CONCAT(YEAR(birth_date), DAY(birth_date), LEFT(ucn, 4)), CONCAT(YEAR(birth_date), MONTH(birth_date), RIGHT(ucn, 4))),
(CASE 
	WHEN c.id % 2 = 0 THEN 'Pilot'
	WHEN c.id %3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END),
c.id,
LEFT(ucn, 1)
FROM colonists AS c
WHERE c.id BETWEEN 96 AND 100;

#2
UPDATE journeys
SET purpose = (CASE
WHEN id % 2 = 0 THEN 'Medical'
WHEN id % 3 = 0 THEN 'Technical'
WHEN id % 5 = 0 THEN 'Educational'
WHEN id % 7 = 0 THEN 'Military'
ELSE purpose
END);

#3
DELETE FROM colonists AS c
WHERE c.id NOT IN(SELECT colonist_id FROM travel_cards);

#4
SELECT card_number, job_during_journey FROM travel_cards
ORDER BY card_number;

#5
SELECT id, CONCAT(first_name, ' ', last_name) AS full_name, ucn
FROM colonists
ORDER BY first_name, last_name, id;

#6
SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

#7
SELECT c.id, CONCAT(first_name, ' ', last_name) AS full_name
FROM colonists AS c
JOIN travel_cards AS tc
ON tc.colonist_id = c.id
WHERE job_during_journey = 'Pilot'
ORDER BY c.id;

#8
SELECT COUNT(c.id) AS `count`
FROM colonists AS c
JOIN travel_cards AS tc
ON tc.colonist_id = c.id
JOIN journeys AS j
ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';

#9
SELECT ss.`name` AS spaceship_name,
sp.`name` AS spaceport_name
FROM spaceships AS ss
JOIN journeys AS j
ON j.spaceship_id = ss.id
JOIN spaceports AS sp
ON j.destination_spaceport_id = sp.id
ORDER BY ss.light_speed_rate DESC
LIMIT 1;

#10
SELECT ss.`name`, manufacturer
FROM spaceships AS ss
JOIN journeys AS j
ON j.spaceship_id = ss.id
JOIN travel_cards AS tc
ON tc.journey_id = j.id
JOIN colonists AS c
ON tc.colonist_id = c.id
WHERE TIMESTAMPDIFF(YEAR, birth_date, '2019-01-01') < 30
AND job_during_journey = 'Pilot'
GROUP BY ss.id
ORDER BY ss.`name`;

SELECT TIMESTAMPDIFF(YEAR, birth_date, '2019-01-01') AS oldest
FROM spaceships AS ss
JOIN journeys AS j
ON j.spaceship_id = ss.id
JOIN travel_cards AS tc
ON tc.journey_id = j.id
JOIN colonists AS c
ON tc.colonist_id = c.id
WHERE ss.id = 15
ORDER BY oldest DESC;

#11
SELECT p.`name` AS planet_name,
s.`name` AS spaceport_name
FROM planets AS p
JOIN spaceports AS s
ON s.planet_id = p.id
JOIN journeys AS j
ON j.destination_spaceport_id = s.id
WHERE purpose = 'Educational'
ORDER BY s.`name` DESC;

#12
SELECT p.`name` AS planet_name,
COUNT(j.id) AS journeys_count
FROM planets AS p
LEFT JOIN spaceports AS s
ON s.planet_id = p.id
LEFT JOIN journeys AS j
ON j.destination_spaceport_id = s.id
GROUP BY p.id
ORDER BY journeys_count DESC, p.`name`;

#13
SELECT j.id, p.`name`AS planet_name,
s.`name` AS spaceport_name,
purpose AS journey_purpose
FROM planets AS p
JOIN spaceports AS s
ON s.planet_id = p.id
JOIN journeys AS j
ON j.destination_spaceport_id = s.id
ORDER BY TIMESTAMPDIFF(DAY, journey_start, journey_end)
LIMIT 1;

#14
SELECT job_during_journey AS job_name
FROM colonists AS c
JOIN travel_cards AS tc
ON tc.colonist_id = c.id
JOIN journeys AS j 
ON tc.journey_id = j.id
GROUP BY j.id, job_during_journey
ORDER BY TIMESTAMPDIFF(DAY, journey_start, journey_end) DESC,
COUNT(job_during_journey)
LIMIT 1;

#15
DELIMITER $$
CREATE FUNCTION  udf_count_colonists_by_destination_planet (planet_name VARCHAR (30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(c.id)
FROM planets AS p
LEFT JOIN spaceports AS s
ON s.planet_id = p.id
LEFT JOIN journeys AS j
ON j.destination_spaceport_id = s.id
LEFT JOIN travel_cards AS tc
ON tc.journey_id = j.id
LEFT JOIN colonists AS c
ON tc.colonist_id = c.id
WHERE p.`name` = planet_name
GROUP BY p.id);
END $$
DELIMITER ;

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';

#16
DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT)
BEGIN
START TRANSACTION;
IF spaceship_name NOT IN (SELECT `name` FROM spaceships)
THEN
	SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
ROLLBACK;
	ELSE
    UPDATE spaceships
    SET light_speed_rate = light_speed_rate + light_speed_rate_increse
    WHERE `name` = spaceship_name;	
END IF;
END $$
DELIMITER ;

CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'Na Pesho koraba';

CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar';

