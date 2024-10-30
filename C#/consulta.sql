/*DELETE FROM alumnos WHERE codigo = 1001;
DELETE FROM alumnos WHERE codigo = 1002;
DELETE FROM alumnos WHERE codigo = 1003;
DELETE FROM alumnos WHERE codigo = 1004;
DELETE FROM alumnos WHERE codigo = 1005;
DELETE FROM alumnos WHERE codigo = 1006;*/

TRUNCATE TABLE alumnos;
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1001, 'Ana', 'Pérez', 563563, 'Sevilla', 5.2);
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1002, 'Laura', 'López', 464652, 'Huelva', 9.0);
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1003, 'Luis', 'Casillas', 713713, 'Sevilla', 6.5);
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1004, 'José', 'Medina', 758728, 'Huelva', 8.7);
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1005, 'María', 'Sánchez', 149149, 'Sevilla', 6.8);
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia, nota) VALUES (1006, 'Jesús', 'Martínez', 851851, 'Málaga', 4.8);


/*
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1001, "Matemáticas", 5.2);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1002, "Matemáticas", 9.0);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1003, "Matemáticas", 6.5);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1004, "Matemáticas", 8.0);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1005, "Matemáticas", 9.7);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1001, "Biología", 8.5);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1002, "Física", 4.0);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1003, "Química", 6.8);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1004, "Historia", 5.0);
INSERT INTO notas (CodigoAlumno, Asignatura, Nota) VALUES (1005, "Filosofía", 8.4);
//*/

/*SELECT * FROM notasalumnos;*/



