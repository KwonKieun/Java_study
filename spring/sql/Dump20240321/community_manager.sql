CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_number` int NOT NULL,
  `manager_name` varchar(20) NOT NULL,
  `manager_hire_date` char(10) NOT NULL,
  PRIMARY KEY (`manager_number`),
  UNIQUE KEY `manager_number_UNIQUE` (`manager_number`)
);
