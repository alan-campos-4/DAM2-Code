
TRUNCATE TABLE alumnos;
TRUNCATE TABLE notas;

INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia) VALUES (1001, 'Ana', 'Pérez', 563563, 'Sevilla');
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia) VALUES (1002, 'Laura', 'López', 464652, 'Huelva');
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia) VALUES (1003, 'Luis', 'Casillas', 713713, 'Sevilla');
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia) VALUES (1004, 'José', 'Medina', 758728, 'Huelva');
INSERT INTO alumnos (codigo, nombre, apellidos, telefono, provincia) VALUES (1005, 'María', 'Sánchez', 149149, 'Málaga');

INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (1, 1001, "Matemáticas", 5.2);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (2, 1002, "Matemáticas", 9.0);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (3, 1003, "Matemáticas", 6.5);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (4, 1004, "Matemáticas", 8.0);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (5, 1005, "Matemáticas", 9.7);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (6, 1001, "Biología", 8.5);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (7, 1002, "Física", 4.0);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (8, 1003, "Química", 6.8);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (9, 1004, "Historia", 5.0);
INSERT INTO notas (codigo, codigoAlumno, asignatura, nota) VALUES (10, 1005, "Filosofía", 8.4);

