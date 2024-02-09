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

create table if not exists product
(
    id          serial primary key,
    name        varchar,
    cost        integer,
    number      integer,
    category_id integer,
    foreign key (category_id) references category (id)
);

create table if not exists cart
(
    id            serial primary key,
    user_id       integer,
    product_id    integer,
    count_product integer,
    foreign key (user_id) references users (id),
    foreign key (product_id) references product (id)
);