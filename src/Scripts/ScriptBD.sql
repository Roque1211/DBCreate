create table if not exists daily(
	dailyid varchar(36) unique NOT NULL primary key,
    dailyuser varchar(36),
    type varchar(1),
	dailyin datetime,
    dailyout datetime
);

create table if not exists session(
	sessid varchar(36) unique NOT NULL primary key,
    sesstoken varchar(1024),
	sessuser varchar(36),
    sesstart datetime,
    sessend datetime
);

create table if not exists user(
	id varchar(36) unique NOT NULL primary key,
    nick varchar(20),
	pwd varchar(20),
	name varchar(20),
	surname varchar (50),
    mail varchar(255),
    rol varchar (20),
    last_login datetime,
    first_login datetime
);

create table if not exists project(
	id int AUTO_INCREMENT unique NOT NULL primary key,
	name varchar(255)

);

create table if not exists cabhoras(
	id integer AUTO_INCREMENT unique NOT NULL primary key,
    iduser varchar(36),
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
	iduser varchar(36),
	idproject integer,
	primary key (iduser, idproject)
);

alter table linhoras add foreign key (idcab) references cabhoras (id);
alter table cabhoras add foreign key (iduser) references user (id);
alter table user_project add foreign key (iduser) references user (id) ON DELETE RESTRICT ON UPDATE CASCADE;
alter table user_project add foreign key (idproject) references project (id) ON DELETE RESTRICT ON UPDATE CASCADE;
alter table session add foreign key (sessuser) references user (id) ON DELETE RESTRICT ON UPDATE CASCADE;
alter table daily add foreign key (dailyuser) references user (id) ON DELETE RESTRICT ON UPDATE CASCADE;

