drop table Todo if exists;

        create table Todo (
                id bigint not null generated always as identity(start with 1,increment by 1),
                Todo_title varchar(40) not null,
                Todo_start varchar(20) not null,
                Todo_end varchar(20),
                unique(id));