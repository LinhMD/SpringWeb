create table department
(
	id int primary key,
	name nvarchar(50) not null
)

create table subject
(
	code int primary key,
	department_code int foreign key references department(id),
	name_VN nvarchar(50) not null,
	name_EN nvarchar(50) not null,
	short_name nvarchar(50) not null,
	grade int not null,
	term int not null,
	is_extra bit not null default 0
)
drop table subject