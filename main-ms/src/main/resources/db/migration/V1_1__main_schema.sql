create table city
(
	id bigint auto_increment
		primary key,
	name varchar(255) null
);

create table gender
(
	id bigint auto_increment
		primary key,
	name varchar(255) not null
);



create table temp_user
(
	id bigint auto_increment
		primary key,
	birthday datetime null,
	confirm_link varchar(255) null,
	email varchar(255) null,
	first_name varchar(255) null,
	last_name varchar(255) null,
	middle_name varchar(255) null,
	password varchar(255) null,
	username varchar(255) null
);

create table type_of_user
(
	id bigint auto_increment
		primary key,
	name varchar(255) null
);

create table user
(
	id bigint auto_increment
		primary key,
	active bit null,
	birthday datetime null,
	email varchar(255) not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	middle_name varchar(255) not null,
	uid varchar(255) not null,
	username varchar(255) not null,
	city_of_living bigint null,
	gender bigint null,
	type_of_user bigint null,
	constraint FK1isrcw5olh4k3cddck2x7um5p
		foreign key (gender) references gender (id),
	constraint FKgcjmd56vdfe8y4uxwq5jb852d
		foreign key (type_of_user) references type_of_user (id),
	constraint FKkrcm363wm8xl5ydosqnynmhym
		foreign key (city_of_living) references city (id)
);


-- create table city
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table company
-- (
--   id                   bigint auto_increment
--     primary key,
--   company_logo         varchar(255) null,
--   company_registration varchar(255) null,
--   date_of_creation     datetime     null,
--   info                 varchar(255) null,
--   legal_address        varchar(255) null,
--   name                 varchar(255) null,
--   city_of_company      bigint       null,
--   constraint FKbk2fldd8i3j16sxhiv7u1wlum
--     foreign key (city_of_company) references city (id)
-- );
--
-- create table courses
-- (
--   id      bigint auto_increment
--     primary key,
--   name    varchar(255) null,
--   company bigint       null,
--   constraint FKn3kho9fsq2dk9icugjb1jav04
--     foreign key (company) references company (id)
-- );
--
-- create table gender
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) not null
-- );
--
-- create table position
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table school
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null,
--   city bigint       null,
--   constraint FKfoakajih50nlit17nuymdsc4w
--     foreign key (city) references city (id)
-- );
--
-- create table temp_user
-- (
--   id           bigint auto_increment
--     primary key,
--   birthday     datetime     null,
--   confirm_link varchar(255) null,
--   email        varchar(255) null,
--   first_name   varchar(255) null,
--   last_name    varchar(255) null,
--   middle_name  varchar(255) null,
--   password     varchar(255) null,
--   username     varchar(255) null
-- );
--
-- create table type_of_education
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table type_of_link
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table type_of_skill
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table skill
-- (
--   id            bigint auto_increment
--     primary key,
--   name          varchar(255) null,
--   type_of_skill bigint       not null,
--   constraint FK2pq7nkn4vi1tw0f3sh9te20ak
--     foreign key (type_of_skill) references type_of_skill (id)
-- );
--
-- create table courses_skill
-- (
--   id      bigint auto_increment
--     primary key,
--   mark    int    null,
--   courses bigint null,
--   skill   bigint null,
--   constraint FKidnaroskqv5a32karjau56mor
--     foreign key (courses) references courses (id),
--   constraint FKq4vcy9s377iccqifiudb6gb4a
--     foreign key (skill) references skill (id)
-- );
--
-- create table position_skill
-- (
--   id      bigint auto_increment
--     primary key,
--   psition bigint null,
--   skill   bigint null,
--   constraint FKftw0v131ksvhtjsxuq9lo00bm
--     foreign key (skill) references skill (id),
--   constraint FKrbwccr2kt3yatpx8wgglsarcr
--     foreign key (psition) references position (id)
-- );
--
-- create table type_of_task
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table task
-- (
--   id           bigint auto_increment
--     primary key,
--   info         varchar(255) null,
--   name         varchar(255) null,
--   type_of_task bigint       null,
--   constraint FKhnxotnqsbea4shipxmjxk4a1v
--     foreign key (type_of_task) references type_of_task (id)
-- );
--
-- create table task_skill
-- (
--   id    bigint auto_increment
--     primary key,
--   skill bigint null,
--   task  bigint null,
--   constraint FK531rx05uc86qlhwtkx049ce18
--     foreign key (task) references task (id),
--   constraint FKrqovwv8qhc3vt1r5etshfs0ge
--     foreign key (skill) references skill (id)
-- );
--
-- create table type_of_user
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table type_of_vacancy
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null
-- );
--
-- create table university
-- (
--   id   bigint auto_increment
--     primary key,
--   name varchar(255) null,
--   city bigint       null,
--   constraint FKgpb65dw0enw32ntji9bjuhr0l
--     foreign key (city) references city (id)
-- );
--
-- create table faculty
-- (
--   id         bigint auto_increment
--     primary key,
--   name       varchar(255) null,
--   university bigint       null,
--   constraint FKl1hcf6t7l10y28o108exht46d
--     foreign key (university) references university (id)
-- );
--
-- create table department
-- (
--   id             bigint auto_increment
--     primary key,
--   name           varchar(255) null,
--   specialization varchar(255) null,
--   faculty        bigint       null,
--   constraint FK6sk1ry6h6g5ejrihwm8haf88l
--     foreign key (faculty) references faculty (id)
-- );
--
-- create table subject
-- (
--   id           bigint auto_increment
--     primary key,
--   subject_name varchar(255) null,
--   department   bigint       not null,
--   constraint FK8xf3ontgieyt3fynrphggt2vl
--     foreign key (department) references department (id)
-- );
--
-- create table subject_skill
-- (
--   id                 bigint auto_increment
--     primary key,
--   percent_of_skill   int    not null,
--   percent_of_subject int    not null,
--   skill              bigint not null,
--   subject            bigint not null,
--   constraint FKcqjevwvb08jfwdpl36vh8gk29
--     foreign key (subject) references subject (id),
--   constraint FKdvyhy6lmpf217254vuqcgg36n
--     foreign key (skill) references skill (id)
-- );
--
-- create table user
-- (
--   id             bigint auto_increment
--     primary key,
--   active         bit          null,
--   birthday       datetime     null,
--   email          varchar(255) not null,
--   first_name     varchar(255) not null,
--   last_name      varchar(255) not null,
--   middle_name    varchar(255) not null,
--   uid            varchar(255) not null,
--   username       varchar(255) not null,
--   city_of_living bigint       null,
--   gender         bigint       null,
--   type_of_user   bigint       null,
--   constraint FK1isrcw5olh4k3cddck2x7um5p
--     foreign key (gender) references gender (id),
--   constraint FKgcjmd56vdfe8y4uxwq5jb852d
--     foreign key (type_of_user) references type_of_user (id),
--   constraint FKkrcm363wm8xl5ydosqnynmhym
--     foreign key (city_of_living) references city (id)
-- );
--
-- create table education
-- (
--   id                 bigint auto_increment
--     primary key,
--   end_of_education   datetime null,
--   start_of_education datetime null,
--   department         bigint   null,
--   school             bigint   null,
--   type_of_education  bigint   null,
--   user               bigint   null,
--   constraint FK198l9sf1b0xanx6mp4au0cmgf
--     foreign key (type_of_education) references type_of_education (id),
--   constraint FK2mvosaxmdk20x35f654ykcplj
--     foreign key (user) references user (id),
--   constraint FK63tr6a4xjq3e62tq52gmt5twn
--     foreign key (department) references department (id),
--   constraint FKaisuay6bqm69r0pd1omskh0l8
--     foreign key (school) references school (id)
-- );
--
-- create table experience
-- (
--   id            bigint auto_increment
--     primary key,
--   date_of_end   datetime null,
--   date_of_start datetime null,
--   prev_company  bigint   null,
--   position      bigint   null,
--   user          bigint   null,
--   constraint FKc19dq0h5qymr9epwviyngjxic
--     foreign key (prev_company) references company (id),
--   constraint FKpfh1r83yw1avr31sw3ub99ppa
--     foreign key (position) references position (id),
--   constraint FKsal35eberq8nmfvfis0bxp5j
--     foreign key (user) references user (id)
-- );
--
-- create table possible_cities_to_work
-- (
--   id_user bigint not null,
--   id_city bigint not null,
--   primary key (id_user, id_city),
--   constraint FK2pykxv9f2pgdoa7298s3pxpgn
--     foreign key (id_city) references city (id),
--   constraint FKhawf6m0kjxwn02ajtgjpjbam7
--     foreign key (id_user) references user (id)
-- );
--
-- create table subject_skill_user
-- (
--   id            bigint auto_increment
--     primary key,
--   mark          int    not null,
--   expert        bigint not null,
--   subject_skill bigint not null,
--   user          bigint not null,
--   constraint FK3j3delw4kw4is0hh58r073sge
--     foreign key (user) references user (id),
--   constraint FK41hq2rl3pvkprolto73ptv9ne
--     foreign key (subject_skill) references subject_skill (id),
--   constraint FKq0qssfi3iqrld26vlerdcc8g1
--     foreign key (expert) references user (id)
-- );
--
-- create table summary
-- (
--   id   bigint auto_increment
--     primary key,
--   text varchar(255) null,
--   user bigint       null,
--   constraint FKsr71us8i74ib72m71y2jy21tc
--     foreign key (user) references user (id)
-- );
--
-- create table user_company
-- (
--   id_user_company bigint auto_increment
--     primary key,
--   change_approve  bit    null,
--   company_approve bit    null,
--   company         bigint null,
--   position        bigint null,
--   user            bigint null,
--   constraint FKc1goa9mr96odm0l38subly2jf
--     foreign key (position) references position (id),
--   constraint FKi6q4u3i9d85h47qjn7w7p9687
--     foreign key (company) references company (id),
--   constraint FKopbeqqs42qr4nhq4ew10dt069
--     foreign key (user) references user (id)
-- );
--
-- create table user_courses
-- (
--   id              bigint auto_increment
--     primary key,
--   date_of_end     datetime null,
--   date_of_start   datetime null,
--   if_courses_pass bit      null,
--   courses         bigint   null,
--   user            bigint   null,
--   constraint FKdlc2xqew3j47dpxpg97mllb7d
--     foreign key (user) references user (id),
--   constraint FKfl9etfqvikmtqq9exitrcg5ue
--     foreign key (courses) references courses (id)
-- );
--
-- create table history
-- (
--   id              bigint auto_increment
--     primary key,
--   date_of_history datetime     null,
--   history_info    varchar(255) null,
--   education       bigint       null,
--   experience      bigint       null,
--   user            bigint       null,
--   courses         bigint       null,
--   constraint FK3mqsud0tlrcn67vg2f1vnwy0v
--     foreign key (experience) references experience (id),
--   constraint FK9i377avigaa5nxmjyts3qhnwy
--     foreign key (courses) references user_courses (id),
--   constraint FKcgxo71htg9isvktffsodq8g94
--     foreign key (user) references user (id),
--   constraint FKpip11hwoqfjrrp6leo2prk5ny
--     foreign key (education) references education (id)
-- );
--
-- create table user_link
-- (
--   id           bigint auto_increment
--     primary key,
--   link         varchar(255) null,
--   type_of_link bigint       null,
--   user         bigint       null,
--   constraint FK87htt7kka5c380ilp3vk0efqm
--     foreign key (type_of_link) references type_of_link (id),
--   constraint FKb6w40vevtg43uda0m72yddfb7
--     foreign key (user) references user (id)
-- );
--
-- create table user_skill
-- (
--   id                   bigint auto_increment
--     primary key,
--   end_skilling         datetime     null,
--   skill_mark           varchar(255) null,
--   skill_practical_mark varchar(255) null,
--   start_skilling       datetime     null,
--   id_marker            bigint       null,
--   id_skill             bigint       null,
--   id_user              bigint       null,
--   constraint FK6pru830ugj5nuapp3nhdl2p9p
--     foreign key (id_marker) references user (id),
--   constraint FKkwwol8ie05lcjsko1qewnm6r7
--     foreign key (id_user) references user (id),
--   constraint FKrsvxrshr30q4756yoxncoaeyl
--     foreign key (id_skill) references skill (id)
-- );
--
-- create table vacancy
-- (
--   id              bigint auto_increment
--     primary key,
--   info            varchar(255) null,
--   company         bigint       null,
--   type_of_vacancy bigint       null,
--   constraint FKd8i1boc2bf2p3pmtgi3ucxyqf
--     foreign key (company) references company (id),
--   constraint FKg1qrdnkrpjlkt2fr9twump8pt
--     foreign key (type_of_vacancy) references type_of_vacancy (id)
-- );
--
-- create table vacancy_skill
-- (
--   id            bigint auto_increment
--     primary key,
--   expected_mark varchar(255) null,
--   skill         bigint       null,
--   vacancy       bigint       null,
--   constraint FKk10dm3uxe9tlepfwottw6q072
--     foreign key (skill) references skill (id),
--   constraint FKogk31vh34wanbyjgvq8yer6hi
--     foreign key (vacancy) references vacancy (id)
-- );
--
-- create table vacancy_task
-- (
--   id      bigint auto_increment
--     primary key,
--   task    bigint null,
--   vacancy bigint null,
--   constraint FK6ba9j9jtk95526blq7994470h
--     foreign key (task) references task (id),
--   constraint FKsfm3668avg4bw12qfax2slrrd
--     foreign key (vacancy) references vacancy (id)
-- );
--
-- create table vacancy_user
-- (
--   id                  bigint auto_increment
--     primary key,
--   if_accepted_user    bit    null,
--   if_company_accepted bit    null,
--   user                bigint null,
--   vacancy             bigint null,
--   constraint FKgqk92dw8f09b5kttg02uff0rm
--     foreign key (user) references user (id),
--   constraint FKpe3ak6fx2jbgormipmkxy9rff
--     foreign key (vacancy) references vacancy (id)
-- );
--
