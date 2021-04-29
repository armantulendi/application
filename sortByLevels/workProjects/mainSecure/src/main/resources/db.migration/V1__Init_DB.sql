create table hibernate_sequence (next_val bigint) 
insert into hibernate_sequence values ( 1 )
create table message (
    id integer not null,
    file_name varchar(255),
    tag varchar(255),
    text varchar(255),
    user_id bigint,
    primary key (id)); 
create table user_role (user_id bigint not null,
    roles varchar(255)) 
create table usr (id bigint not null,
    active bit not null,
    email varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    password varchar(255),
    repeat_password varchar(255),
    username varchar(255),
    primary key (id)); 
alter table message
    add constraint FK70bv6o4exfe3fbrho7nuotopf
    foreign key (user_id) references usr (id);
alter table user_role
    add constraint FKfpm8swft53ulq2hl11yplpr5
    foreign key (user_id) references usr (id);