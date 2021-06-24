

SELECT @@session.time_zone;
SELECT TIMEDIFF(NOW(), UTC_TIMESTAMP);
SELECT @@global.time_zone;
SET GLOBAL time_zone = 'UTC';
SET @@global.time_zone='+00:00';