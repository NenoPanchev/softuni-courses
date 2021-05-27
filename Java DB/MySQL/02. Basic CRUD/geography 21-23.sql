#21
SELECT `p`.`peak_name` 
	FROM `peaks` AS `p`
	ORDER BY `p`.`peak_name`;
	
#22
SELECT `c`.`country_name`, `c`.`population` 
	FROM `countries` AS `c`
	WHERE `c`.`continent_code` = 'EU'
	ORDER BY 
		`c`.`population` DESC,
		`c`.`country_name`
	LIMIT 30;
	
#23
SELECT `country_name`, `country_code`,
IF(`currency_code` = 'EUR', 'Euro', 'Not Euro') AS `currency`
	FROM `countries`
    ORDER BY `country_name`;
	
	