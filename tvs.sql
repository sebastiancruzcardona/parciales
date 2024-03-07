-- Adminer 4.8.1 MySQL 8.3.0 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `tvs`;
CREATE TABLE `tvs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(20) NOT NULL,
  `screen_size` float NOT NULL,
  `weight` float NOT NULL,
  `technology` varchar(20) NOT NULL,
  `operative_system` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tvs` (`id`, `manufacturer`, `screen_size`, `weight`, `technology`, `operative_system`) VALUES
(1,	'Samsung',	42,	17.5,	'Qled',	'Tizen Os');

-- 2024-03-07 02:26:53
