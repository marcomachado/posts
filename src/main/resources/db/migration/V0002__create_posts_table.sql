create table post(
    id bigint not null auto_increment,
    content varchar(42) not null,
    created_at datetime not null,
    type enum('ORIGINAL', 'REPOST', 'QUOTE') not null,
    author_id bigint not null,
    original_post_id bigint,
    primary key (id),
    constraint fk_post_user foreign key (author_id) references user (id),
    constraint fk_original_post foreign key (original_post_id) references post (id)
);
