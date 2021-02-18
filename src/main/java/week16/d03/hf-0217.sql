--Listázd ki az összes vásárlót név szerint csökkenősorrendben!
SELECT * FROM `customers` WHERE 1 ORDER BY `customer_name` DESC;
--Listázd ki az összes vásárlót, de csak a nevüket, az azonosítójuk nem kell.
SELECT `customer_name` FROM `customers` WHERE 1;
--Listázd ki a pizzákat áruk szerint emelkedősorrendben!
SELECT * FROM `pizza` WHERE 1 order BY `pizza_price` ASC;
--Listázd ki a legdrágább pizzát!
SELECT * FROM `pizza` ORDER BY `pizza_price` DESC LIMIT 1;
--vagy
SELECT * FROM `pizza` WHERE `pizza_price` = (SELECT MAX(`pizza_price`) FROM `pizza`);
--Átlagosan mekkora értékben rendeltek az emberek?
SELECT AVG(`pizza_price`) AS 'Átlag pizzaár' FROM `pizza` INNER JOIN `order` ON `order`.`pizza_id` = `pizza`.`pizza_id`;
--Számold meg, mennyi vásárló van, akinek a nevében van ’a’ betű!
SELECT * FROM `customers` WHERE `customer_name` LIKE '%a%';
--Listázd ki azokat a pizzákat, amik 1000 forintnál drágábbak vagy van a nevükben ’a’ betű.
SELECT * FROM `pizza` WHERE `pizza_price` > 1000 OR `pizza_name` LIKE '%a%';
--Listázd ki az emberek neveit, akik pizzát rendeltek, és azt, hogy mikor rendelték a pizzát.
SELECT `customers`.`customer_name` AS 'Vevő', `order`.`order_date` AS 'Dátum' FROM `order` LEFT JOIN `customers` ON `customers`.`customer_id` = `order`.`customer_id`;
--Listázd ki a pizzarendelések dátumát és azt, hogy melyik dátumon milyen nevűpizzát rendeltek!
SELECT `order`.`order_date` AS 'Dátum', `pizza`.`pizza_name` AS 'Pizza neve' FROM `order` INNER JOIN `pizza` ON `order`.`pizza_id` = `pizza`.`pizza_id`;