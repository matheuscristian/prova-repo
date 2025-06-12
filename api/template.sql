CREATE TABLE bibliotecario (
    id SERIAL PRIMARY KEY NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE livro (
    id SERIAL PRIMARY KEY NOT NULL,
    bibliotecario SERIAL NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL DEFAULT 'Disponível',
    created_date DATE NOT NULL,
    Foreign Key (bibliotecario) REFERENCES bibliotecario (id)
);
