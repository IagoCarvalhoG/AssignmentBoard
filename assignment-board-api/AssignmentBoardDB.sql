drop databse assignmentboarddb;
drop user assignmentboard;
create user assignmentboard with password 'password';
create database assignmentboarddb with template=template0 owner=assignmentboard;
\connect assignmentboarddb;
alter default privileges grant all on tables to assignmentboard;
alter default privileges grant all on sequences to assignmentboard;

create table db_user(
user_id serial primary key,
first_name varchar(20) not null,
last_name varchar(20) not null,
username varchar(20) not null,
password text not null,
email varchar(30) not null,
picture text
);

create table db_group(
group_id serial primary key,
group_name varchar(20) not null
);

create table message(
message_id serial primary key,
user_id integer not null,
group_id integer not null,
message_text text not null,
date_sent date not null
);

alter table message add constraint users_id
foreign key (user_id) references db_user(user_id);

alter table message add constraint groups_id
foreign key (group_id) references db_group(group_id);

create table assignments(
assignment_id serial primary key,
group_id integer not null,
user_id integer not null,
assignment_name varchar(20) not null,
assignment_description text,
finished boolean not null,
deadline date not null,
assignment_period integer,
time_finished timestamp

);

alter table assignments add constraint users_id
foreign key (user_id) references db_user(user_id);

alter table assignments add constraint groups_id
foreign key (group_id) references db_group(group_id);

create table relational(
relational_id serial primary key,
user_id integer not null,
group_id integer not null
);

alter table relational add constraint users_id
foreign key (user_id) references db_user(user_id);

alter table relational add constraint groups_id
foreign key (group_id) references db_group(group_id);