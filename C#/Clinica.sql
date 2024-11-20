SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE citas;
TRUNCATE TABLE mascotas;
TRUNCATE TABLE clientes;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO clientes VALUES (1001, '77227722M', 'Ana', 'Pérez Espinosa', 661122, 'anap99@gmail.com', 'Huelva', 'Huelva', 'C/ Puerto', 21002, '...');
INSERT INTO clientes VALUES (1002, '44994499M', 'Luis', 'Sánchez Ibáñez', 789789, 'sanchezluis@gmail.com', 'Sevilla', 'Sevilla', 'C/ Diciembre', 28003, '...');
INSERT INTO clientes VALUES (1003, '11661166M', 'Juan Carlos', 'García Pérez', 743743, 'jcarlosgarcia@gmail.com', 'Málaga', 'Estepona', 'C/ Fuentepiedra', 29182, '...');

INSERT INTO mascotas VALUES (10001, 1001, 'Pepe', 'Perro', 'Labrador', '2020-12-05', 'M', '...');
INSERT INTO mascotas VALUES (10002, 1001, 'Juanjo', 'Perro', 'Labrador', '2018-11-08', 'M', '...');
INSERT INTO mascotas VALUES (10003, 1002, 'Nina', 'Gato', 'Cartujo', '2017-05-08', 'F', '...');
INSERT INTO mascotas VALUES (10004, 1003, 'Mango', 'Loro', 'Guacamayo escarlata', '2007-02-18', 'M', '...');

INSERT INTO citas VALUES (849554, 1001, 10002, '2024-11-07 17:30', 'Vacuna', '...');
INSERT INTO citas VALUES (135274, 1003, 10004, '2024-11-07 19:00', 'Chequeo', '...');

