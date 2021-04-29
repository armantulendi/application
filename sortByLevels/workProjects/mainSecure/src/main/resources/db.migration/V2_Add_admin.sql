insert into usr(id,active,email,firstname,lastname,password,repeat_password,username)
    values(1,1,'admin','admin','admin','admin','admin');

insert into user_role(user_id,roles)
    values(1,'USER'),(1,'ADMIN');