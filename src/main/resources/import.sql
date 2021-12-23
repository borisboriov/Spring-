DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int, rate int,  PRIMARY KEY (id));
INSERT INTO products (title, cost, rate) VALUES ('Milk', 80, 5), ('Bread', 20, 10), ('Coffee', 100, 20);
