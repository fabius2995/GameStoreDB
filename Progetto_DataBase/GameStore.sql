/* creazione del database Game Store.
 DDL */
CREATE DATABASE GameStore;
USE GameStore;

CREATE TABLE Cliente (
  Cod_ID INTEGER ,
  Cognome VARCHAR(20) NOT NULL,
  Nome VARCHAR(20) NOT NULL,
  DatadiNascita VARCHAR(10) ,
  PRIMARY KEY(Cod_ID)
);

CREATE TABLE Responsabile (
  ID_Responsabile INTEGER,
  Cognome VARCHAR(20) NOT NULL,
  Nome VARCHAR(20) NOT NULL,
  DatadiNascita VARCHAR(10) NOT NULL,
  DatadiAssunzione VARCHAR(10) NOT NULL,
  Stipendio INTEGER,
  Residenza VARCHAR(30),
  PRIMARY KEY(ID_Responsabile)
);

CREATE TABLE Addetto (
  Matricola INTEGER,
  Cognome VARCHAR(20) NOT NULL,
  Nome VARCHAR(20) NOT NULL,
  DatadiNascita VARCHAR(10) NOT NULL,
  DatadiAssunzione  VARCHAR(10) NOT NULL,
  Stipendio INTEGER,
  Residenza VARCHAR(30),
  PRIMARY KEY(Matricola)
);

CREATE TABLE Gioco (
  IDGioco INTEGER,
  Titolo VARCHAR(20) NOT NULL,
  Prezzo INTEGER,
  Quantità INTEGER,
  Console VARCHAR(10) NOT NULL,
  PRIMARY KEY (IDGioco)
);

CREATE TABLE TipodiGioco (
  Tipo VARCHAR(10),
  Descrizione VARCHAR(30),
  Forma VARCHAR(20) NOT NULL,
  Capacità INTEGER,
  Marca VARCHAR(20) NOT NULL,
  PRIMARY KEY (Tipo)
);

CREATE TABLE Vendite (
  IDGioco INTEGER, 
  Cod_ID  INTEGER, 
  Matricola INTEGER,
  Quantità INTEGER, 
  IVA INTEGER, 
  TotaleVendita INTEGER,

  PRIMARY KEY (IDGioco, Cod_ID, Matricola),
  FOREIGN KEY (IDGioco)
  REFERENCES Gioco (IDGioco),
  FOREIGN KEY (Cod_ID)
  REFERENCES Cliente (Cod_ID),
  FOREIGN KEY (Matricola)
  REFERENCES Addetto (Matricola)
);

CREATE TABLE Team (
  Matricola INTEGER,
  ID_Responsabile INTEGER,
  data VARCHAR(10) NOT NULL,

  PRIMARY KEY (Matricola, ID_Responsabile),
  FOREIGN KEY (Matricola)
  REFERENCES Addetto(Matricola),
  FOREIGN KEY (ID_Responsabile)
  REFERENCES Responsabile(ID_Responsabile)
);

CREATE TABLE Formato (
  Tipo VARCHAR(10) NOT NULL,
  IDGioco INTEGER,
  
  PRIMARY KEY (Tipo, IDGioco),
  FOREIGN KEY (IDGioco)
  REFERENCES Gioco(IDGioco),
  FOREIGN KEY (Tipo)
  REFERENCES TipodiGioco (Tipo)
);

/*Popolamento del Database*/

/*Insert Addetto*/

insert into Addetto value (0,'Cirillo','Giuseppe','05/03/1992','18/04/2012',1300,'Scafati');
insert into Addetto value (1,'De Michele','Giuseppe','27/11/1992','18/04/2012',1300,'Scafati');
insert into Addetto value (2,'Matrone','Luigi','26/08/1993','12/10/2013',1300,'Pompei');

/*Insert Responsabile*/

insert into Responsabile value (0,'Amendola','Salvatore','06/02/1994','17/04/2012',1500,'Scafati');

/*Insert Cliente*/

insert into Cliente value (0,'Amendola','Vincenzo','17/12/1998');
insert into Cliente value (1,'Vitiello','Vincenzo','05/07/1993');
insert into Cliente value (2,'Russo','Daniele','10/07/1993');
insert into Cliente value (3,'Ruocco','Antonella','07/01/1995');
insert into Cliente value (4,'Lamberti','Maria','15/04/1991');

/*Insert Gioco*/

insert into Gioco value (0,'Pac Man',30,500,'PS4');
insert into Gioco value (1,'The Order',60,1000,'PS4');
insert into Gioco value (2,'Quantum Break',60,2000,'XBOXONE');
insert into Gioco value (3,'Halo 5',50,100,'XBOXONE');
insert into Gioco value (4,'Zelda',35,500,'NINTENDO3DS');
insert into Gioco value (5,'Fifa16',60,2000,'PS4');



/*Insert TipodiGioco*/

insert into TipodiGioco value ('DVD','Disco utilizzato da XBOX','Disco',8,'Verbatim');
insert into TipodiGioco value ('Blu Ray','Disco utilizzato da PlayStation','Disco',12,'BluRayDisc');
insert into TipodiGioco value ('Cartuccia','MemoryCard utilizzata da Nintendo','Scheda',5,'Nintendo');

/*Insert Vendite*/

insert into Vendite value (4,0,1,1,7,42);
insert into Vendite value (5,2,0,1,12,72);
insert into Vendite value (2,3,2,2,24,144);

/*Insert Team */

insert into Team value (0,0,'18/04/2012');
insert into Team value (1,0,'18/04/2012');
insert into Team value (2,0,'18/04/2012');

/*Insert Formato*/

insert into Formato value ('DVD',2);
insert into Formato value ('DVD',3);
insert into Formato value ('Blu Ray',0);
insert into Formato value ('Blu Ray',1);
insert into Formato value ('Blu Ray',5);
insert into Formato value ('Cartuccia',4);