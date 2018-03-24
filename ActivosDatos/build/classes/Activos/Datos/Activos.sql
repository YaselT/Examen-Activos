Create database Activos;
Use Activos;

CREATE TABLE Categoria (
 Id varchar (5) NOT NULL ,
 Categoria varchar (30),
 VidaUtil int,
 PRIMARY KEY (Id)
);
 
CREATE TABLE Activo (
 Codigo varchar (5) NOT NULL ,
 Activo varchar (30),
 ValorOriginal int,
 Fabricacion int,
 IdCategoria varchar (5),
 PRIMARY KEY (Codigo)
);

ALTER TABLE Activo ADD FOREIGN KEY (IdCategoria) REFERENCES Categoria(Id);

INSERT INTO Categoria VALUES ('CAS','Casa',50);
INSERT INTO Categoria VALUES ('VEH','Vehiculo',20);
INSERT INTO Categoria VALUES ('COMP','Computadora',5);

INSERT INTO Activo VALUES ('CAS1','Casa Alajuela',30000,'2005','CAS');
INSERT INTO Activo VALUES ('VEH3','Automovil azul',10000,'2008','VEH');