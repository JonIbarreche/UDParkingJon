DROP SCHEMA parking;
CREATE DATABASE parking;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON parking.* TO 'spq'@'localhost';