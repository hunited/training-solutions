CREATE TABLE `track_point` (
	`id` INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	`activity_id` INT(5) UNSIGNED NOT NULL,
	`time` DATETIME NOT NULL,
	`lat` DECIMAL(10,7) NOT NULL,
	`lon` DECIMAL(10,7) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `activity_trackpoint` (`activity_id`) USING BTREE,
	CONSTRAINT `activity_trackpoint` FOREIGN KEY (`activity_id`) REFERENCES `activitytracker`.`activities` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_hungarian_ci';
