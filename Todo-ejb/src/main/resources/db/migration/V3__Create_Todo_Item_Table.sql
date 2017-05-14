create table TODOITEM (
    ID int not null PRIMARY KEY,
    TITLE varchar(100) not null,
    ISCOMPLETE boolean not null,
    TODOLISTID int not null REFERENCES TODOLIST(ID)
);
