
CREATE SEQUENCE policy_id_seq;
ALTER SEQUENCE policy_id_seq RESTART WITH 11004;


CREATE TABLE policy
(
    id       SERIAL,
    policy_no       varchar NOT NULL,
    policy_name     varchar NOT NULL,
    description     varchar NOT NULL,
    is_active       boolean NOT NULL,
    type            varchar NOT NULL,
    CONSTRAINT policy_pk PRIMARY KEY (id)
);