DROP TABLE contrato;
DROP TABLE cliente;


CREATE TABLE cliente
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    cpf  BIGINT      NOT NULL,
    nome VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_cliente_cpf UNIQUE (cpf)
);


CREATE TABLE contrato
(
    id                 BIGINT NOT NULL AUTO_INCREMENT,
    redacao            TEXT   NOT NULL CHECK (LENGTH(redacao) <= 100000),
    ultima_atualizacao DATE   NOT NULL,
    cliente_id         BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id)
        REFERENCES cliente (id)
);
