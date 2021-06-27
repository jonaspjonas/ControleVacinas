-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema controle_vacina
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema controle_vacina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controle_vacina` DEFAULT CHARACTER SET utf8 ;
USE `controle_vacina` ;

-- -----------------------------------------------------
-- Table `controle_vacina`.`vacina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_vacina`.`vacina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `fabricante` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle_vacina`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_vacina`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `sus` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle_vacina`.`enfermeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_vacina`.`enfermeiro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle_vacina`.`vacinacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_vacina`.`vacinacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `paciente_id` INT NOT NULL,
  `vacina_id` INT NOT NULL,
  `lote` VARCHAR(25) NOT NULL,
  `enfermeiro_id` INT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vacinacao_paciente_idx` (`paciente_id` ASC) VISIBLE,
  INDEX `fk_vacinacao_vacina1_idx` (`vacina_id` ASC) VISIBLE,
  INDEX `fk_vacinacao_enfermeiro1_idx` (`enfermeiro_id` ASC) VISIBLE,
  CONSTRAINT `fk_vacinacao_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `controle_vacina`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinacao_vacina1`
    FOREIGN KEY (`vacina_id`)
    REFERENCES `controle_vacina`.`vacina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinacao_enfermeiro1`
    FOREIGN KEY (`enfermeiro_id`)
    REFERENCES `controle_vacina`.`enfermeiro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into paciente (nome, data_nascimento, telefone, sus)
values ('Jonas', '1979-05-08', '(91)99874-5621', '708451265987845');
insert into paciente (nome, data_nascimento, telefone, sus)
values ('Jessica', '1999-10-05', '(91)98989-8989', '708412000000000');
insert into paciente (nome, data_nascimento, telefone, sus)
values ('Bianca', '1985-01-10', '(93)90900-0014', '999999999987845');

insert into vacina (nome, fabricante, descricao)
values ('BCG', 'Fundação Ataulpho de Paiva', 'Previne as formas graves de tuberculose, principalmente miliar e meníngea – dose única' );
insert into vacina (nome, fabricante, descricao)
values ('Hepatite B', 'Instituto Butantan', 'previne a hepatite B – 1 Dose ao nascer' );
insert into vacina (nome, fabricante, descricao)
values ('Vacina Poliomielite', 'Bio-Manguinhos', 'VIP (previne a poliomielite) – três doses' );
insert into vacina (nome, fabricante, descricao)
values ('CoronaVac (Sinovac Biotech)','Instituto Butantan', 'Combate a COVID-19' );

insert into enfermeiro (nome, telefone)
values ('Wanderlei Mansinho','(91)98745-2121');
insert into enfermeiro (nome, telefone)
values ('Gerusa Mão Leve', '(91)94545-2525');