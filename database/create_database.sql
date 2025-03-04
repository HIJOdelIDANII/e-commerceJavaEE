
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;


CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100)
    );

CREATE TABLE IF NOT EXISTS produits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    description TEXT,
    prix DECIMAL(10, 2) NOT NULL,
    image VARCHAR(255)
    );


INSERT INTO users (username, password, email) VALUES
('admin', '$2a$10$ExampleHashedPassword1', 'admin@example.com');

INSERT INTO produits (nom, description, prix, image) VALUES
('wallet', 'High-quality leather wallet with multiple card slots.', 19.99, 'https://i.etsystatic.com/56342863/r/il/ca513c/6523973238/il_600x600.6523973238_d5z1.jpg'),
('wristwatch', 'Stainless steel wristwatch with a sleek design.', 29.99, 'https://sothebys-md.brightspotcdn.com/8b/b7/11d851544f6c9b0daed7cc426525/pf2240-ccscl-01.jpg'),
('chair', 'Ergonomic office chair with adjustable height and lumbar support.', 39.99, 'https://th.bing.com/th/id/OIP.AS0U7VS_75QAs6xYClsBowHaHF?rs=1&pid=ImgDetMain');
