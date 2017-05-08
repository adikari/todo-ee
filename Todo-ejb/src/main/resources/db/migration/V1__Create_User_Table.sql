create table APPUSER (
    ID int not null PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    EMAIL varchar(100) not null,
    PASSWORD varchar(100) not null
);