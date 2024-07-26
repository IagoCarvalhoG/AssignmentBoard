drop databse assignmentboarddb;
drop user assignmentboard;
create user assignmentboard with password 'password';
create database assignmentboarddb with template=template0 owner=assignmentboard;
\connect assignmentboarddb;
alter default privileges grant all on tables to assignmentboard;
alter default privileges grant all on sequences to assignmentboard;

create table db_user(
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
username varchar(20) not null,
user_password text not null,
email varchar(30) not null,
picture text
);

create table db_group(
group_id integer primary key not null,
group_name varchar(20) not null
);

create table db_message(
message_id integer primary key not null,
user_id integer not null,
group_id integer not null,
message_text text not null,
date_sent date not null
);

alter table db_message add constraint users_id
foreign key (user_id) references db_user(user_id);

alter table db_message add constraint groups_id
foreign key (group_id) references db_group(group_id);

create table db_assignments(
assignment_id integer primary key not null,
group_id integer not null,
assignment_name varchar(20) not null,
assignment_description text,
finished boolean not null,
deadline date not null,
time_finished timestamp

);

alter table db_assignments add constraint groups_id
foreign key (group_id) references db_group(group_id);

create table db_relational(
relational_id integer primary key not null,
user_id integer not null,
group_id integer not null
);

alter table db_relational add constraint users_id
foreign key (user_id) references db_user(user_id);

alter table db_relational add constraint groups_id
foreign key (group_id) references db_group(group_id);

create sequence db_user_seq increment 1 start 1;
create sequence db_group_seq increment 1 start 1;
create sequence db_message_seq increment 1 start 1;
create sequence db_assignments_seq increment 1 start 1;
create sequence db_relational_seq increment 1 start 1;
