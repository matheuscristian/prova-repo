insert into
    bibliotecario (nome, email)
values (
        'Matheus Cristian',
        'matheuscristinrg@gmail.com'
    ),
    (
        'Roseane Cristine',
        'roseanecrcosta@gmail.com'
    );

insert into
    livro (
        bibliotecario,
        autor,
        titulo,
        genero,
        created_date
    )
values (
        2,
        'Confúcio',
        'Os analectos de Confúcio',
        'Filosofia',
        '2025-06-12'
    ),
    (
        1,
        'Sun Tzu',
        'A arte da Guerra',
        'Filosofia, Auto-Ajuda',
        '2025-06-12'
    );

SELECT * FROM bibliotecario;

SELECT * FROM livro;
