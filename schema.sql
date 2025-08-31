CREATE DATABASE paokentin;

USE paokentin;

CREATE TABLE pao (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    tempo_preparo INT NOT NULL,
    cor VARCHAR(7)
);

CREATE TABLE fornada (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    data_hora_inicio BIGINT NOT NULL,
    cod_pao INT NOT NULL,
    FOREIGN KEY (cod_pao) REFERENCES pao(codigo)
);
