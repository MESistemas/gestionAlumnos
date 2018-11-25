drop database gestionalumnos;
create database gestionalumnos;
use gestionalumnos;

create table cursos(
    id int not null primary key auto_increment,
    nombre_curso varchar(1) not null
);

create table divisiones(
    id int not null primary key auto_increment,
    nombre_division varchar(1) not null
);

/*
 create table examenes(
   id int not null primary key auto_increment,
    fecha_Examen date not null,
    nota float
 ); */
/*
create table practicos(
    id int not null primary key auto_increment,
    fecha_Practico date not null,
    nota float
);
*/
create table alumnos(
    id int not null primary key auto_increment,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    dni varchar(8) not null,
    genero varchar(1) not null, 
    fecha_nacimiento date
);

create table profesores(
    id int not null primary key auto_increment,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    dni varchar(8) not null,
    genero varchar(1) not null, 
    fecha_nacimiento date
);

create table usuarios(
    id int not null primary key auto_increment,
    us varchar(15) not null,
    ps varchar(15) not null
);

create table materias_alumnos(
	id int not null primary key auto_increment,
    nota_primer_examen int,
    nota_segundo_examen int,
    nota_tercer_examen int,
    nota_primer_tp int,
    nota_segundo_tp int,
	nota_primer_trimestre int,
    nota_segundo_trimestre int,
    nota_tercer_trimestre int,
    nota_final int,
    condicion varchar(15)
);

create table materias(
    id int not null primary key auto_increment,
    nombre_materia varchar(25) not null
);

create table agendas(
	id int not null primary key auto_increment,
    titulo varchar(35) not null,
    descripcion varchar(100) not null,
    fecha date
);

