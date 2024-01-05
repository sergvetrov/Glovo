CREATE TABLE IF NOT EXISTS products
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name varchar(255) NOT NULL,
    cost numeric NOT NULL,
    order_id bigint NOT NULL REFERENCES orders(id),
    PRIMARY KEY(id)
    );
CREATE TABLE IF NOT EXISTS orders
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    customer_name varchar(255) NOT NULL,
    PRIMARY KEY(id)
    );