create table TODOLIST (
    ID int not null PRIMARY KEY,
    TITLE varchar(100) not null,
    APPUSER int not null REFERENCES APPUSER(ID)
);
