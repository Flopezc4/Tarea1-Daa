CREATE DATABASE  IF NOT EXISTS `inventario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `inventario`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inventario` (
  `Nom_Producto` varchar(45) NOT NULL,
  `Codigo_Producto` int(11) DEFAULT NULL,
  `Tipo_Producto` varchar(45) DEFAULT NULL,
  `Valor_Producto` int(11) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`Nom_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES ('Arroz',104,'Abarrotes',890,10),('BigTime',104,'Abarrotes',300,32),('Centella',101,'Helados',200,15),('Chocolito',102,'Helados',590,33),('Chomp',102,'Helados',1900,35),('Chubi',104,'Helados',200,40),('CocaCola 1Lt.',102,'Bebestibles',1100,25),('CocaCola 2Lt.',101,'Bebestibles',1590,23),('CocaCola 3Lt.',101,'Bebestibles',1900,25),('ColaTigre',102,'Helados',350,22),('Crocanty',102,'Helados',600,18),('Danky',102,'Helados',1390,40),('Egocentrico',102,'Helados',690,15),('Fanta 1Lt.',101,'Bebestibles',1900,22),('Fanta 2Lt.',101,'Bebestibles',1490,25),('Fanta 3Lt.',101,'Bebestibles',1900,30),('Fideos',104,'Abarrotes',690,12),('Kriko',102,'Helados',590,20),('Monster',101,'Bebestibles',1890,33),('Puré',104,'Abarrotes',700,10),('Sal',104,'Abarrotes',790,12),('Sprite 1Lt.',101,'Bebestibles',1200,24),('Sprite 2Lt.',101,'Bebestibles',1590,21),('Sprite 3Lt.',101,'Bebestibles',1900,12),('Trululu',102,'Helados',350,20),('Tucu',102,'Helados',250,45),('Yiro',102,'Helados',200,60);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-02 21:20:48
