create table TODOLIST (
    ID int not null PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    TITLE varchar(100) not null
);