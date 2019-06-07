create database BABEL;
USE BABEL;  
CREATE TABLE autor(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    apellidos varchar(255),
    primary key(id)
);
CREATE TABLE libro(
    isbn varchar(13) not null  primary key,
    titulo varchar(255),
    volumen int,
    autor_id int,
    foreign key(autor_id) references Autor (id)
);
CREATE TABLE localizacion(
    isbn varchar(13) not null primary key,
    sala varchar(3),
    librero varchar(3),
    estante varchar(3),
    posicion varchar(3),
    foreign key(isbn) references libro (isbn)
);
