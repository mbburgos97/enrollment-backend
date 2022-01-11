CREATE TABLE IF NOT EXISTS student (
	student_id varchar(64) primary key,
	first_name varchar(64) not null,
	middle_name varchar(64) not null,
	last_name varchar(64) not null,
	created_at timestamp not null,
	updated_at timestamp,
	profile_image varchar(128)
);

CREATE TABLE IF NOT EXISTS teacher (
	teacher_id varchar(64) primary key,
	first_name varchar(64) not null,
	middle_name varchar(64) not null,
	last_name varchar(64) not null,
	created_at timestamp not null,
	updated_at timestamp,
	profile_image varchar(128)
);

CREATE TABLE if not EXISTS subject (
	subject_id integer primary key,
	teacher_id varchar(64) not null,
	foreign key (teacher_id)
		references teacher (teacher_id)
);

CREATE TABLE if not EXISTS subject_student (
	id serial primary key,
	subject_id integer not null,
	student_id varchar not null,
	foreign key (student_id)
		references student (student_id)
);