-- create table person (
--   id integer not null,
--   name varchar(20) not null,
--   location varchar(20),
--   birth_date timestamp,
--   primary key(id)
-- );

insert into person (id, NAME, LOCATION, BIRTH_DATE)
  values (1001, 'Ranga', 'Hyder', sysdate());
insert into person (id, NAME, LOCATION, BIRTH_DATE)
  values (1002, 'John', 'New York', sysdate());
insert into person (id, NAME, LOCATION, BIRTH_DATE)
  values (1003, 'Pieter', 'Amsterdam', sysdate());