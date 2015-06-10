drop table purchaseInfo;
create table purchaseInfo (
  id serial primary key,
  name text,
  price int,
  buyingDate date,
  status text
);