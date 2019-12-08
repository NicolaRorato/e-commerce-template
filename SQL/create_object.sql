create table cuoco(
user_cuoco varchar2(30),
nome_cuoco varchar2(30),
password varchar2(100),
constraint p_usercuoco primary key(user_cuoco)
);

create table aula(
nome_aula varchar2(10),
constraint p_nomeaula primary key(nome_aula)
);

create table corso(
nome_corso varchar2(30),
docente varchar2(30),
nome_aula varchar2(10),
data_inizio date,
dat_fine date,
prezzo number(5,2),
constraint p_nomecorso primary key(nome_corso),
constraint f_nomeaula foreign key(nome_aula) references aula(nome_aula)
);

create table questionario(
id_questionario int,
nome_corso varchar2(30),
stelle number(1),
user_cuoco varchar2(30),
constraint p_idquestionario primary key(id_questionario),
constraint f_usercuoco foreign key(user_cuoco) references cuoco(user_cuoco),
constraint f_nomecorso foreign key(nome_corso) references corso(nome_corso)
);

create table registrazione(
id_registrazione int,
nome_corso varchar2(30),
user_cuoco varchar2(30),
constraint p_idregistrazione primary key(id_registrazione),
constraint f_nomecorso2 foreign key(nome_corso) references corso(nome_corso),
constraint f_usercuoco2 foreign key(user_cuoco) references cuoco(user_cuoco)
);

create table administrator(
username varchar2(30),
password varchar2(100),
nome_admin varchar2(30),
constraint p_username primary key(username)
);

create sequence questionario_seq;
create sequence registrazione_seq;

