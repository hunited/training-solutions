CREATE TABLE `cities` (
	`city_id` BIGINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	`order_id` INT(8) UNSIGNED NOT NULL,
	`shipment_date` DATE NOT NULL,
	PRIMARY KEY (`city_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci';
