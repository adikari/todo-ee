create table APPUSER (
    ID SERIAL PRIMARY KEY,
    FIRSTNAME varchar(100) not null,
    LASTNAME varchar(100) not null,
    EMAIL varchar(100) not null,
    PASSWORD varchar(100) not null,
    CATEGORY varchar(100) not null
);
