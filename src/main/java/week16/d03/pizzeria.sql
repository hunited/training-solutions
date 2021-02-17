-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Szerver verzió:               10.5.8-MariaDB-1:10.5.8+maria~focal - mariadb.org binary distribution
-- Szerver OS:                   debian-linux-gnu
-- HeidiSQL Verzió:              11.2.0.6228
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Adatbázis struktúra mentése a pizzeria.
DROP DATABASE IF EXISTS `pizzeria`;
CREATE DATABASE IF NOT EXISTS `pizzeria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizzeria`;

-- Struktúra mentése tábla pizzeria. customers
DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Tábla adatainak mentése pizzeria.customers: ~0 rows (hozzávetőleg)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`customer_id`, `customer_name`) VALUES
	(1, 'Sanyi'),
	(2, 'Peti'),
	(3, 'Gizi'),
	(4, 'Juli'),
	(5, 'Mari'),
	(6, 'Tibi'),
	(7, 'Anita'),
	(8, 'Feri'),
	(9, 'Dani'),
	(10, 'Kati');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Struktúra mentése tábla pizzeria. order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned NOT NULL,
  `pizza_id` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `pizza_id` (`pizza_id`),
  CONSTRAINT `customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `pizza` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`pizza_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Tábla adatainak mentése pizzeria.order: ~0 rows (hozzávetőleg)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`order_id`, `customer_id`, `pizza_id`, `order_date`) VALUES
	(1, 1, 2, '2021-02-14'),
	(2, 7, 4, '2021-02-15'),
	(3, 5, 10, '2021-02-15'),
	(4, 8, 5, '2021-02-15'),
	(5, 10, 3, '2021-02-16'),
	(6, 2, 8, '2021-02-16'),
	(7, 4, 1, '2021-02-17'),
	(8, 6, 7, '2021-02-17'),
	(9, 3, 9, '2021-02-17'),
	(10, 9, 6, '2021-02-17');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Struktúra mentése tábla pizzeria. pizza
DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `pizza_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pizza_name` varchar(100) NOT NULL,
  `pizza_price` float NOT NULL,
  PRIMARY KEY (`pizza_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Tábla adatainak mentése pizzeria.pizza: ~0 rows (hozzávetőleg)
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES
	(1, 'Margarita', 800),
	(2, 'Húsimádó', 2000),
	(3, 'Négy sajtos', 1600),
	(4, 'Giroszos', 1800),
	(5, 'Magyaros', 1650),
	(6, 'Virslis', 1000),
	(7, 'Sonkás', 1100),
	(8, 'Gombás', 1000),
	(9, 'Sonkás-gombás', 1300),
	(10, 'Vega', 1600);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
