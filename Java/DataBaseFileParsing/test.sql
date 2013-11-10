-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 29, 2013 at 06:10 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `ORDER_ID` int(32) NOT NULL,
  `ORDER_NO` int(32) NOT NULL,
  `PERSON_ID` int(32) NOT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`ORDER_ID`, `ORDER_NO`, `PERSON_ID`) VALUES
(10, 2000, 1),
(11, 2001, 2),
(12, 2002, 1),
(13, 2003, 10);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `PERSON_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(32) NOT NULL,
  `LAST_NAME` varchar(32) NOT NULL,
  `STREET` varchar(32) NOT NULL,
  `CITY` varchar(32) NOT NULL,
  PRIMARY KEY (`PERSON_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PERSON_ID`, `FIRST_NAME`, `LAST_NAME`, `STREET`, `CITY`) VALUES
(1, 'Ola', 'Hansen', 'Timoteivn', 'Sandnes'),
(2, 'Tove', 'Svendson', 'Borgvn', 'Stavanger'),
(3, 'Kari', 'Pettersen', 'Storgt', 'Stavanger');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
