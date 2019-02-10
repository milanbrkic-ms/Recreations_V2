/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 5.7.21-log : Database - recreations
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`recreations` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `recreations`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `ptt` int(6) NOT NULL,
  `nazivMesta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`ptt`,`nazivMesta`) values 
(11000,'Beograd'),
(11070,'Novi Beograd'),
(11080,'Zemun'),
(11271,'Surcin'),
(16000,'Leskovac'),
(17500,'Vranje'),
(21000,'Novi Sad'),
(37000,'Krusevac');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `clanID` int(11) NOT NULL AUTO_INCREMENT,
  `imeRoditelja` varchar(50) DEFAULT NULL,
  `godinaUpisa` int(4) DEFAULT NULL,
  `idOsoba` varchar (50) DEFAULT NULL,
  KEY `idOsoba` (`idOsoba`),
  KEY `clanID` (`clanID`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`idOsoba`) REFERENCES `person` (`idOsoba`)
) ENGINE=InnoDB AUTO_INCREMENT=1100 DEFAULT CHARSET=latin1;

/*Data for the table `member` */

insert  into `member`(`clanID`,`imeRoditelja`,`godinaUpisa`,`idOsoba`) values 
(1003,'Zdravko',2017,'1050'),
(1004,'Tomislav',2017,NULL),
(1005,'Dragan',2017,'1002'),
(1006,'Dragan',2017,'1001'),
(1028,'Zorica',2014,'1005'),
(1029,'Zorica',2017,'1007'),
(1030,'Marija',2016,'1006'),
(1031,'Bane',2015,'1003'),
(1033,'Dragan',2016,'1004'),
(1035,'Marko',2016,NULL),
(1049,'Mirko',2015,'1055'),
(1050,NULL,0,1056),
(1051,NULL,0,1057),
(1052,NULL,0,1058),
(1053,NULL,0,1059),
(1054,NULL,0,1060),
(1055,NULL,0,1061),
(1056,NULL,0,1062),
(1057,NULL,0,1063),
(1058,NULL,0,1064),
(1059,NULL,0,1065),
(1060,NULL,0,1066);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `tip` char(5) DEFAULT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `pol` char(1) DEFAULT NULL,
  `idOsoba` varchar (50) NOT NULL,
  `mesto` int(11) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `stamina` double DEFAULT NULL,
  PRIMARY KEY (`idOsoba`),
  KEY `mesto` (`mesto`)
) ENGINE=InnoDB AUTO_INCREMENT=1106 DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`tip`,`ime`,`prezime`,`datumRodjenja`,`pol`,`idOsoba`,`mesto`,`rating`,`height`,`weight`,`stamina`) values 
('T','Zarko','Koprivica','1985-02-25','M','1',21000,0,0,0,0),
('T','Marina','Jovanovic','1981-06-22','Z','2',37000,0,0,0,0),
('T','Dusan','Savic','1978-09-12','M','3',37000,0,0,0,0),
('T','Jelisaveta','Krstic','1991-01-15','Z','4',11080,0,0,0,0),
('N/A','Milan','Brkic','2018-02-05','M','5',11070,0,0,0,0),
('C','Milena','Brkic','1994-08-07','Z','1001',11070,0,0,0,0),
('C','Nina','Stevic','1994-05-19','Z','1002',11070,0,0,0,0),
('C','Marko','Banduka','1994-07-27','M','1003',11070,0,0,0,0),
('C','Stefan ','Krstic','1993-08-25','M','1004',11070,0,0,0,0),
('C','Marko ','Arandjelovic','1994-02-01','M','1005',11271,0,0,0,0),
('C','Nemanja','Slavic','1994-09-28','M','1006',11271,0,0,0,0),
('C','Nikola','Dimic','1993-09-15','M','1007',17500,0,0,0,0),
('C','Milan','Milan','2010-02-17','M','1050',11000,0,0,0,0),
('C','ime2','prezime2','1994-05-21','M','1055',11000,0,0,0,0),
('C','clan_ime0','clan_prezime0','1984-06-13','M','1056',11000,0,0,0,0),
('C','clan_ime1','clan_prezime1','1995-06-07','M','1057',11000,0,0,0,0),
('C','clan_ime2','clan_prezime2','1989-02-28','M','1058',11000,0,0,0,0),
('C','clan_ime3','clan_prezime3','2013-08-11','M','1059',11000,0,0,0,0),
('C','clan_ime4','clan_prezime4','1982-11-18','M','1060',11000,0,0,0,0),
('C','clan_ime5','clan_prezime5','1972-05-16','M','1061',11000,0,0,0,0),
('C','clan_ime6','clan_prezime6','1997-01-09','M','1062',11000,0,0,0,0),
('C','clan_ime7','clan_prezime7','1978-11-16','M','1063',11000,0,0,0,0),
('C','clan_ime8','clan_prezime8','1992-03-14','M','1064',11000,0,0,0,0),
('C','clan_ime9','clan_prezime9','1972-06-25','M','1065',11000,0,0,0,0),
('C','clan_ime10','clan_prezime10','2013-04-16','M','1066',11000,0,0,0,0);

/*Table structure for table `relationship` */

DROP TABLE IF EXISTS `relationship`;

CREATE TABLE `relationship` (
  `osoba_1_id` VARCHAR (50) NOT NULL,
  `osoba_2_id` VARCHAR(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `akcija_osoba_id` VARCHAR(11) DEFAULT NULL,
  PRIMARY KEY (`osoba_1_id`,`osoba_2_id`),
  KEY `osoba_2_id` (`osoba_2_id`),
  KEY `akcija_osoba_id` (`akcija_osoba_id`),
  CONSTRAINT `relationship_ibfk_1` FOREIGN KEY (`osoba_1_id`) REFERENCES `person` (`idOsoba`),
  CONSTRAINT `relationship_ibfk_2` FOREIGN KEY (`osoba_2_id`) REFERENCES `person` (`idOsoba`),
  CONSTRAINT `relationship_ibfk_3` FOREIGN KEY (`akcija_osoba_id`) REFERENCES `person` (`idOsoba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `relationship` */

insert  into `relationship`(`osoba_1_id`,`osoba_2_id`,`status`,`akcija_osoba_id`) values 
(1001,1002,1,NULL),
(1001,1003,1,NULL);

/*Table structure for table `sport` */

DROP TABLE IF EXISTS `sport`;

CREATE TABLE `sport` (
  `sportID` int(11) NOT NULL,
  `nazivSporta` varchar(20) DEFAULT NULL,
  `maxBrClanova` int(11) DEFAULT NULL,
  PRIMARY KEY (`sportID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sport` */

insert  into `sport`(`sportID`,`nazivSporta`,`maxBrClanova`) values 
(1,'Kosarka',20),
(2,'Mali fudbal',25),
(3,'Odbojka',22),
(4,'Rukomet',30),
(5,'Fudbal',40),
(6,'Stoni tenis',4);

/*Table structure for table `tclan` */

DROP TABLE IF EXISTS `tclan`;

CREATE TABLE `tclan` (
  `clanId` VARCHAR(50) NOT NULL,
  `treningId` int(11) NOT NULL,
  PRIMARY KEY (`clanId`,`treningId`),
  KEY `tclan_ibfk_3` (`treningId`),
  CONSTRAINT `tclan_ibfk_3` FOREIGN KEY (`treningId`) REFERENCES `training` (`treningId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tclan_ibfk_4` FOREIGN KEY (`clanId`) REFERENCES `member` (`idOsoba`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tclan` */

insert  into `tclan`(`clanId`,`treningId`) values 
('1006',1),
('1001',4),
('1003',4),
('1004',4),
('1006',4),
('1001',5),
('1002',7);

/*Table structure for table `trainer` */

DROP TABLE IF EXISTS `trainer`;

CREATE TABLE `trainer` (
  `idOsoba` VARCHAR(11) DEFAULT NULL,
  `trenerID` int(11) DEFAULT NULL,
  `godineRada` int(11) DEFAULT NULL,
  `kratakCV` varchar(1000) DEFAULT NULL,
  `sportID` int(11) DEFAULT NULL,
  KEY `sportID` (`sportID`),
  KEY `idOsoba` (`idOsoba`),
  CONSTRAINT `trainer_ibfk_1` FOREIGN KEY (`sportID`) REFERENCES `sport` (`sportID`) ON UPDATE CASCADE,
  CONSTRAINT `trainer_ibfk_2` FOREIGN KEY (`idOsoba`) REFERENCES `person` (`idOsoba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `trainer` */

insert  into `trainer`(`idOsoba`,`trenerID`,`godineRada`,`kratakCV`,`sportID`) values 
('1',201,4,'Zavrsio dif sa prosecnom ocenom 9. Radio 2 godine u Italiji za klub OKS.',3),
('2',202,5,'Isla sam u Francusku....',1),
('3',204,8,'Zavrsio DIF u Beogradu sa prosecnom ocenom 8,9. Tokom studiranja radio sam kao pomocni trener u FK Borcanac i tako stekao dosta iskustva. Nakon zavrsetka fakulteta radio sam kao trener poletarcima u osnovnoj skoli Branko Radicevic.\n',1),
('4',205,4,'Zavrsio DIF u Beogradu sa prosecnom ocenom 8,9. Tokom studiranja radio sam kao pomocni trener u FK Borcanac i tako stekao dosta iskustva. Nakon zavrsetka fakulteta radio sam kao trener poletarcima u osnovnoj skoli Branko Radicevic.\n',3);

/*Table structure for table `training` */

DROP TABLE IF EXISTS `training`;

CREATE TABLE `training` (
  `treningId` int(11) NOT NULL AUTO_INCREMENT,
  `vremeOd` time NOT NULL,
  `vremeDo` time NOT NULL,
  `datum` date NOT NULL,
  `sport` int(11) DEFAULT NULL,
  `nazivTreninga` varchar(50) default null,
  PRIMARY KEY (`treningId`),
  KEY `sport` (`sport`),
  CONSTRAINT `training_ibfk_1` FOREIGN KEY (`sport`) REFERENCES `sport` (`sportID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `training` */

insert  into `training`(`treningId`,`vremeOd`,`vremeDo`,`datum`,`sport`) values 
(1,'11:00:00','12:00:00','2017-06-26',3),
(2,'15:00:00','16:30:00','2017-06-26',3),
(3,'11:30:00','13:00:00','2017-06-27',2),
(4,'14:00:00','15:00:00','2017-06-27',5),
(5,'20:00:00','21:00:00','2017-06-27',1),
(7,'10:00:00','11:00:00','2017-06-28',1);

/*Table structure for table `tt` */

DROP TABLE IF EXISTS `tt`;

CREATE TABLE `tt` (
  `trenerId` VARCHAR(50) NOT NULL,
  `treningId` int(11) NOT NULL,
  PRIMARY KEY (`trenerId`,`treningId`),
  KEY `tt_ibfk_4` (`treningId`),
  CONSTRAINT `tt_ibfk_3` FOREIGN KEY (`trenerId`) REFERENCES `trainer` (`idOsoba`) ON DELETE CASCADE,
  CONSTRAINT `tt_ibfk_4` FOREIGN KEY (`treningId`) REFERENCES `training` (`treningId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tt` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `osoba` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `osoba` (`osoba`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`osoba`) REFERENCES `person` (`idOsoba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`osoba`) values 
('1111','63ed116de8eebf05ad5705daed353781daa51224aa8f36e02acfac76c6cdd444','1001'),
('2222','ec4e5c7c0a1a3895674b3f9f65923437cd28a6b8a9b63d8444da0152801eaa18','1'),
('k1','66f2cbf2c8f3188ae85ccc3d6bdac1fd05bc7f03f2bf066325e6211d20d6bd5b','1057'),
('k10','7dc5964952f32de0be2bbaf366d5dbef0b6de89e19c4954e95dd5b2a13c9c21a','1066'),
('k2','cd9edc37c3187e1f7c23987bd35616d7c068f4a60c4abddc2d0b84fe8ab3de89','1058'),
('k3','d9db0a2dcd0274da38d43ed96caa8d33d8dc93b95647ce6a8a3f0a4c2575e55b','1059'),
('k4','e08425b9625b5af44d508f81f4aaddd8d3e19435967abcc6b2f3d9fd63d76363','1060'),
('k5','159ec864fe3d92c144d4e6f5fe7304f3a50f244ff8550a6d1a37ea5d3c052145','1061'),
('k6','cae0fd8b045f86d64bc31b7f776e8a87fd03444c7417b02fec0375ec867219ea','1062'),
('k7','00acccb0fae58af9d020f4cc212581b3debb723f109d65052cb0fb72438d1a94','1063'),
('k8','ad92f08ef4556eaafaf89532bd4d6a3acc394f388981f2ccaf40b8884166022a','1064'),
('k9','9bc26f746f0ff27e02818af270c4bd69bfeb26d67ef9f3bb9425cb9611bddd50','1065'),
('milan@yahoo.com','eeb9bb390f1a97e53f21be06110582faa6925a04fc33cfa7c15d8dd37a3d82d7','1050');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
