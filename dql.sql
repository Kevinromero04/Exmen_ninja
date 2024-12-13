use ninjas;

insert into aldeas(nombre_aldea) values("Aldea amarilla"),
("Aldea roja"),
("Aldea verde");

insert into rangos(nombre_rango) values("Rango super maestro"),
("Rango maestro"),
("Rango estudiante"),
("Rango novato");


insert into ninjas(nombre,documento,id_rango,id_aldea) values ("Kevin Romero","1029",1,2),
("Mariana small","1030",2,1),
("Santiago sasa","1050",3,3);

insert into dificultades(dificultad) values("dificil"),
("media"),
("baja");

insert into misiones (nombre_mision,descripcion,id_dificultad,recompensa) values("Recoger frutas","El ninja debe explorar el mundo y trear frutas",3,"10 monedas"),
("Recoger madera","el jugador debe ir a la aldea de alado a recoger madera",2,"50 monedas"),
("Atacar otra aldea","el jugador debe ir a una aldea y atacarla",1,"100 monedas");

insert into habilidades (nombre_habilidad) values("volar"),
("invisibilidad"),
("velocidad");

insert into habilidad_ninjas (id_ninja,id_habilidad) values(1,3),
(1,2),
(2,1),
(3,2);

insert into mision_ninjas (id_ninja,id_mision,fecha_inicio,fecha_fin) values (1,1,"2020-05-01","2020-05-10"),
(2,1,"2020-06-02","2020-06-05");
