/*creamos y usamos la base*/
CREATE SCHEMA `bdpasteleriav4` ;
use bdpasteleriav4;

/*Creacion de tablas
primero se ejecuta esta parte*/
CREATE TABLE `bdpasteleriav4`.`trabajador` (
  `IDTrabajador` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(25) NOT NULL,
  `PrimerApellido` VARCHAR(25) NOT NULL,
  `SegundoApellido` VARCHAR(25) NULL,
  `Telefono` VARCHAR(15) NOT NULL,
  `Pass` VARCHAR(30) NOT NULL,
  `Tipo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`IDTrabajador`),
  UNIQUE INDEX `IDTrabajador_UNIQUE` (`IDTrabajador` ASC) VISIBLE);
  
  CREATE TABLE `bdpasteleriav4`.`pastel` (
  `IDPastel` INT NOT NULL AUTO_INCREMENT,
  `Color` VARCHAR(25) NOT NULL,
  `Forma` VARCHAR(25) NOT NULL,
  `Size` VARCHAR(15) NOT NULL,
  `Relleno` VARCHAR(25) NOT NULL,
  `TipoPan` VARCHAR(25) NOT NULL,
  `NumPisos` INT NOT NULL,
  `Precio` DECIMAL NOT NULL,
  `Descripccion` VARCHAR(100) NULL,
  `EstadoPastel` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`IDPastel`),
  UNIQUE INDEX `IDPastel_UNIQUE` (`IDPastel` ASC) VISIBLE);
  
  CREATE TABLE `bdpasteleriav4`.`venta` (
  `IDVenta` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(25) NOT NULL,
  `HoraEntrega` TIME NOT NULL,
  `FechaEntrega` DATE NOT NULL,
  `HoraVenta` TIME NOT NULL,
  `FechaVenta` DATE NOT NULL,
  `Anticipo` DECIMAL NOT NULL,
  `Total` DECIMAL NOT NULL,
  `Entregado` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`IDVenta`),
  UNIQUE INDEX `IDVenta_UNIQUE` (`IDVenta` ASC) VISIBLE);
  
  CREATE TABLE `bdpasteleriav4`.`cliente` (
  `IDCliente` INT NOT NULL AUTO_INCREMENT,
  `NombreCliente` VARCHAR(25) NOT NULL,
  `PrimerApellido` VARCHAR(25) NOT NULL,
  `SegundoApellido` VARCHAR(25) NOT NULL,
  `Telefono` VARCHAR(15) NOT NULL,
  `TelRecuperacion` VARCHAR(15) NULL,
  PRIMARY KEY (`IDCliente`),
  UNIQUE INDEX `IDCliente_UNIQUE` (`IDCliente` ASC) VISIBLE);

CREATE TABLE `bdpasteleriav4`.`direccion` (
  `IDDireccion` INT NOT NULL AUTO_INCREMENT,
  `Ciudad` VARCHAR(25) NOT NULL,
  `Colonia` VARCHAR(25) NOT NULL,
  `Calle` VARCHAR(25) NOT NULL,
  `NumInterior` INT NULL,
  `NumExterior` INT NOT NULL,
  `Detalles` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`IDDireccion`),
  UNIQUE INDEX `IDDireccion_UNIQUE` (`IDDireccion` ASC) VISIBLE);

/*creacion de llaves foraneas
despues esta parte para evitar fallos*/
ALTER TABLE `bdpasteleriav4`.`cliente` 
ADD COLUMN `Direccion_IDDireccion` INT NOT NULL AFTER `TelRecuperacion`,
ADD UNIQUE INDEX `Direccion_IDDireccion_UNIQUE` (`Direccion_IDDireccion` ASC) VISIBLE;
;
ALTER TABLE `bdpasteleriav4`.`cliente` 
ADD CONSTRAINT `Direccion_IDDireccion`
  FOREIGN KEY (`Direccion_IDDireccion`)
  REFERENCES `bdpasteleriav4`.`direccion` (`IDDireccion`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `bdpasteleriav4`.`venta` 
ADD COLUMN `Trabajador_IDTrabajador` INT NOT NULL AFTER `Entregado`,
ADD COLUMN `Cliente_IDCliente` INT NOT NULL AFTER `Trabajador_IDTrabajador`,
ADD UNIQUE INDEX `Trabajador_IDTrabajador_UNIQUE` (`Trabajador_IDTrabajador` ASC) VISIBLE,
ADD UNIQUE INDEX `Cliente_IDCliente_UNIQUE` (`Cliente_IDCliente` ASC) VISIBLE;
;
ALTER TABLE `bdpasteleriav4`.`venta` 
ADD CONSTRAINT `Trabajador_IDTrabajador`
  FOREIGN KEY (`Trabajador_IDTrabajador`)
  REFERENCES `bdpasteleriav4`.`trabajador` (`IDTrabajador`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `Cliente_IDCliente`
  FOREIGN KEY (`Cliente_IDCliente`)
  REFERENCES `bdpasteleriav4`.`cliente` (`IDCliente`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  CREATE TABLE `bdpasteleriav4`.`pastelventa` (
  `Pastel_IDPastel` INT NOT NULL,
  `Venta_IDVenta` INT NOT NULL,
  PRIMARY KEY (`Pastel_IDPastel`, `Venta_IDVenta`),
  UNIQUE INDEX `Pastel_IDPastel_UNIQUE` (`Pastel_IDPastel` ASC) VISIBLE,
  UNIQUE INDEX `Venta_IDVenta_UNIQUE` (`Venta_IDVenta` ASC) VISIBLE,
  CONSTRAINT `Pastel_IDPastel`
    FOREIGN KEY (`Pastel_IDPastel`)
    REFERENCES `bdpasteleriav4`.`pastel` (`IDPastel`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Venta_IDVenta`
    FOREIGN KEY (`Venta_IDVenta`)
    REFERENCES `bdpasteleriav4`.`venta` (`IDVenta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);