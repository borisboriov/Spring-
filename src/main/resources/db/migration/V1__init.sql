create table if not exists products (id bigserial primary key, title varchar(255), cost int);

insert into products (title, cost)
values
('Milk', 100),
('Bread', 90),
('Sugar', 80),
('Meat', 70),
('Fresh', 60),
('Salt', 50),
('Butter', 40),
('Salmon', 30),
('Tuna', 20),
('Pepper', 10),
('Salad', 200),
('Bree', 300),
('Cheese', 400),
('Vine', 500),
('Beer', 177);