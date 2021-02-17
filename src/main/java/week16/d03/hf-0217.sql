SELECT * FROM `customers` WHERE 1 ORDER BY `customer_name` DESC;
SELECT `customer_name` FROM `customers` WHERE 1;
SELECT * FROM `pizza` WHERE 1 order BY `pizza_price` ASC;
SELECT *, MAX(`pizza_price`) FROM `pizza`;
SELECT AVG(`pizza_price`) AS 'Átlag pizzaár' FROM `pizza` INNER JOIN `order` ON `order`.`pizza_id` = `pizza`.`pizza_id`;
SELECT * FROM `customers` WHERE `customer_name` LIKE '%a%';
SELECT * FROM `pizza` WHERE `pizza_price` > 1000 OR `pizza_name` LIKE '%a%';
SELECT `customers`.`customer_name` AS 'Vevő', `order`.`order_date` AS 'Dátum' FROM `order` INNER JOIN `customers` ON `customers`.`customer_id` = `order`.`customer_id`;
SELECT `order`.`order_date` AS 'Dátum', `pizza`.`pizza_name` AS 'Pizza neve' FROM `order` INNER JOIN `pizza` ON `order`.`pizza_id` = `pizza`.`pizza_id`;