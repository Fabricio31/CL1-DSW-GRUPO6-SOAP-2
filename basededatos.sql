/*
•	Cree un base de datos con una tabla Paciente con los siguientes atributos:
 IdPaciente,
 NomPaciente,
 ApePaciente,
 DocPaciente,
 FechaNacPaciente,
 EmailPaciente
*/

drop database cl1_dsw_grupo6;
create database cl1_dsw_grupo6;
use cl1_dsw_grupo6;


create table paciente
(
	idpaciente int primary key auto_increment,
    nompaciente varchar(50),
    apepaciente  varchar(50),
    docpaciente varchar(50),
    fecnacpaciente varchar(50),
    emailpaciente varchar(50)
);

insert into paciente values (1,'Ramon','Lopez','777888999','01-02-1999','rlopez@correo.com');
select * from paciente