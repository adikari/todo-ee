create table APPUSER (
    ID int not null PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    FIRSTNAME varchar(100) not null,
    LASTNAME varchar(100) not null,
    EMAIL varchar(100) not null,
    PASSWORD varchar(100) not null,
    CATEGORY varchar(100) not null
);