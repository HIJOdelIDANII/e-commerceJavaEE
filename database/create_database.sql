CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS articles (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        titre VARCHAR(100) NOT NULL,
    description TEXT,
    prix DECIMAL(10, 2) NOT NULL
    );


INSERT INTO users (username, password, email) VALUES
                                                  ('admin', 'admin123', 'admin@example.com'),
                                                  ('john', 'pass123', 'john@example.com');

INSERT INTO articles (titre, description, prix) VALUES
                                                    ('Clavier mécanique', 'Un clavier RGB pour gamer.', 79.99),
                                                    ('Écran 24 pouces', 'Écran HD avec port HDMI.', 129.99),
                                                    ('Souris sans fil', 'Souris ergonomique Bluetooth.', 29.50);
