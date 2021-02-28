CREATE TABLE `vaccinations` (
	`vaccination_id` BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
	`citizen_id` BIGINT(8) UNSIGNED NOT NULL,
	`vaccination_date` DATETIME NOT NULL,
	`status` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`note` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`vaccination_type` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`vaccination_id`) USING BTREE,
	INDEX `citizen_vaccination` (`citizen_id`) USING BTREE,
	CONSTRAINT `citizen_vaccination` FOREIGN KEY (`citizen_id`) REFERENCES `covid`.`citizens` (`citizen_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_hungarian_ci';
