SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



-- -----------------------------------------------------
-- Table `droneats`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Cliente` (
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
-- Table `droneats`.`Proprietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Proprietario` (
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
-- Table `droneats`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Restaurante` (
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
  `descricao` VARCHAR(500) NULL,
  `Proprietario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Restaurante_Proprietario1_idx` (`Proprietario_id` ASC),
  CONSTRAINT `fk_Restaurante_Proprietario1`
    FOREIGN KEY (`Proprietario_id`)
    REFERENCES `droneats`.`Proprietario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NULL,
  `Restaurante_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Categoria_Restaurante_idx` (`Restaurante_id` ASC),
  CONSTRAINT `fk_Categoria_Restaurante`
    FOREIGN KEY (`Restaurante_id`)
    REFERENCES `droneats`.`Restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `descricao` VARCHAR(300) NULL,
  `preco` DOUBLE NULL,
  `imagem` VARCHAR(100) NULL,
  `Restaurante_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produto_Restaurante1_idx` (`Restaurante_id` ASC),
  CONSTRAINT `fk_Produto_Restaurante1`
    FOREIGN KEY (`Restaurante_id`)
    REFERENCES `droneats`.`Restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_pedido` VARCHAR(45) NULL,
  `hora_pedido` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `pago` TINYINT NULL,
  `data_pagamento` VARCHAR(45) NULL,
  `Restaurante_id` INT NOT NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Restaurante1_idx` (`Restaurante_id` ASC),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_id` ASC),
  CONSTRAINT `fk_Pedido_Restaurante1`
    FOREIGN KEY (`Restaurante_id`)
    REFERENCES `droneats`.`Restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `droneats`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`Categoria_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Categoria_Produto` (
  `Categoria_id` INT NOT NULL,
  `Produto_id` INT NOT NULL,
  PRIMARY KEY (`Categoria_id`, `Produto_id`),
  INDEX `fk_Categoria_has_Produto_Produto1_idx` (`Produto_id` ASC),
  INDEX `fk_Categoria_has_Produto_Categoria1_idx` (`Categoria_id` ASC),
  CONSTRAINT `fk_Categoria_has_Produto_Categoria1`
    FOREIGN KEY (`Categoria_id`)
    REFERENCES `droneats`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categoria_has_Produto_Produto1`
    FOREIGN KEY (`Produto_id`)
    REFERENCES `droneats`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `droneats`.`Pedido_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `droneats`.`Pedido_Produto` (
  `Pedido_id` INT NOT NULL,
  `Produto_id` INT NOT NULL,
  PRIMARY KEY (`Pedido_id`, `Produto_id`),
  INDEX `fk_Pedido_has_Produto_Produto1_idx` (`Produto_id` ASC),
  INDEX `fk_Pedido_has_Produto_Pedido1_idx` (`Pedido_id` ASC),
  CONSTRAINT `fk_Pedido_has_Produto_Pedido1`
    FOREIGN KEY (`Pedido_id`)
    REFERENCES `droneats`.`Pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Produto_Produto1`
    FOREIGN KEY (`Produto_id`)
    REFERENCES `droneats`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
