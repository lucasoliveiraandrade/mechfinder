

insert into user (cpf, full_name, gender, nickname, password, user_type) values (38487291805, 'lucas andrade', 'MALE', 'landrade', '1234', 'ADMIN');
insert into address(city, neighborhood, number, postal_code, state, street, user_id) values ('Jacareí', 'Jd Santa Maria', 123, 12328460, 'SP', 'Av Vereador Afonso Rosa da Silva', (select id from user where cpf = 38487291805));
insert into contact(first_email, first_phone, first_phone_type, user_id) values ('lucas.andrade999@gmail.com','12 99782-1666', 'mobile', (select id from user where cpf = 38487291805)); 
