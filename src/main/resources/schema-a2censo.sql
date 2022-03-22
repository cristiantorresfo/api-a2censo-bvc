CREATE TABLE IF NOT EXISTS `a2censo`.`campaign` (
`idcampaign` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`amount` DECIMAL(20,2) NOT NULL,
`requestedAmount` DECIMAL(20,2) NOT NULL,
`adminRate` DECIMAL(15,2) NULL,
PRIMARY KEY (`idcampaign`))
ENGINE = InnoDB;

INSERT INTO `a2censo`.`campaign` (`name`, `amount`, `requestedAmount`) VALUES ('RobinFood 2.0', 200000000, 250000000);
INSERT INTO `a2censo`.`campaign` ( `name`, `amount`, `requestedAmount`) VALUES ('T4 Tea For U', 1000000000, 1200000000);
INSERT INTO `a2censo`.`campaign` ( `name`, `amount`, `requestedAmount`) VALUES ('Smoking Burgers', 200000000, 200000000);
INSERT INTO `a2censo`.`campaign` ( `name`, `amount`, `requestedAmount`) VALUES ('Resuelve tu deuda', 2000000000, 3000000000);
INSERT INTO `a2censo`.`campaign` ( `name`, `amount`, `requestedAmount`) VALUES ('Campaign', 150000000, 280000000);
INSERT INTO `a2censo`.`campaign` ( `name`, `amount`, `requestedAmount`) VALUES ('New Campaign', 450000000, 580000000);