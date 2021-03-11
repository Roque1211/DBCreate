create table if not exists user(
	id integer AUTO_INCREMENT unique NOT NULL primary key,
    nick varchar(20),
	pwd varchar(20),
    mail varchar(255),
    last_login date,
    first_login date
);

create table if not exists project(
	id int AUTO_INCREMENT unique NOT NULL primary key,
	name varchar(255)

);

create table if not exists cabhoras(
	id integer AUTO_INCREMENT unique NOT NULL primary key,
    iduser integer,
    datecab date
);

create table if not exists linhoras(
	idlin integer AUTO_INCREMENT  NOT NULL,
	idcab integer  NOT NULL, 
	idproject integer,
	firsttime time not null,
	lasttime time not null,
	primary key (idlin, idcab)
);

create table if not exists user_project (
	iduser integer,
	idproject integer
);

alter table linhoras add foreign key (idcab) references cabhoras (id);
alter table cabhoras add foreign key (iduser) references user (id);
alter table user_project add foreign key (iduser) references user (id) ON DELETE RESTRICT ON UPDATE CASCADE;
alter table user_project add foreign key (idproject) references project (id) ON DELETE RESTRICT ON UPDATE CASCADE;
