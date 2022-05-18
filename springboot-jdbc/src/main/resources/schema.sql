create table PERSON
(
    ID         integer identity primary key,
    FIRST_NAME varchar(30),
    LAST_NAME  varchar(30),
    ADDRESS  varchar(30),
    EMAIL  varchar(30),
    PINCODE integer
);