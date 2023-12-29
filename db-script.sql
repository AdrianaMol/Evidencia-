create database users;
use users;

create table user (
	id int not null auto_increment primary key,
    nombre varchar(100) not null,
    email varchar(50) not null,
    contrasena varchar(50) not null
);