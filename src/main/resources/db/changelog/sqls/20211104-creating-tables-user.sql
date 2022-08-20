CREATE TABLE application_user (
    id            int8 not null,
    email         varchar(255) null,
    name_user          varchar(255) not null,
    password      varchar(255) not null,
    profile       int4 null,
    create_date   timestamp not null,
    update_date   timestamp,
    active        boolean,
    constraint user_pkey primary key (id)
);

CREATE SEQUENCE application_user_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

ALTER TABLE application_user ALTER COLUMN id SET DEFAULT nextval('application_user_id_seq'::regclass);

INSERT INTO application_user (email, name_user, password, profile, create_date, active) VALUES('desafio@email.com', 'Agence', '$2a$10$dp6mVgR.xDSfScuyt6YzxuW9x84Et0RZ2f83vL0nggP5hO7379ac6', 1, '2022-08-20 00:00:01.000000', true);
