CREATE DATABASE  IF NOT EXISTS `sistemalocalizacao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemalocalizacao`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemalocalizacao
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `pontos`
--

DROP TABLE IF EXISTS `pontos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pontos` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `coordX` double NOT NULL,
  `coordY` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pontos`
--

LOCK TABLES `pontos` WRITE;
/*!40000 ALTER TABLE `pontos` DISABLE KEYS */;
INSERT INTO `pontos` VALUES (2,'EXTRA','SUPERMERCADO GASOLINA BARATA','supermercado',2,2),(3,'KSDSND','SDSDSD','escola',2,2),(4,'SDJBSD','DSDSDS','escola',3,3),(6,'ARTHUR RAMOS','QUALQUER COISA','hospital',5,5),(7,'OUTBACK','DSKDKS','restaurante',3,3),(8,'SDNSKD','DSDS','escola',2,3),(9,'SDSD','DSDS','ESCOLA',2,2),(10,'DSKDN','SDDKSNDKS','ESCOLA',4,4),(13,'BDSKD','SDKNSD','restaurante',4,4),(14,'SDBSKDN','DSKNDKSND','ESCOLA',5,6),(15,'ALGUM LUGAR','SDSKND','RESTAURANTE',4,5),(16,'SAKNDKA','FNDFD','HOSPITAL',5,4),(17,'DKSND','FDKNNFDF','SUPERMERCADO',5,4),(18,'DSKDNSKD','DSKND','ESCOLA',4,3),(20,'DONDSD','DSODSND','RESTAURANTE',5,4),(21,'DSHDS','SHDS','SUPERMERCADO',4,3);
/*!40000 ALTER TABLE `pontos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `login` varchar(20) NOT NULL,
  `senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('AA','AA'),('adm','adm'),('ALO','ALO'),('BADU','BADU'),('EDUARDO','EDUARDO'),('GABRIEL','NUNES'),('JOAO','JOAO'),('NUNES','NUNES');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-16 20:21:41
