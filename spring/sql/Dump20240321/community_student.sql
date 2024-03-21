CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_number` int NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `korean_score` int NOT NULL,
  `english_score` int NOT NULL,
  `math_score` int NOT NULL,
  PRIMARY KEY (`student_number`),
  UNIQUE KEY `student_number_UNIQUE` (`student_number`)
);
