create database jdbc;

create table newspaper(
`number`  varchar(10),
`newspapername` varchar(20),
`price` double,
`unit` varchar(4),
primary key (`number`)
)ENGINE = InnoDB
DEFAULT CHARSET = utf8;

insert into newspaper
(number,newspapername,price,unit)
values
("1","华商报","5.0","张");

insert into newspaper
(number,newspapername,price,unit)
values
('2','西安报','5.0','张');

user:root
passward:1234

grant all privileges on zhouzdb.* to 'root'@'localhost' identified by 'root';
