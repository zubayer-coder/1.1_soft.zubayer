-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.73-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema inventorysystem
--

CREATE DATABASE IF NOT EXISTS inventorysystem;
USE inventorysystem;

--
-- Definition of table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) NOT NULL,
  `purchase_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` (`item_id`,`item_name`,`purchase_id`) VALUES 
 (1,'shirt',0),
 (2,'shirt',0),
 (3,'pant',0),
 (4,'shoes',0),
 (5,'muja',0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;


--
-- Definition of table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  `ord_number` varchar(45) NOT NULL,
  `ord_date` date NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `purchase_id` int(10) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `sell_price` int(10) unsigned NOT NULL,
  `total_price` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_orders_1` (`product_id`),
  KEY `FK_orders_2` (`purchase_id`),
  CONSTRAINT `FK_orders_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_orders_2` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_table`
--

/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` (`order_id`,`customer_name`,`phone_no`,`e_mail`,`ord_number`,`ord_date`,`product_name`,`product_id`,`purchase_id`,`quantity`,`sell_price`,`total_price`) VALUES 
 (4,'dedar','2332','dedar@gmail.com','11','2022-12-11','shoes',5,1,1,110,110),
 (5,'dedar','2332','dedar@gmail.com','11','2022-12-11','shoes',5,1,1,110,110);
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`,`product_name`) VALUES 
 (5,'Tshirt'),
 (6,'pant'),
 (7,'shoes');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchase_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `pPrice` varchar(45) NOT NULL,
  `totalPrice` varchar(45) NOT NULL,
  `pDate` datetime NOT NULL,
  `product_name` varchar(45) NOT NULL,
  PRIMARY KEY (`purchase_id`) USING BTREE,
  KEY `FK_puchase_1` (`product_id`),
  CONSTRAINT `FK_purchase_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`purchase_id`,`product_id`,`quantity`,`pPrice`,`totalPrice`,`pDate`,`product_name`) VALUES 
 (1,7,'1','100','100','2019-03-07 00:00:00','shoes'),
 (2,5,'3','100','300','2019-03-01 00:00:00','Tshirt');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `registation`
--

DROP TABLE IF EXISTS `registation`;
CREATE TABLE `registation` (
  `reg_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `uname` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`reg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registation`
--

/*!40000 ALTER TABLE `registation` DISABLE KEYS */;
INSERT INTO `registation` (`reg_id`,`name`,`fname`,`address`,`phone`,`mail`,`uname`,`pass`) VALUES 
 (1,'dedarul','aminul','dhaka','0172345','dedarul@gamil.com','dedar','123'),
 (3,'M Z Zubayer ','Sheikh Saheb','Sheikh Para,Jashore','01010101010','zubayer@gmail.com','zub','123'),
 (4,'m.mahfuj','m m  mujibur rahman','satkhira','0797','hfah@gamil.com','mahfuz','1234567890');
/*!40000 ALTER TABLE `registation` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
