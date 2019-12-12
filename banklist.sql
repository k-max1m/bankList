-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema banklist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banklist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banklist` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `banklist` ;

-- -----------------------------------------------------
-- Table `banklist`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banklist`.`user` (
  `userid` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `sureName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `banklist`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banklist`.`account` (
  `accountId` INT(11) NOT NULL,
  `account` INT(11) NOT NULL,
  `userid` INT(11) NOT NULL,
  PRIMARY KEY (`userid`),
  INDEX `Account_FK_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `Account_FK`
    FOREIGN KEY (`userid`)
    REFERENCES `banklist`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `banklist`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `banklist`;
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (1, 'Maxim', 'Kozlov');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (2, 'Victor', 'Javnerovskiy');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (3, 'Evgeniy', 'Nikolaev');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (4, 'Ksenia', 'Nikolaeva');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (5, 'Kirill', 'Kotov');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (6, 'Anton', 'Teterev');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (7, 'Victoria', 'Skotnikova');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (8, 'Vlad', 'Baranok');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (9, 'Dmitriy', 'Suhodolskiy');
INSERT INTO `banklist`.`user` (`userid`, `name`, `sureName`) VALUES (10, 'Aleksey', 'Raskosha');

COMMIT;


-- -----------------------------------------------------
-- Data for table `banklist`.`account`
-- -----------------------------------------------------
START TRANSACTION;
USE `banklist`;
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2201, 600, 1);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2507, 650, 2);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2601, 600, 3);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (601, 1100, 4);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (1010, 610, 5);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (1802, 1200, 6);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2604, 700, 7);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2711, 500, 8);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2311, 1600, 9);
INSERT INTO `banklist`.`account` (`accountId`, `account`, `userid`) VALUES (2707, 1500, 10);

COMMIT;

