-- Soccer JPA 버전

create table stadium(
id int AUTO_INCREMENT,
statdium_name varchar(40),
hometeam_id varchar(10),
seat_count int,
address varchar(60),
ddd varchar(10),
tel varchar(10),
PRIMARY KEY(id)
)DEFAULT CHARSET=utf8;

create table schedule (
id int AUTO_INCREMENT,
sche_date varchar(10),
stadium_id int,
gubun varchar(10),
hometeam_id varchar(10),
awayteam_id varchar(10),
home_score int,
away_score int,
PRIMARY KEY(id),
FOREIGN KEY(Stadium_id) REFERENCES stadium(id)
);

create table team(
id int AUTO_INCREMENT,
region_name varchar(10),
team_name varchar(40),
e_team_name varchar(50),
orig_yyyy varchar(10),
zip_code1 varchar(10),
zip_code2 varchar(10),
address varchar(80),
ddd varchar(10),
tel varchar(10),
fax varchar(10),
homepage varchar(50),
owner varchar(10),
stadium_id int,
PRIMARY KEY(id),
FOREIGN KEY(Stadium_id) REFERENCES stadium(id)
);

create table player(
id int AUTO_INCREMENT,
player_name varchar(20),
e_player_name varchar(40),
nickname varchar(30),
join_yyyy varchar(10),
position varchar(10),
back_no int,
nation varchar(20),
birth_date Date,
solar varchar(10),
height int,
weiget int,
team_id int,
PRIMARY KEY(id),
FOREIGN KEY(team_id) REFERENCES team(id)
);