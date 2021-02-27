CREATE TABLE `activities` (
	`id` INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	`start_time` DATETIME NULL DEFAULT NULL,
	`activity_desc` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`activity_type` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_hungarian_ci';
