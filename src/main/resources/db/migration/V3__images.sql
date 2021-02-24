CREATE TABLE `images` (
	`id` INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	`activity_id` INT(5) UNSIGNED NOT NULL,
	`filename` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`content` BLOB NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `activity_images` (`activity_id`) USING BTREE,
	CONSTRAINT `activity_images` FOREIGN KEY (`activity_id`) REFERENCES `activitytracker`.`activities` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_hungarian_ci';
