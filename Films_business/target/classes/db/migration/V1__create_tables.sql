create table Director
(
    id         bigint      not null primary key auto_increment,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    birth_day  date        not null
);
create table Film
(
    id           bigint      not null primary key auto_increment,
    director_id  bigint     not null ,
    name         varchar(100) not null,
    release_date LONG       not null ,
    genre        varchar(20) not null,
    foreign key (director_id) references Director (id) on delete cascade
);

insert into Director(first_name, last_name, birth_day)
VALUES ('Quentin', 'Tarantino', '1963-03-27'),
       ('Stanley', 'Kubrick', '1928-06-26'),
       ('Akira', 'Kurosawa', '1910-03-23'),
       ('Clint', 'Eastwood', '1930-05-31'),
       ('Ingmar ', 'Bergman', '1918-06-14'),
       ('David ', 'Fincher', '1962-07-28'),
       ('One ', 'Oner', '2006-06-06'),
       ('Without ', 'Filmer', '1999-09-09');


insert into Film(director_id, name, release_date, genre)
VALUES (1, 'Django Unchained', 2012, 'Action'),
       (1, 'Reservoir Dogs', 1992, 'Action'),
       (1, 'Kill Bill: The Whole Bloody Affair', 2012, 'Thriller/Action'),
       (1, 'KILL BILL', 2003, 'Action'),
       (1, 'Pulp Fiction', 1994, 'Comedy'),
       (2, 'A Space Odyssey', 2001, 'Fantasy'),
       (2, 'The Shining', 1980, 'Mystery'),
       (2, 'A Clockwork Orange', 1971, 'Fantasy'),
       (2, 'Dr. Strangelove', 1964, 'Fantasy'),
       (3, 'Seven Samurai', 1954, 'Drama'),
       (3, 'Rashomon', 1950, 'Drama'),
       (3, 'Ran', 1985, 'Drama'),
       (4, 'Unforgiven', 1992, 'Drama'),
       (4, 'Gran Torino', 2008, 'Drama'),
       (4, 'The Mule', 2018, 'Drama'),
       (4, 'Million Dollar Baby', 2004, 'Drama'),
       (5, 'Cries and Whispers', 1972, 'Drama'),
       (5, 'Persona', 1966, 'Drama'),
       (5, 'Wild Strawberries', 1957, 'Drama'),
       (6, 'Fight Club', 1999, 'Drama'),
       (6, 'Gone Girl', 2014, 'Drama'),
       (6, 'Seven', 1995, 'Drama'),
       (6, 'The Curious Case of Benjamin Button', 2008, 'Drama'),
       (6, 'Hitchcock/Truffaut', 2015, 'Documentary '),
       (7, 'My dear only one', 2020, 'Drama');