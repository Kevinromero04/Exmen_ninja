drop database if exists ninjas;

create database if not exists ninjas;

use ninjas


create table if not exists aldeas(
	id_aldea int primary key auto_increment,
	nombre_aldea varchar(100) not null
);


create table if not exists habilidades(
	id_habilidad int primary key auto_increment,
	nombre_habilidad varchar(100) not null
);


create table if not exists rangos(
	id_rango int primary key auto_increment,
	nombre_rango varchar(100) not null
);


create table if not exists ninjas(
	id_ninja int primary key auto_increment,
	nombre varchar(100) not null,
	documento int not null unique,
	id_rango int,
	id_aldea int,
	foreign key (id_aldea) references aldeas(id_aldea),
	foreign key(id_rango) references rangos(id_rango)
);


create table if not exists habilidad_ninjas(
	id_habilidad_ninja int primary key auto_increment,
	id_ninja int,
	id_habilidad int,
	foreign key(id_ninja) references ninjas(id_ninja),
	foreign key(id_habilidad) references habilidades(id_habilidad)
	
);

create table if not exists dificultades(
	id_dificultad int primary key auto_increment,
	dificultad varchar(100) not null
);

create table if not exists misiones(
	id_mision int primary key auto_increment,
	nombre_mision varchar(100) not null,
	descripcion varchar(100) not null,
	id_dificultad int,
	recompensa varchar(100) not null,
	foreign key(id_dificultad) references dificultades(id_dificultad)
);




create table if not exists mision_ninjas(
	id_mision_ninja int primary key auto_increment,
	id_ninja int,
	id_mision int,
	fecha_inicio date not null,
	fecha_fin date not null,
	foreign key (id_mision) references misiones(id_mision),
	foreign key (id_ninja) references ninjas(id_ninja)
);







