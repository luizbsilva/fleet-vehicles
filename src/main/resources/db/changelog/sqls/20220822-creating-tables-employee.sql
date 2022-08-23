CREATE TABLE employee (
    id_employee            int8 not null,
    employee_name          varchar(255) null,
    email                  varchar(255) null,
    employee_registration  varchar(255) null,
    id_application_user    int8 not null,
    create_date             timestamp not null,
    update_date             timestamp,
    active                  boolean,
    constraint employee_pkey primary key (id_employee),
    CONSTRAINT fk_employee_user FOREIGN KEY (id_application_user)
        REFERENCES application_user (id) MATCH SIMPLE
);

CREATE SEQUENCE employee_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

ALTER TABLE employee ALTER COLUMN id_employee SET DEFAULT nextval('employee_id_seq'::regclass);

INSERT INTO employee (employee_name, employee_registration, email, id_application_user, create_date, active) VALUES('Admin', '123987','admin@agence.com', 1, '2022-08-20 00:00:01.000000', true);
