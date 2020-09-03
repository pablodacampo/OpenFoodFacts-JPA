CREATE DATABASE  IF NOT EXISTS `openfoodfacts` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `openfoodfacts`;

DROP TABLE IF EXISTS `composition_all`;
DROP TABLE IF EXISTS `composition_add`;
DROP TABLE IF EXISTS `composition_ing`;

DROP TABLE IF EXISTS `additif`;
DROP TABLE IF EXISTS `allergene`;
DROP TABLE IF EXISTS `ingredient`;
DROP TABLE IF EXISTS `produit`;

DROP TABLE IF EXISTS `categorie`;
DROP TABLE IF EXISTS `marque`;

--
-- Table structure for table `categorie`
--
CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `marque`
--
CREATE TABLE `marque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `additif`
--
CREATE TABLE `additif` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `allergene`
--
CREATE TABLE `allergene` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `ingredient`
--
CREATE TABLE `ingredient` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

--
-- Table structure for table `produit`
--
CREATE TABLE `produit` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GRADE` varchar(255) DEFAULT NULL,
  `NOM` varchar(2000) DEFAULT NULL,
  `ID_CAT` bigint(20) DEFAULT NULL,
  `ID_MRQ` bigint(20) DEFAULT NULL,
  `betaCarotene100g` decimal(5,2) DEFAULT NULL,
  `calcium100g` decimal(5,2) DEFAULT NULL,
  `energie100g` decimal(8,2) DEFAULT NULL,
  `fer100g` decimal(5,2) DEFAULT NULL,
  `fibres100g` decimal(5,2) DEFAULT NULL,
  `graisse100g` decimal(6,2) DEFAULT NULL,
  `iron100g` decimal(5,2) DEFAULT NULL,
  `magnesium100g` decimal(5,2) DEFAULT NULL,
  `presenceHuilePalme` varchar(2) DEFAULT NULL,
  `proteines100g` decimal(5,2) DEFAULT NULL,
  `sel100g` decimal(5,2) DEFAULT NULL,
  `sucres100g` decimal(6,2) DEFAULT NULL,
  `vitA100g` decimal(5,2) DEFAULT NULL,
  `vitB1100g` decimal(5,2) DEFAULT NULL,
  `vitB12100g` decimal(5,2) DEFAULT NULL,
  `vitB2100g` decimal(5,2) DEFAULT NULL,
  `vitB6100g` decimal(5,2) DEFAULT NULL,
  `vitB9100g` decimal(5,2) DEFAULT NULL,
  `vitC100g` decimal(5,2) DEFAULT NULL,
  `vitD100g` decimal(5,2) DEFAULT NULL,
  `vitE100g` decimal(5,2) DEFAULT NULL,
  `vitK100g` decimal(5,2) DEFAULT NULL,
  `vitPP100g` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PRD_CAT` FOREIGN KEY (`ID_CAT`) REFERENCES `categorie` (`id`),
  CONSTRAINT `FK_PRD_MRQ` FOREIGN KEY (`ID_MRQ`) REFERENCES `marque` (`id`)
);

--
-- Table structure for table `composition_add`
--
CREATE TABLE `composition_add` (
  `ID_PRD` bigint(20) NOT NULL,
  `ID_ADD` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PRD`,`ID_ADD`),
  CONSTRAINT `FK_COMPO_ADD_ADD` FOREIGN KEY (`ID_ADD`) REFERENCES `additif` (`id`),
  CONSTRAINT `FK_COMPO_ADD_PRD` FOREIGN KEY (`ID_PRD`) REFERENCES `produit` (`ID`)
);

--
-- Table structure for table `composition_all`
--
CREATE TABLE `composition_all` (
  `ID_PRD` bigint(20) NOT NULL,
  `ID_ALL` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PRD`,`ID_ALL`),
  CONSTRAINT `FK_COMPO_ALL_ALL` FOREIGN KEY (`ID_ALL`) REFERENCES `allergene` (`id`),
  CONSTRAINT `FK_COMPO_ALL_PRD` FOREIGN KEY (`ID_PRD`) REFERENCES `produit` (`ID`)
);

--
-- Table structure for table `composition_ing`
--
CREATE TABLE `composition_ing` (
  `ID_PRD` bigint(20) NOT NULL,
  `ID_ING` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PRD`,`ID_ING`),
  CONSTRAINT `FK_COMPO_ING_ING` FOREIGN KEY (`ID_ING`) REFERENCES `ingredient` (`ID`),
  CONSTRAINT `FK_COMPO_ING_PRD` FOREIGN KEY (`ID_PRD`) REFERENCES `produit` (`ID`)
);
