create table tariffs
(
    id bigserial not null primary key,
    name varchar (40) not null,
    price_per_minute integer
);

alter table tariffs
    owner to sa;

create table locations
(
    id bigserial not null primary key,
    address varchar(40) not null,
    tariff_id integer not null references tariffs (id)
);

    alter table locations
        owner to sa;


create table stations
(
    id bigserial not null primary key,
    location_id integer not null references locations (id),
    longitude integer not null,
    latitude integer not null
);

    alter table stations
        owner to sa;

create table scooters
(
    id bigserial not null primary key,
    longitude integer not null,
    latitude integer not null,
    charge_level integer
);

    alter table scooters
        owner to sa;

create table slots
(
    id bigserial not null primary key,
    station_id bigint not null references stations (id),
    number integer not null,
    is_open boolean,
    scooter_id bigint not null references scooters (id)
);

    alter table slots
        owner to sa;

create table users
(
    id bigserial not null primary key,
    login varchar(40) not null,
    password varchar(40) not null,
    binding_id integer not null
);

    alter table users
        owner to sa;

create table actions
(
    id bigserial not null primary key,
    user_id bigint not null references users (id),
    slot_id bigint not null references slots (id),
    open boolean,
    sent boolean,
    time timestamp not null
);

    alter table actions
        owner to sa;

create table roles
(
    id bigserial not null primary key,
    name varchar (40) not null
 );

    alter table roles
        owner to sa;

create table user_roles
(
    id bigserial not null primary key,
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id)
);

    alter table user_roles
        owner to sa;

create table rentals
(
    id bigserial not null primary key,
    user_id bigint not null references users (id),
    scooter_id bigint not null references scooters (id),
    pick_up_slot_id bigint not null references slots (id),
    drop_off_slot_id bigint not null references slots (id),
    pick_up_time timestamp not null,
    drop_off_time timestamp not null
);

    alter table rentals
        owner to sa;

create table fines
(
    id bigserial not null primary key,
    rental_id bigint not null references rentals (id),
    time timestamp not null
);

    alter table fines
        owner to sa;

create table orders
(
    id bigserial not null primary key,
    order_number varchar (40) not null,
    md_order varchar (40) not null,
    amount integer not null,
    time timestamp not null,
    rental_id bigint not null references rentals (id)
);

    alter table orders
        owner to sa;

create table failed_payments
(
    id bigserial not null primary key,
    user_id bigint not null references users (id),
    order_id bigint not null references orders (id)
);

    alter table failed_payments
        owner to sa;
