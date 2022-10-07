use bdpasteleriav2;

CREATE TABLE `bdpasteleriav2`.`trabajador` (
  `codigo` INT NOT NULL,
  `nombreCompleto` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(15) NULL,
  `password` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`codigo`));
  
  CREATE TABLE `bdpasteleriav2`.`gerente` (
  `trabajador_codigoG` INT NOT NULL,
  PRIMARY KEY (`trabajador_codigoG`),
  CONSTRAINT `trabajador_codigo`
    FOREIGN KEY (`trabajador_codigoG`)
    REFERENCES `bdpasteleriav2`.`trabajador` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pide` (
  `fechaPedido` DATE NOT NULL,
  `proveedor_codigoP` INT NOT NULL,
  `gerente_trabajador_codigo` INT NOT NULL,
  PRIMARY KEY (`proveedor_codigoP`, `gerente_trabajador_codigo`));
  
  ALTER TABLE `bdpasteleriav2`.`pide` 
ADD INDEX `gerente_trabajador_codigo_idx` (`gerente_trabajador_codigo` ASC) VISIBLE;
;
ALTER TABLE `bdpasteleriav2`.`pide` 
ADD CONSTRAINT `gerente_trabajador_codigo`
  FOREIGN KEY (`gerente_trabajador_codigo`)
  REFERENCES `bdpasteleriav2`.`gerente` (`trabajador_codigoG`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `proveedor_trabajador_codigo`
  FOREIGN KEY (`proveedor_codigoP`)
  REFERENCES `bdpasteleriav2`.`proveedor` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `bdpasteleriav2`.`proveedor` (
  `codigo` INT NOT NULL,
  `nomEmpresa` VARCHAR(25) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(35) NULL,
  PRIMARY KEY (`codigo`));

CREATE TABLE `bdpasteleriav2`.`repartidor` (
  `trabajador_codigoR` INT NOT NULL,
  PRIMARY KEY (`trabajador_codigoR`),
  CONSTRAINT `trabajador_codigoR`
    FOREIGN KEY (`trabajador_codigoR`)
    REFERENCES `bdpasteleriav2`.`trabajador` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`vendedor` (
  `trabajador_codigoV` INT NOT NULL,
  PRIMARY KEY (`trabajador_codigoV`),
  CONSTRAINT `trabajador_codigoV`
    FOREIGN KEY (`trabajador_codigoV`)
    REFERENCES `bdpasteleriav2`.`trabajador` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pastelero` (
  `trabajador_codigoP` INT NOT NULL,
  PRIMARY KEY (`trabajador_codigoP`),
  CONSTRAINT `trabajador_codigoP`
    FOREIGN KEY (`trabajador_codigoP`)
    REFERENCES `bdpasteleriav2`.`trabajador` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`ingrediente` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `caducidad` VARCHAR(45) NOT NULL,
  `tipo` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdpasteleriav2`.`entrega` (
  `fechaEntrega` DATE NOT NULL,
  `cantEntregada` INT NOT NULL,
  `provedor_codigoE` INT NOT NULL,
  `ingrediente_id` INT NOT NULL,
  PRIMARY KEY (`provedor_codigoE`, `ingrediente_id`),
  INDEX `ingrediente_id_idx` (`ingrediente_id` ASC) VISIBLE,
  CONSTRAINT `proveedor_codigoE`
    FOREIGN KEY (`provedor_codigoE`)
    REFERENCES `bdpasteleriav2`.`proveedor` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ingrediente_id`
    FOREIGN KEY (`ingrediente_id`)
    REFERENCES `bdpasteleriav2`.`ingrediente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pastel` (
  `id` INT NOT NULL,
  `color` VARCHAR(25) NOT NULL,
  `tipoPan` VARCHAR(25) NOT NULL,
  `precio` DECIMAL(3) NOT NULL,
  `forma` VARCHAR(25) NOT NULL,
  `tamaño` VARCHAR(25) NOT NULL,
  `numPisos` INT NOT NULL,
  `relleno` VARCHAR(25) NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  `pastelero_trabajador_codigoP` INT NOT NULL,
  PRIMARY KEY (`id`, `pastelero_trabajador_codigoP`),
  INDEX `pastelero_trabjador_codigoP_idx` (`pastelero_trabajador_codigoP` ASC) VISIBLE,
  CONSTRAINT `pastelero_trabjador_codigoP`
    FOREIGN KEY (`pastelero_trabajador_codigoP`)
    REFERENCES `bdpasteleriav2`.`pastelero` (`trabajador_codigoP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`vende` (
  `fechaVenta` DATE NOT NULL,
  `horaVenta` TIME NULL,
  `total` DECIMAL(3) NOT NULL,
  `vendedor_trabajador_codigoV` INT NOT NULL,
  `pastel_idV` INT NOT NULL,
  PRIMARY KEY (`vendedor_trabajador_codigoV`, `pastel_idV`),
  INDEX `pastel_idV_idx` (`pastel_idV` ASC) VISIBLE,
  CONSTRAINT `vendedor_trabajador_codigo`
    FOREIGN KEY (`vendedor_trabajador_codigoV`)
    REFERENCES `bdpasteleriav2`.`vendedor` (`trabajador_codigoV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pastel_idV`
    FOREIGN KEY (`pastel_idV`)
    REFERENCES `bdpasteleriav2`.`pastel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pedido` (
  `id` INT NOT NULL,
  `fechaPedido` DATE NULL,
  `total` DECIMAL(3) NULL,
  `anticipo` DECIMAL(3) NULL,
  `vendedor_trabajador_codigoP` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `vendedor_trabjadador_codigoP_idx` (`vendedor_trabajador_codigoP` ASC) VISIBLE,
  CONSTRAINT `vendedor_trabjadador_codigoP`
    FOREIGN KEY (`vendedor_trabajador_codigoP`)
    REFERENCES `bdpasteleriav2`.`vendedor` (`trabajador_codigoV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pedido` (
  `id` INT NOT NULL,
  `fechaPedido` DATE NULL,
  `total` DECIMAL(3) NULL,
  `anticipo` DECIMAL(3) NULL,
  `vendedor_trabajador_codigoP` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `vendedor_trabjadador_codigoP_idx` (`vendedor_trabajador_codigoP` ASC) VISIBLE,
  CONSTRAINT `vendedor_trabjadador_codigoP`
    FOREIGN KEY (`vendedor_trabajador_codigoP`)
    REFERENCES `bdpasteleriav2`.`vendedor` (`trabajador_codigoV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`pedido_has_pastel` (
  `pedido_id` INT NOT NULL,
  `pastel_id` INT NOT NULL,
  PRIMARY KEY (`pedido_id`, `pastel_id`),
  INDEX `pastel_id_idx` (`pastel_id` ASC) VISIBLE,
  CONSTRAINT `pedido_id`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `bdpasteleriav2`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pastel_id`
    FOREIGN KEY (`pastel_id`)
    REFERENCES `bdpasteleriav2`.`pastel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`cliente` (
  `id` INT NOT NULL,
  `nombreCliente` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdpasteleriav2`.`cliente_has_pedido` (
  `cliente_id` INT NOT NULL,
  `pedido_idC` INT NOT NULL,
  PRIMARY KEY (`cliente_id`, `pedido_idC`),
  INDEX `pedido_idC_idx` (`pedido_idC` ASC) VISIBLE,
  CONSTRAINT `cliente_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bdpasteleriav2`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pedido_idC`
    FOREIGN KEY (`pedido_idC`)
    REFERENCES `bdpasteleriav2`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdpasteleriav2`.`direccion` (
  `id` INT NOT NULL,
  `ciudad` VARCHAR(20) NOT NULL,
  `colonia` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `numCasa` INT NOT NULL,
  `detalles` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `bdpasteleriav2`.`cliente` 
CHANGE COLUMN `direccion` `direccion_id` INT NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `direccion_id`),
ADD INDEX `direccion_id_idx` (`direccion_id` ASC) VISIBLE;
;
ALTER TABLE `bdpasteleriav2`.`cliente` 
ADD CONSTRAINT `direccion_id`
  FOREIGN KEY (`direccion_id`)
  REFERENCES `bdpasteleriav2`.`direccion` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


