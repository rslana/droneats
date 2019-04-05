SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP DATABASE IF EXISTS droneats;
CREATE DATABASE droneats;

-- -----------------------------------------------------
-- Table `droneats`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`proprietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`proprietario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`restaurante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `cnpj` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `descricao` VARCHAR(1000) NULL,
  `proprietario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_restaurante_proprietario1_idx` (`proprietario_id` ASC),
  CONSTRAINT `fk_restaurante_proprietario1`
    FOREIGN KEY (`proprietario_id`)
    REFERENCES `droneats`.`proprietario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NULL,
  `restaurante_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_categoria_restaurante_idx` (`restaurante_id` ASC),
  CONSTRAINT `fk_categoria_restaurante`
    FOREIGN KEY (`restaurante_id`)
    REFERENCES `droneats`.`restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `descricao` VARCHAR(300) NULL,
  `preco`  DOUBLE(6,2) NULL,
  `imagem` VARCHAR(100) NULL,
  `restaurante_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_restaurante1_idx` (`restaurante_id` ASC),
  CONSTRAINT `fk_produto_restaurante1`
    FOREIGN KEY (`restaurante_id`)
    REFERENCES `droneats`.`restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_pedido` VARCHAR(45) NULL,
  `hora_pedido` VARCHAR(45) NULL,
  `valor`  DOUBLE(7,2) NULL,
  `pago` TINYINT NULL,
  `data_pagamento` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `restaurante_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_restaurante1_idx` (`restaurante_id` ASC),
  INDEX `fk_pedido_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_pedido_restaurante1`
    FOREIGN KEY (`restaurante_id`)
    REFERENCES `droneats`.`restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `droneats`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`categoria_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`categoria_produto` (
  `categoria_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`categoria_id`, `produto_id`),
  INDEX `fk_categoria_has_produto_produto1_idx` (`produto_id` ASC),
  INDEX `fk_categoria_has_produto_categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_categoria_has_produto_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `droneats`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_has_produto_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `droneats`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`pedido_produto` (
  `pedido_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade` INT,
  `preco` DOUBLE(6,2),
  PRIMARY KEY (`pedido_id`, `produto_id`),
  INDEX `fk_pedido_has_produto_produto1_idx` (`produto_id` ASC),
  INDEX `fk_pedido_has_produto_pedido1_idx` (`pedido_id` ASC),
  CONSTRAINT `fk_pedido_has_produto_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `droneats`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_produto_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `droneats`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
