create schema if not exists orders collate latin1_swedish_ci;

create table if not exists some_item
(
    id           int auto_increment
        primary key,
    name         varchar(255) null,
    price_by_one double       not null
);

INSERT INTO orders.some_item (name, price_by_one) VALUES ('tomatoes', 35.3);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('tomatoes', 37.65);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('tomatoes', 29.99);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('potatoes', 15.2);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('potatoes', 14.98);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('apples', 54.99);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('apples', 59.99);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('berries', 99.99);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('berries', 85.76);
INSERT INTO orders.some_item (name, price_by_one) VALUES ('berries', 88.3);

create table if not exists my_order
(
    id        int auto_increment
        primary key,
    name_item varchar(255) null,
    price     double       not null,
    quantity  int          not null,
    valid     varchar(255) null,
    item_id   int          null,
    constraint FKlh1eh0ge43h3x9ha11c6sdlfj
        foreign key (item_id) references some_item (id)
);
