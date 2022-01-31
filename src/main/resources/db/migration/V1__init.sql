create table if not exists products (id bigserial primary key, title varchar(255), cost int, rate int);

insert into products (title, cost, rate)
values
    ('Milk', 100, 5),
    ('Bread', 90, 10),
    ('Sugar', 80, 15),
    ('Meat', 70, 20),
    ('Fresh', 60, 30),
    ('Salt', 50, 40),
    ('Butter', 40, 1),
    ('Salmon', 30, 2),
    ('Tuna', 20, 3),
    ('Pepper', 10, 4),
    ('Salad', 200, 44),
    ('Bree', 300, 34),
    ('Cheese', 400, 90),
    ('Vine', 500, 77),
    ('Beer', 177, 24);