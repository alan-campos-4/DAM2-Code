SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE citas;
TRUNCATE TABLE mascotas;
TRUNCATE TABLE clientes;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO clientes VALUES (1001, '77227722M', 'Ana', 'Pérez Espinosa', 661122, 'anap99@gmail.com', 'Huelva', 'Huelva', 'C/ Puerto', 21002, '...');
INSERT INTO clientes VALUES (1002, '44994499M', 'Luis', 'Sánchez Ibáñez', 789789, 'sanchezluis@gmail.com', 'Sevilla', 'Sevilla', 'C/ Diciembre', 28003, '...');
INSERT INTO clientes VALUES (1003, '11661166M', 'Juan Carlos', 'García Pérez', 743743, 'jcarlosgarcia@gmail.com', 'Málaga', 'Estepona', 'C/ Fuentepiedra', 29182, '...');
INSERT INTO clientes VALUES (1004, '99339933M', 'Marco', 'Polo Ruiz', 569569, 'mpolo87@gmail.com', 'Málaga', 'Marbella', 'C/ Alemania', 29165, '...');
INSERT INTO clientes VALUES (1005, '22662266M', 'Erick', 'Ruiz García', 459459, 'erickrugar81@gmail.com', 'Huelva', 'Trigueros', 'C/ Alemania', 28205, '...');
INSERT INTO clientes VALUES (1006, '88778877M', 'Carlos', 'Ruiz Peña', 126126, 'carruiz11@gmail.com', 'Granada', 'Granada', 'C/ Alemania', 24005, '...');
INSERT INTO clientes VALUES (1007, '55225522M', 'Marco', 'Rodríguez Santos', 782782, 'mrodsantos@gmail.com', 'Granada', 'Molina', 'C/ Alemania', 24035, '...');

INSERT INTO mascotas VALUES (10001, 1001, 'Perro', 'Labrador', 'Sancho', '2021-12-05', 'M', '...');
INSERT INTO mascotas VALUES (10002, 1001, 'Perro', 'Labrador', 'Quijote', '2021-12-05', 'M', '...');
INSERT INTO mascotas VALUES (10003, 1002, 'Perro', 'Golden Retriever', 'Lola', '2021-03-15', 'F', '...');
INSERT INTO mascotas VALUES (10004, 1003, 'Perro', 'Boxer', 'Rocky', '2019-11-08', 'M', '...');
INSERT INTO mascotas VALUES (10005, 1004, 'Gato', 'Cartujo', 'Nana', '2016-05-01', 'F', '...');
INSERT INTO mascotas VALUES (10006, 1005, 'Loro', 'Guacamayo escarlata', 'Mango', '2007-02-13', 'M', '...');
INSERT INTO mascotas VALUES (10007, 1006, 'Gato', 'Persa', 'Michi', '2017-02-15', 'F', '...');
INSERT INTO mascotas VALUES (10008, 1007, 'Gato', 'Pardo', 'Nino', '2022-08-31', 'M', '...');

INSERT INTO citas VALUES (849554, 1001, 10002, '2025-01-17', '17:30', 'Chequeo', '...');
INSERT INTO citas VALUES (135274, 1002, 10003, '2025-01-28', '19:00', 'Vacuna', '...');
INSERT INTO citas VALUES (948951, 1002, 10003, '2025-02-11', '18:00', 'Peluquería', '...');
INSERT INTO citas VALUES (765213, 1003, 10004, '2025-02-13', '16:30', 'Chequeo', '...');
INSERT INTO citas VALUES (745462, 1004, 10006, '2025-02-15', '20:30', 'Vacuna', '...');

