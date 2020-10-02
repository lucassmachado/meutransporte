use meutransporte;

CREATE TABLE linha (
    id integer not null auto_increment,
    codigo varchar(10),
    nome varchar(200),
    PRIMARY KEY (id)
);

CREATE TABLE itinerario (
    id integer not null auto_increment,
    linha varchar(10),
    sentido varchar(200),
    numero integer(8),
    tipo varchar(200),
    nome varchar(200),
    logradouro varchar(200),
    PRIMARY KEY (id)
);