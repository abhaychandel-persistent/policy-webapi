
CREATE SEQUENCE customer_id_seq;

CREATE TABLE customer
(
    id       SERIAL,
    first_name    varchar NOT NULL,
    last_name     varchar NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (id)
);