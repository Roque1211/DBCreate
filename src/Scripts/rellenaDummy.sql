insert into project(name) values("Proyecto primero");
insert into project(name) values("Proyecto segundo");
insert into project(name) values("Proyecto tercero");
insert into project(name) values("Proyecto cuarto");
insert into project(name) values("Proyecto quinto");
insert into project(name) values("Proyecto sexto");
insert into project(name) values("Proyecto octavo");
insert into project(name) values("Proyecto noveno");
insert into project(name) values("Proyecto décimo");
insert into project(name) values("Proyecto undécimo");
insert into project(name) values("Proyecto duodécimo");
insert into project(name) values("Proyecto trigésimo");
insert into project(name) values("Proyecto cuatrigécimo");
insert into project(name) values("Proyecto quinquagésimo");

insert into user(nick,pwd,mail,last_login, first_login) values("roque","1234","a_roque.flores.naranjo@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("perico","1234","a_perico@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("antonio","1234","antonio@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("juan","1234","juan@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("patricio","1234","patricio@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("bobesponja","1234","bobesponja@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("calamardo","1234","calamardo.naranjo@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("gary","1234","gary@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("jondoe","1234","jondoe@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("paco","1234","paco@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("curro","1234","curro@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("heidi","1234","heidio@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("marco","1234","marco@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("amedio","1234","amedio@iespablopicasso.es","2019-01-01","2018-02-23");
insert into user(nick,pwd,mail,last_login, first_login) values("dragon","1234","dragon@iespablopicasso.es","2019-01-01","2018-02-23");

insert into cabhoras(iduser,datecab) values(1,"2021-03-01");
insert into cabhoras(iduser,datecab) values(1,"2021-03-02");
insert into cabhoras(iduser,datecab) values(1,"2021-03-03");
insert into cabhoras(iduser,datecab) values(1,"2021-03-04");
insert into cabhoras(iduser,datecab) values(1,"2021-03-05");

insert into linhoras(idcab,idproject,firsttime,lasttime) values(1,1,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(1,1,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(2,1,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(2,1,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(3,2,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(3,2,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(4,2,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(4,3,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(5,3,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(5,3,"08:00:00", "14:00:00");

insert into cabhoras(iduser,datecab) values(2,"2021-03-01");
insert into cabhoras(iduser,datecab) values(2,"2021-03-02");
insert into cabhoras(iduser,datecab) values(2,"2021-03-03");
insert into cabhoras(iduser,datecab) values(2,"2021-03-04");
insert into cabhoras(iduser,datecab) values(2,"2021-03-05");

insert into linhoras(idcab,idproject,firsttime,lasttime) values(6,4,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(6,4,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(7,4,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(7,4,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(8,5,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(8,5,"15:00:00", "18:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(8,5,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(9,6,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(9,6,"08:00:00", "14:00:00");
insert into linhoras(idcab,idproject,firsttime,lasttime) values(10,6,"08:00:00", "14:00:00");

insert into user_project(iduser, idproject) values(1,1);
insert into user_project(iduser, idproject) values(1,2);
insert into user_project(iduser, idproject) values(1,3);
insert into user_project(iduser, idproject) values(2,4);
insert into user_project(iduser, idproject) values(2,5);
insert into user_project(iduser, idproject) values(2,6);