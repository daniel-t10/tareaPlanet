CREATE TABLE planet (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    radius_km INT,
    mass_1e24kg DECIMAL(10,3),
    has_rings BOOLEAN
);

CREATE TABLE dog_breed (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    origin VARCHAR(100),
    size VARCHAR(20),
    life_span_years INT
);

CREATE TABLE cat_breed (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    origin VARCHAR(100),
    coat VARCHAR(50),
    life_span_years INT
);