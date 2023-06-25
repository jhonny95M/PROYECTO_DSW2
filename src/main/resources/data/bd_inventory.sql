-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_inventory
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clase_movimiento`
--

DROP TABLE IF EXISTS `clase_movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clase_movimiento` (
  `id_clase` int NOT NULL,
  `nom_clase` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase_movimiento`
--

LOCK TABLES `clase_movimiento` WRITE;
/*!40000 ALTER TABLE `clase_movimiento` DISABLE KEYS */;
INSERT INTO `clase_movimiento` VALUES (1,'Ingreso'),(2,'Salida');
/*!40000 ALTER TABLE `clase_movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id` int NOT NULL,
  `nom_estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kardex`
--

DROP TABLE IF EXISTS `kardex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kardex` (
  `id_almacen` int NOT NULL,
  `id_clase` int NOT NULL,
  `item_vale` int NOT NULL,
  `id_vale` bigint NOT NULL,
  `id_tip_mov` int NOT NULL,
  `cantidad` double NOT NULL,
  `producto` bigint DEFAULT NULL,
  PRIMARY KEY (`id_almacen`,`id_clase`,`item_vale`,`id_vale`),
  KEY `FKj2idvbovyhaxsylanuuwsuoa5` (`producto`),
  KEY `FK65hmoa5k0ipstqkydhnhkb97h` (`id_almacen`,`id_clase`,`id_vale`),
  CONSTRAINT `FK65hmoa5k0ipstqkydhnhkb97h` FOREIGN KEY (`id_almacen`, `id_clase`, `id_vale`) REFERENCES `vale` (`id_almacen`, `id_clase`, `id_vale`),
  CONSTRAINT `FKj2idvbovyhaxsylanuuwsuoa5` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kardex`
--

LOCK TABLES `kardex` WRITE;
/*!40000 ALTER TABLE `kardex` DISABLE KEYS */;
INSERT INTO `kardex` VALUES (1,1,1,1,1,10,2),(1,1,1,2,1,10,2),(1,1,1,4,1,1,4),(1,1,1,13,1,10,4),(1,1,1,14,1,30,4),(1,1,1,15,1,30,4),(1,1,2,1,1,6,3),(1,1,2,2,1,6,3),(1,2,1,21,1,30,4),(1,2,1,22,1,40,4);
/*!40000 ALTER TABLE `kardex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento_kardex`
--

DROP TABLE IF EXISTS `movimiento_kardex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimiento_kardex` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `orden_compra_id` bigint DEFAULT NULL,
  `producto_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi0fqiqtoimwair7su7rtyvsuh` (`orden_compra_id`),
  KEY `FKiaqrn2kmmg4qeiulumowjstmh` (`producto_id`),
  CONSTRAINT `FKi0fqiqtoimwair7su7rtyvsuh` FOREIGN KEY (`orden_compra_id`) REFERENCES `orden_compra` (`id`),
  CONSTRAINT `FKiaqrn2kmmg4qeiulumowjstmh` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_kardex`
--

LOCK TABLES `movimiento_kardex` WRITE;
/*!40000 ALTER TABLE `movimiento_kardex` DISABLE KEYS */;
INSERT INTO `movimiento_kardex` VALUES (1,15,'2023-06-24 00:00:00','INGRESO DE ORDEN DE COMPRA',2,1),(2,2,'2023-06-24 00:00:00','INGRESO DE ORDEN DE COMPRA',5,1),(3,10,'2023-06-24 00:00:00','INGRESO DE ORDEN DE COMPRA',5,2),(4,10,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,2),(5,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3),(6,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3),(7,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3),(8,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3),(9,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3),(10,1,'2023-06-24 15:15:49','INGRESO DE ORDEN DE COMPRA',6,3);
/*!40000 ALTER TABLE `movimiento_kardex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_compra`
--

DROP TABLE IF EXISTS `orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_compra` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `proveedor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `FK4hot15yseux1nb8r801w3cdmd` (`proveedor_id`),
  CONSTRAINT `FK4hot15yseux1nb8r801w3cdmd` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra`
--

LOCK TABLES `orden_compra` WRITE;
/*!40000 ALTER TABLE `orden_compra` DISABLE KEYS */;
INSERT INTO `orden_compra` VALUES (2,'2023-06-24','OC-00001',6),(5,'2023-06-24','OC-00002',6),(6,'2023-06-24','OC-00003',6);
/*!40000 ALTER TABLE `orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stock` int NOT NULL,
  `unit_price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `unit_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,'MAQUINA DE COCER RECTA SIRUBA 2023',1955.9),(2,1,'MAQUINA DE COCER RECTA SIRUBA',1455.9),(3,1,'SAMSUNG S20 PRO MAX',1955.9),(4,1,'Tablet Samsun tab20',1456.89);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (6,'EMPRESA METAL MECANICA S.A.');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `producto_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1hx9o107cpb0o8hppaicd7af9` (`producto_id`),
  CONSTRAINT `FK1hx9o107cpb0o8hppaicd7af9` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (2,0,1),(3,20,2),(4,12,3),(5,1,4);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_movimiento`
--

DROP TABLE IF EXISTS `tipo_movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_movimiento` (
  `id_clase` int NOT NULL,
  `id_tip_mov` int NOT NULL,
  `nom_tip_mov` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_clase`,`id_tip_mov`),
  CONSTRAINT `FKpb6jrbmwahbsebmr5d4lcn1pw` FOREIGN KEY (`id_clase`) REFERENCES `clase_movimiento` (`id_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_movimiento`
--

LOCK TABLES `tipo_movimiento` WRITE;
/*!40000 ALTER TABLE `tipo_movimiento` DISABLE KEYS */;
INSERT INTO `tipo_movimiento` VALUES (1,1,'Compra Nacional'),(2,1,'Venta Nacional');
/*!40000 ALTER TABLE `tipo_movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'junmalpart@gmail.com','$2a$10$yU4pLFyqIwk95pnX8U9Slumdu/N8n1WuZPotARiVHM38w2RCKShei');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vale`
--

DROP TABLE IF EXISTS `vale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vale` (
  `id_vale` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `id_almacen` int NOT NULL,
  `id_clase` int NOT NULL,
  `id_estado` int NOT NULL,
  `id_tip_mov` int NOT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id_vale`),
  UNIQUE KEY `UK_p8h6xnkwr9cohlvvv2co65kdf` (`id_almacen`,`id_clase`,`id_vale`),
  KEY `FKm6ambparv28ym0a53w36mntgc` (`id_estado`),
  KEY `FK45f09rq8jb51rdmmx8i36ajwy` (`id_clase`,`id_tip_mov`),
  KEY `FKi6k0plyobnaldbc6ha15r7rf8` (`id_usuario`),
  CONSTRAINT `FK45f09rq8jb51rdmmx8i36ajwy` FOREIGN KEY (`id_clase`, `id_tip_mov`) REFERENCES `tipo_movimiento` (`id_clase`, `id_tip_mov`),
  CONSTRAINT `FKi6k0plyobnaldbc6ha15r7rf8` FOREIGN KEY (`id_usuario`) REFERENCES `user` (`id`),
  CONSTRAINT `FKm6ambparv28ym0a53w36mntgc` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vale`
--

LOCK TABLES `vale` WRITE;
/*!40000 ALTER TABLE `vale` DISABLE KEYS */;
INSERT INTO `vale` VALUES (1,'2023-06-24 21:43:17',1,1,1,1,1),(2,'2023-06-24 21:43:38',1,1,1,1,1),(4,'2023-06-24 21:52:29',1,1,1,1,1),(10,'2023-06-24 22:25:48',1,1,1,1,1),(11,'2023-06-24 22:37:01',1,1,1,1,1),(12,'2023-06-24 22:37:17',1,1,1,1,1),(13,'2023-06-24 22:37:34',1,1,1,1,1),(14,'2023-06-24 22:42:59',1,1,1,1,1),(15,'2023-06-24 22:44:27',1,1,1,1,1),(20,'2023-06-24 22:53:37',1,2,1,1,1),(21,'2023-06-24 22:54:53',1,2,1,1,1),(22,'2023-06-24 22:55:09',1,2,1,1,1),(23,'2023-06-24 22:55:17',1,2,1,1,1),(24,'2023-06-24 23:50:42',1,2,1,1,1);
/*!40000 ALTER TABLE `vale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-24 23:54:58
