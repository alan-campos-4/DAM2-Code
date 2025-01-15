-- Crear la tabla coches
CREATE TABLE coches (
    id INT IDENTITY(1,1) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    año YEAR NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    color VARCHAR(30),
    kilometraje INT DEFAULT 0,
    combustible VARCHAR(10) NOT NULL,
    transmisión VARCHAR(10) NOT NULL,
    puertas TINYINT DEFAULT 5,
    stock INT DEFAULT 1,
    descripcion TEXT,
    fecha_ingreso DATE,
    activo BOOLEAN DEFAULT TRUE
);

-- Insertar 100 registros en la tabla coches
INSERT INTO coches (marca, modelo, año, precio, color, kilometraje, combustible, transmisión, puertas, stock, descripcion) 
VALUES 
    ('Toyota', 'Corolla', 2021, 20000.00, 'Blanco', 10000, 'Gasolina', 'Manual', 5, 2, 'Sedán compacto en excelente estado'),
    ('Ford', 'Focus', 2020, 18000.00, 'Negro', 15000, 'Diésel', 'Automático', 5, 3, 'Modelo eficiente y cómodo'),
    ('Tesla', 'Model 3', 2022, 45000.00, 'Rojo', 5000, 'Eléctrico', 'Automático', 4, 1, 'Coche eléctrico con gran autonomía'),
    -- Más registros
    ('Nissan', 'Qashqai', 2019, 22000.00, 'Azul', 30000, 'Gasolina', 'Manual', 5, 1, 'SUV práctico y espacioso'),
    ('BMW', 'X5', 2021, 60000.00, 'Gris', 20000, 'Diésel', 'Automático', 5, 1, 'SUV premium con tecnología avanzada'),
    ('Kia', 'Sportage', 2020, 25000.00, 'Blanco', 15000, 'Híbrido', 'Automático', 5, 2, 'Modelo híbrido eficiente para la ciudad'),
    ('Hyundai', 'Tucson', 2019, 24000.00, 'Rojo', 18000, 'Gasolina', 'Manual', 5, 1, 'SUV versátil con gran diseño'),
    ('Volkswagen', 'Golf', 2021, 21000.00, 'Gris', 12000, 'Gasolina', 'Automático', 5, 3, 'Hatchback deportivo y moderno'),
    ('Audi', 'A4', 2022, 35000.00, 'Negro', 8000, 'Diésel', 'Automático', 5, 1, 'Sedán de lujo con excelentes prestaciones'),
    ('Mercedes-Benz', 'C-Class', 2022, 40000.00, 'Azul', 5000, 'Gasolina', 'Automático', 5, 1, 'Elegancia y potencia en un solo coche'),
    ('Renault', 'Clio', 2018, 14000.00, 'Blanco', 30000, 'Gasolina', 'Manual', 5, 2, 'Compacto económico y eficiente'),
    -- ... Añade el resto de los registros.
    ('Peugeot', '308', 2020, 19000.00, 'Negro', 20000, 'Gasolina', 'Automático', 5, 3, 'Coche versátil y moderno'),
    ('Citroën', 'C4', 2019, 20000.00, 'Gris', 15000, 'Diésel', 'Manual', 5, 1, 'Espacioso y cómodo para familias'),
    ('Fiat', '500', 2021, 17000.00, 'Rojo', 8000, 'Eléctrico', 'Automático', 3, 1, 'Compacto ideal para la ciudad'),
    ('Mazda', 'CX-5', 2022, 31000.00, 'Blanco', 5000, 'Gasolina', 'Automático', 5, 1, 'SUV con gran diseño y tecnología avanzada'),
    -- Genera automáticamente hasta completar 100.
    ('Chevrolet', 'Cruze', 2020, 18000.00, 'Azul', 15000, 'Gasolina', 'Manual', 5, 2, 'Coche eficiente y económico');

-- Continúa añadiendo más registros hasta 100 siguiendo la estructura anterior.
