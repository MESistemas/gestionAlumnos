insert into divisiones(nombre_division) values
('A'),
('B');

insert into cursos(nombre_curso, fk_cur_div) values
('3',1),
('3',2);

insert into profesores(nombre, apellido, dni, genero, fecha_nacimiento) values
('Luisina', 'Espindola', '28374944', 'F', '1985-04-25');

insert into alumnos(nombre,apellido,dni,genero,fecha_Nacimiento,fk_Alu_Cur) values
('Lucas', 'Escobar', '25111000', 'M', '22/01/1996',1),
('Martín', 'Perez', '25000555', 'M', '11/03/1996',1),
('Lucas', 'Martinez', '25000444', 'M', '22/01/1996',1),
('Pedro', 'Torres', '25000333', 'M', '11/01/1995',1),
('Leonardo', 'Britez', '25230234', 'M', '30/05/1995',1),
('Patricio', 'Jacobo', '25111001', 'M', '22/03/1996',1),
('Carlos', 'Lucrecio', '25001911', 'M', '11/01/1996',1),
('Carla', 'Perez', '25000333', 'F', '25/05/1996',1),
('Florencia', 'Alario', '25111222', 'F', '11/03/1996',1),
('María', 'Martinez', '25222111', 'F', '11/01/1996',1),
('Lourdes', 'Espinoza', '25333999', 'F', '30/12/1996',1),
('Ludmila', 'Ruth', '25666333', 'F', '30/08/1996',1),
('Fiorela', 'Perez', '25888333', 'F', '05/08/1996',1),

('Javier', 'Lopez', '25909090', 'M', '15/05/1995',2),
('Jorge', 'Aguirre', '25434343', 'M', '30/10/1996',2),
('Dario', 'Sosa', '25232232', 'M', '14/05/1996',2),
('Ruben', 'Sanchez', '25123123', 'M', '11/01/1994',2),
('Pablo', 'Villareal', '25434344', 'M', '22/03/1996',2),
('Franco', 'Acosta', '25934344', 'M', '12/01/1996',2),
('Federico', 'Pratto', '25854534', 'M', '11/07/1996',2),
('Melani', 'Martinez', '25794565', 'F', '11/01/1996',2),
('Rosario', 'Ingrid', '25676765', 'F', '11/03/1996',2),
('María', 'Palacios', '25545646', 'F', '05/05/1995',2),
('Micaela', 'Jacobo', '25231314', 'F', '01/11/1996',2),
('Karen', 'Esquivel', '25123934', 'F', '03/12/1996',2),
('Eugenia', 'Toledo', '25329324', 'F', '05/12/1996',2);

insert into materias(nombre_materia, fk_mat_pro) values
('Informática I', 1);

insert into agendas(titulo, descripcion, fecha, fk_age_mat) values
('Inicio de Clases', 'Comienzo 1er Trimestre', '04/03/2019', 1);


select * from cursos;

select * from alumnos order by alumnos.genero , alumnos.apellido;

select * from materias;

select * from profesores;

select * from agendas;

select * from  mysql.time_zone_name WHERE Name Like '%exico%';

select * from materias_alumnos;

select nombre_Curso as 'Curso',
	   nombre_Division as 'Division'
from cursos inner join divisiones on divisiones.id = cursos.fk_Cur_Div;



insert into usuarios(us,ps,fk_Usu_Per) values
('admin','root',1);