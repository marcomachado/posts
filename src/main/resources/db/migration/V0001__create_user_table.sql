create table user (
    id bigint auto_increment,
    username varchar(10) not null unique,
    created_at datetime not null,
    primary key (id)
);
