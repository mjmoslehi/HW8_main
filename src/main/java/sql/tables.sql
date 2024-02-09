create table if not exists admin
(
    id       serial primary key,
    name     varchar,
    username varchar,
    password varchar
);