create table tariffs
(
    id               bigint      not null primary key,
    name             varchar(40) not null,
    price_per_minute integer
);

create sequence tariffs_id_generator
    increment by 1;

alter sequence tariffs_id_generator
    owner to sa;

alter table tariffs
    owner to sa;

create table locations
(
    id        bigint      not null
        constraint locations_pkey
            primary key,
    address   varchar(40) not null,
    tariff_id integer     not null references tariffs (id)
);

create sequence locations_id_generator
    increment by 1;

alter sequence locations_id_generator
    owner to sa;

alter table locations
    owner to sa;


create table stations
(
    id          bigint  not null
        constraint stations_pkey primary key,
    location_id integer not null references locations (id),
    longitude   integer not null,
    latitude    integer not null
);

create sequence stations_id_generator
    increment by 1;

alter sequence stations_id_generator
    owner to sa;

alter table stations
    owner to sa;

create table scooters
(
    id           bigint  not null
        constraint scooters_pkey primary key,
    longitude    integer not null,
    latitude     integer not null,
    charge_level integer
);

create sequence scooters_id_generator
    increment by 1;

alter sequence scooters_id_generator
    owner to sa;

alter table scooters
    owner to sa;

create table slots
(
    id         bigint  not null
        constraint slots_pkey primary key,
    station_id bigint  not null references stations (id),
    number     integer not null,
    is_open    boolean,
    scooter_id bigint  not null references scooters (id)
);

create sequence slots_id_generator
    increment by 1;

alter sequence slots_id_generator
    owner to sa;

alter table slots
    owner to sa;

create table users
(
    id         bigint      not null
        constraint users_pkey primary key,
    login      varchar(40) not null,
    password   varchar(40) not null,
    binding_id integer     not null
);

create sequence users_id_generator
    increment by 1;

alter sequence users_id_generator
    owner to sa;

alter table users
    owner to sa;

create table actions
(
    id      bigint    not null
        constraint actions_pkey primary key,
    user_id bigint    not null references users (id),
    slot_id bigint    not null references slots (id),
    open    boolean,
    sent    boolean,
    time    timestamp not null
);

create sequence actions_id_generator
    increment by 1;

alter sequence actions_id_generator
    owner to sa;

alter table actions
    owner to sa;

create table roles
(
    id   bigint      not null
        constraint roles_pkey primary key,
    name varchar(40) not null
);

create sequence roles_id_generator
    increment by 1;

alter sequence roles_id_generator
    owner to sa;

alter table roles
    owner to sa;

create table user_roles
(
    id      bigint not null
        constraint user_roles_pkey primary key,
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id)
);

create sequence user_roles_id_generator
    increment by 1;

alter sequence user_roles_id_generator
    owner to sa;

alter table user_roles
    owner to sa;

create table rentals
(
    id               bigint    not null
        constraint rentals_pkey primary key,
    user_id          bigint    not null references users (id),
    scooter_id       bigint    not null references scooters (id),
    pick_up_slot_id  bigint    not null references slots (id),
    drop_off_slot_id bigint    not null references slots (id),
    pick_up_time     timestamp not null,
    drop_off_time    timestamp not null
);

create sequence rentals_id_generator
    increment by 1;

alter sequence rentals_id_generator
    owner to sa;

alter table rentals
    owner to sa;

create table fines
(
    id        bigint    not null
        constraint fines_pkey primary key,
    rental_id bigint    not null references rentals (id),
    time      timestamp not null
);

create sequence fines_id_generator
    increment by 1;

alter sequence fines_id_generator
    owner to sa;

alter table fines
    owner to sa;

create table orders
(
    id           bigint      not null
        constraint orders_pkey primary key,
    order_number varchar(40) not null,
    md_order     varchar(40) not null,
    amount       integer     not null,
    time         timestamp   not null,
    rental_id    bigint      not null references rentals (id)
);

create sequence orders_id_generator
    increment by 1;

alter sequence orders_id_generator
    owner to sa;

alter table orders
    owner to sa;

create table failed_payments
(
    id       bigint not null
        constraint failed_payments_pkey primary key,
    user_id  bigint not null references users (id),
    order_id bigint not null references orders (id)
);

create sequence filed_payments_id_generator
    increment by 1;

alter sequence filed_payments_id_generator
    owner to sa;

alter table failed_payments
    owner to sa;

-- [ScooterSharing-3]
alter table scooters
    alter column latitude type double precision;
alter table scooters
    alter column longitude type double precision;

