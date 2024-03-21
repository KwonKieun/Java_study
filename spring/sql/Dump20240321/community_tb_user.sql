CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `USER_NO` int NOT NULL,
  `USER_ID` varchar(50) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `USER_AGE` int NOT NULL,
  PRIMARY KEY (`USER_NO`),
  UNIQUE KEY `USER_ID` (`USER_ID`)
);
