CREATE TABLE `citizens` (
	`citizen_id` BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
	`citizen_name` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`zip` CHAR(4) NOT NULL COLLATE 'utf8_hungarian_ci',
	`age` BIGINT(3) UNSIGNED NOT NULL,
	`email` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`taj` VARCHAR(10) NOT NULL COLLATE 'utf8_hungarian_ci',
	`number_of_vaccination` BIGINT(1) UNSIGNED NULL DEFAULT '0',
	`last_vaccination` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`citizen_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci';
