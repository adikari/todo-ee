create table TODOLIST (
    ID SERIAL PRIMARY KEY,
    TITLE varchar(100) not null,
    APPUSER int not null REFERENCES APPUSER(ID)
);
