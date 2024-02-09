create table if not exists admin
(
    id       serial primary key,
    name     varchar,
    username varchar,
    password varchar
);

create table if not exists users
(
    id        serial primary key,
    firstname varchar,
    lastname  varchar,
    username  varchar,
    password  varchar
);

create table if not exists category
(
    id   serial primary key,
    name varchar
);