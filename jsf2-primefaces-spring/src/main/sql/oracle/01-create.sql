--
-- (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
-- Source code generated by Celerio, a Jaxio product
-- Want to purchase Celerio ? email us at info@jaxio.com
-- Follow us on twitter: @springfuse
-- Documentation: http://www.jaxio.com/documentation/celerio/
-- Template pack-jsf2-spring-conversation:bootstrap/generic/01-create-oracle.boot.vm.sql
--

-- DROP ALL OBJECTS;
DROP SEQUENCE hibernate_sequence;
DROP TABLE ACCOUNT_ROLE;
DROP TABLE ROLE;
DROP TABLE DOCUMENT;
DROP TABLE BOOK;
DROP TABLE ACCOUNT;
DROP TABLE ADDRESS;
DROP TABLE MORE_TYPES_DEMO;
DROP TABLE SAVED_SEARCH;
DROP TABLE LEGACY;

CREATE SEQUENCE hibernate_sequence START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE ADDRESS (
    id                       number(10) not null,
    street_name              varchar2(100),
    city                     varchar2(100) not null,
    version                  number(10) default 0,
    primary key (id)
);

CREATE TABLE ACCOUNT (
    id                       char(36) not null,
    login                    varchar2(100) not null,
    password                 varchar2(100) not null,
    email                    varchar2(100) not null,
    is_enabled               number(1,0) not null,
    civility                 char(2),
    first_name               varchar2(100),
    last_name                varchar2(100),
    birth_date               timestamp,
    description              varchar2(255),
    address_id               number(10),
    creation_date            timestamp,
    creation_author          varchar2(200),
    last_modification_date   timestamp,
    last_modification_author varchar2(200),
    version                  number(10) default 0,
    constraint account_unique_1 unique (login),
    constraint account_unique_2 unique (email),
    constraint account_fk_1 foreign key (address_id) references ADDRESS,
    primary key (id)
);

CREATE TABLE ROLE (
    id                      number(10) not null,
    role_name                varchar2(100) not null,
    constraint role_unique_1 unique (role_name),
    primary key (id)
);

CREATE TABLE ACCOUNT_ROLE (
    account_id              char(36) not null,
    role_id                 number(10) not null,
    constraint account_role_fk_1 foreign key (account_id) references ACCOUNT,
    constraint account_role_fk_2 foreign key (role_id) references ROLE,
    primary key (account_id, role_id)
);

CREATE TABLE DOCUMENT (
    id                          char(36)        not null,
    account_id                  char(36)        not null,
    document_binary             blob,
    document_file_name          varchar2(100)   not null,
    document_content_type       varchar2(100)   not null,
    document_size               number(10)      not null,
    version                     number(10)      default 0,
    constraint document_fk_1 foreign key (account_id) references ACCOUNT,
    primary key (id)
);

CREATE TABLE BOOK (
    id                          number(10)    not null,
    account_id                  char(36),
    title                       varchar2(100) not null,
    number_of_pages             number(10)    not null,
    version                     number(10)    default 0,
    constraint book_fk_1 foreign key (account_id) references ACCOUNT,
    primary key (id)
);

CREATE TABLE MORE_TYPES_DEMO (
    id                            number(10) not null,
    number_int                    number(10),
    number_long                   number(11),
    number_double                 float,
    number_float                  real,
    number_big_integer            number(20),
    number_big_decimal            DECIMAL(20, 2),
    date_java_temporal_date       date,
    date_java_temporal_timestamp  timestamp,
    date_joda                     date,
    date_time_joda                timestamp,
    version                       number(10) default 0,
    primary key (id)
);

CREATE TABLE SAVED_SEARCH (
    id                            number(10) not null,
    name                          varchar2(128) not null,
    form_classname                varchar2(256) not null,
    form_content                  blob,
    account_id                    char(36) not null,

    constraint saved_search_fk_1 foreign key (account_id) references ACCOUNT,
    primary key (id)
);

CREATE TABLE LEGACY (
    name         varchar2(16) not null,
    code         varchar2(8) not null,
    dept         number(10) not null,
    extra_info   varchar2(100) not null,
    primary key (name, code, dept)
);

INSERT INTO ADDRESS (id, street_name, city) values(1, 'Avenue des champs Elysées', 'Paris');
INSERT INTO ADDRESS (id, street_name, city) values(2, 'Park avenue', 'New-York');
INSERT INTO ADDRESS (id, street_name, city) values(3, 'Tochomae', 'Tokyo');
INSERT INTO ADDRESS (id, street_name, city) values(4, 'California Street', 'San Francisco');
--
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000001', 'admin', 'admin', 'admin@example.com', 1, 1);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000002', 'user',  'user',  'user@example.com', 1, 2);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000003', 'demo',  'demo',  'demo@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000004', 'user04',  'user04',  'user04@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000005', 'user05',  'user05',  'user05@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000006', 'user06',  'user06',  'user06@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000007', 'user07',  'user07',  'user07@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000008', 'user08',  'user08',  'user08@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000009', 'user09',  'user09',  'user09@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000010', 'user10',  'user10',  'user10@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000011', 'user11',  'user11',  'user11@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000012', 'user12',  'user12',  'user12@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000013', 'user13',  'user13',  'user13@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000014', 'user14',  'user14',  'user14@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000015', 'user15',  'user15',  'user15@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000016', 'user16',  'user16',  'user16@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000017', 'user17',  'user17',  'user17@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000018', 'user18',  'user18',  'user18@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000019', 'user19',  'user19',  'user19@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000020', 'user20',  'user20',  'user20@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000021', 'user21',  'user21',  'user21@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000022', 'user22',  'user22',  'user22@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000023', 'user23',  'user23',  'user23@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000024', 'user24',  'user24',  'user24@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000025', 'user25',  'user25',  'user25@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000026', 'user26',  'user26',  'user26@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000027', 'user27',  'user27',  'user27@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000028', 'user28',  'user28',  'user28@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000029', 'user29',  'user29',  'user29@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000030', 'user30',  'user30',  'user30@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000031', 'user31',  'user31',  'user31@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000032', 'user32',  'user32',  'user32@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000033', 'user33',  'user33',  'user33@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000034', 'user34',  'user34',  'user34@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000035', 'user35',  'user35',  'user35@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000036', 'user36',  'user36',  'user36@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000037', 'user37',  'user37',  'user37@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000038', 'user38',  'user38',  'user38@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000039', 'user39',  'user39',  'user39@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000040', 'user40',  'user40',  'user40@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000041', 'user41',  'user41',  'user41@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000042', 'user42',  'user42',  'user42@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000043', 'user43',  'user43',  'user43@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000044', 'user44',  'user44',  'user44@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000045', 'user45',  'user45',  'user45@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000046', 'user46',  'user46',  'user46@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000047', 'user47',  'user47',  'user47@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000048', 'user48',  'user48',  'user48@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000049', 'user49',  'user49',  'user49@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000050', 'user50',  'user50',  'user50@example.com', 1, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, address_id) VALUES ('00000000000000000000000000000000051', 'disabled',  'disabled',  'disabled@example.com', 0, 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, civility, address_id) VALUES ('00000000000000000000000000000000052', 'homer',  'homer',  'homer@example.com', 1, 'MR', 3);
INSERT INTO ACCOUNT (id, login, password, email, is_enabled, civility, address_id) VALUES ('00000000000000000000000000000000053', 'maggy',  'maggy',  'maggy@example.com', 1, 'MS', 3);

INSERT INTO ROLE (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO ROLE (id, role_name) VALUES (3, 'ROLE_MONITORING');

INSERT INTO ACCOUNT_ROLE (account_id, role_id) VALUES ('00000000000000000000000000000000001', 1);
INSERT INTO ACCOUNT_ROLE (account_id, role_id) VALUES ('00000000000000000000000000000000001', 2);
INSERT INTO ACCOUNT_ROLE (account_id, role_id) VALUES ('00000000000000000000000000000000001', 3);
INSERT INTO ACCOUNT_ROLE (account_id, role_id) VALUES ('00000000000000000000000000000000002', 2);
INSERT INTO ACCOUNT_ROLE (account_id, role_id) VALUES ('00000000000000000000000000000000003', 2);

INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (1, '00000000000000000000000000000000001', 'Prime Faces User Guide', 444);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (2, '00000000000000000000000000000000001', 'Spring Web Flow Reference Guide', 108);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (3, '00000000000000000000000000000000001', 'Spring 3.0 Reference Documentation', 770);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (4, '00000000000000000000000000000000001', 'Java Persistence with Hibernate', 880);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (5, '00000000000000000000000000000000001', 'Effective Java', 350);

INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (6, '00000000000000000000000000000000002', 'How to create a web app', 100);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (7, '00000000000000000000000000000000002', 'How to deal with large projects', 544);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (8, '00000000000000000000000000000000002', 'How to speed up project dev?', 453);

INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (9, '00000000000000000000000000000000003', 'Complete history of the universe', 9809900);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (10, '00000000000000000000000000000000003', 'The Solar System', 800);
INSERT INTO BOOK(id, account_id, title, number_of_pages) VALUES (11, '00000000000000000000000000000000003', 'The Rolling Stones', 1800);

INSERT INTO LEGACY (name, code, dept, extra_info) VALUES ('name1', 'code1', 1, 'extra1');
INSERT INTO LEGACY (name, code, dept, extra_info) VALUES ('name2', 'code2', 2, 'extra2');
INSERT INTO LEGACY (name, code, dept, extra_info) VALUES ('name3', 'code3', 3, 'extra3');
INSERT INTO LEGACY (name, code, dept, extra_info) VALUES ('name4', 'code4', 4, 'extra4');
