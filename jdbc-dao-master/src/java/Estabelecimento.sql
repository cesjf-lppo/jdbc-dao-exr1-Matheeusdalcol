CREATE TABLE anuncio
(
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	nome VARCHAR(250) NOT NULL,
	descricao VARCHAR(32672) NOT NULL,
	preco FLOAT NOT NULL DEFAULT 0,
        PRIMARY KEY(id)
);
