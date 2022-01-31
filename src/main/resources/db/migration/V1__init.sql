create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);


create table authorities (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);


CREATE TABLE users_authorities (
  user_id               bigint not null,
  authority_id          int not null,
  primary key (user_id, authority_id),
  foreign key (user_id) references users (id),
  foreign key (authority_id) references authorities (id)
);


insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');


insert into authorities (name)
values
('endpoint_access');

insert into users_authorities (user_id, authority_id)
values
(1, 1);

