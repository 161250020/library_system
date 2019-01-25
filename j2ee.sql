-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: j2ee
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publishCompany` varchar(100) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `fineMoneyPerDay` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('idbook1','booktype1','book1','authorbook1','publishcbook1','out',0.2),('idbook2','booktype2','book2','authorbook2','publishcbook2','out',0.3),('idbook3','booktype3','book3','authorbook3','publishcbook3','in',0.4),('idbook4','booktype4','book4','authorbook4','publishcbook4','in',0.6);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edituserinfoorder`
--

DROP TABLE IF EXISTS `edituserinfoorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edituserinfoorder` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `changeTime` date DEFAULT NULL,
  `prePass` varchar(100) DEFAULT NULL,
  `laterPass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edituserinfoorder`
--

LOCK TABLES `edituserinfoorder` WRITE;
/*!40000 ALTER TABLE `edituserinfoorder` DISABLE KEYS */;
INSERT INTO `edituserinfoorder` VALUES ('3214f25c-2c8e-42bb-9d5c-d3595b89744b','1','2019-01-24','123','456'),('561f2482-9849-4a16-a429-662b67313509','1','2019-01-24','456','789'),('7cf84104-9c23-4cde-ad76-c0d04b1023c9','1','2019-01-24','789','123'),('9f30c783-924b-45ca-a0e5-ed8467bf8fa0','1','2019-01-24','123','456');
/*!40000 ALTER TABLE `edituserinfoorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electronicbooks`
--

DROP TABLE IF EXISTS `electronicbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electronicbooks` (
  `id` varchar(100) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publishCompany` varchar(100) DEFAULT NULL,
  `documentFormat` varchar(100) DEFAULT NULL,
  `filepath` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electronicbooks`
--

LOCK TABLES `electronicbooks` WRITE;
/*!40000 ALTER TABLE `electronicbooks` DISABLE KEYS */;
INSERT INTO `electronicbooks` VALUES ('1','复习资料','linux系统基础重点','学长/学姐','南京大学软件学院','word','/jsps/readBook/ebooks/linux系统基础重点.docx'),('2','课表','软件学院本科生2018-2019-2课表','教务处','南京大学','pdf','/jsps/readBook/ebooks/软件学院本科生2018-2019-2课表.pdf'),('3','答案 ','Linux系统基础实验一答案 ','丁雯雯 ','南京大学软件学院 ','word','/jsps/readBook/ebooks/Linux系统基础实验一答案.doc '),('4','课表','大三上课表','教务处','南京大学','pdf','/jsps/readBook/ebooks/大三上课表.pdf');
/*!40000 ALTER TABLE `electronicbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lentbooklevel`
--

DROP TABLE IF EXISTS `lentbooklevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lentbooklevel` (
  `userType` varchar(100) NOT NULL,
  `maxNum` int(11) DEFAULT NULL,
  `maxPeriod` int(11) DEFAULT NULL,
  PRIMARY KEY (`userType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lentbooklevel`
--

LOCK TABLES `lentbooklevel` WRITE;
/*!40000 ALTER TABLE `lentbooklevel` DISABLE KEYS */;
INSERT INTO `lentbooklevel` VALUES ('postgraduate',20,120),('teacher',30,180),('undergraduate',10,60);
/*!40000 ALTER TABLE `lentbooklevel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onlinereadmodule`
--

DROP TABLE IF EXISTS `onlinereadmodule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `onlinereadmodule` (
  `id` varchar(100) NOT NULL,
  `documentFormat` varchar(100) DEFAULT NULL,
  `documentReader` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onlinereadmodule`
--

LOCK TABLES `onlinereadmodule` WRITE;
/*!40000 ALTER TABLE `onlinereadmodule` DISABLE KEYS */;
INSERT INTO `onlinereadmodule` VALUES ('1','word','word的在线阅读器'),('2','pdf','pdf的在线阅读器');
/*!40000 ALTER TABLE `onlinereadmodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `MaxNum` int(11) DEFAULT NULL,
  `MaxPeriod` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','hello','456','undergraduate',12,30,270);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorder`
--

DROP TABLE IF EXISTS `userorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userorder` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `bookId` varchar(100) DEFAULT NULL,
  `borrowTime` date DEFAULT NULL,
  `returnTime` date DEFAULT NULL,
  `fineDay` int(11) DEFAULT NULL,
  `alreadyPay` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorder`
--

LOCK TABLES `userorder` WRITE;
/*!40000 ALTER TABLE `userorder` DISABLE KEYS */;
INSERT INTO `userorder` VALUES ('1','1','idbook1','2018-01-12','1000-01-01',-1,-1),('2','1','idbook2','2018-01-13','1000-01-01',-1,-1),('3','1','idbook3','2018-11-01','2019-01-24',25,1),('4','1','idbook4','2018-11-01','2018-11-02',0,1);
/*!40000 ALTER TABLE `userorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-25 21:32:13
