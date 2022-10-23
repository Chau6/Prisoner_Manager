create proc InsertPri
@fullname nvarchar(25),@gender bit, @dob date, @day_in date
as
begin
	insert into Prisoner (fullname,gender,dob,day_in)
	values (@fullname,@gender,@dob,@day_in);
end
go

create proc UpdatePri
@fullname nvarchar(25),@gender bit, @dob date, @day_in date, @id int
as
begin
	update Prisoner 
	set fullname = @fullname, gender = @gender, dob = @dob, day_in = @day_in
	where id = @id;
end
go

create proc DeletePri
@id int
as
begin
	delete from Prisoner where id = @id;
end
go

create proc SelAllPri
as
begin
	select * from Prisoner
end
go

--------------------------------------------------------------

USE master
GO

DROP DATABASE IF EXISTS prisoner_dahk
CREATE DATABASE prisoner_dahk
GO 

USE prisoner_dahk
go

DROP TABLE IF EXISTS [USER]
CREATE TABLE [USER]
(
	id SMALLINT PRIMARY KEY IDENTITY,
	email NVARCHAR(50),
	[password] NVARCHAR(50),
	[level] TINYINT,
	create_time DATE,
	update_time DATE
)

DROP TABLE IF EXISTS CRIME
CREATE TABLE CRIME
(
	id SMALLINT PRIMARY KEY IDENTITY,
	crime_name NVARCHAR(50)
)

DROP TABLE IF EXISTS DANGEROUS_LEVEL
CREATE TABLE DANGEROUS_LEVEL
(
	dangerous_id SMALLINT PRIMARY KEY IDENTITY,
	dangerous_name NVARCHAR(50),
	id_crime SMALLINT
)

DROP TABLE IF EXISTS [CASE]
CREATE TABLE [CASE]
(
	case_id SMALLINT PRIMARY KEY IDENTITY,
	case_name NVARCHAR(50),
	classify NVARCHAR(50),
	id_dglvl SMALLINT
)

DROP TABLE IF EXISTS CRIME
CREATE TABLE CRIME
(
	crime_id SMALLINT PRIMARY KEY IDENTITY,
	crime_name NVARCHAR(50)
)


DROP TABLE IF EXISTS PRISONER
CREATE TABLE PRISONER
(
	prisoner_id SMALLINT PRIMARY KEY IDENTITY,
	fullname NVARCHAR(50),
	gender BIT,
	birthday DATE,
	day_in DATE,
	update_time DATE,
	prison_id SMALLINT,
	case_id SMALLINT,
	dayout_id SMALLINT
)

DROP TABLE IF EXISTS ACHIEVEMENT
CREATE TABLE ACHIEVEMENT
(
	achieve_id SMALLINT PRIMARY KEY IDENTITY,
	achievement_name NVARCHAR(50),
	dec_time DATE
)

DROP TABLE IF EXISTS CRIME_IN_PRISON
CREATE TABLE CRIME_IN_PRISON
(
	crimeprison_id SMALLINT PRIMARY KEY IDENTITY,
	crimeprison_name NVARCHAR(50),
	fines NVARCHAR(50)
)

DROP TABLE IF EXISTS DAYOUT_DETAIL
CREATE TABLE DAYOUT_DETAIL
(
	id SMALLINT PRIMARY KEY IDENTITY,
	day_out DATE,
	crimeprison_id SMALLINT,
	achiev_id SMALLINT
)

DROP TABLE IF EXISTS PRISON
CREATE TABLE PRISON
(
	prison_id SMALLINT PRIMARY KEY IDENTITY,
	prison_name NVARCHAR(50)
) 

DROP TABLE IF EXISTS TRANSFER_DETAIL
CREATE TABLE TRANSFER_DETAIL
(
	transfer_id SMALLINT PRIMARY KEY IDENTITY,
	old_prison_id SMALLINT,
	current_prison_id SMALLINT,
	day_transfer DATE,
	prisoner_id SMALLINT
)

DROP TABLE IF EXISTS REPORT_DETAIL
CREATE TABLE REPORT_DETAIL
(
	id SMALLINT PRIMARY KEY IDENTITY,
	transfer_id SMALLINT,
	prisoner_id SMALLINT,
	dayout_id SMALLINT,
	update_time SMALLINT
)

--------------------------------------------------------------------------------------

create proc selectPrisoner
@PageNumber as int, @RowOfPage as int
as
begin
	select * from PRISONER
	order by prisoner_id
	offset (@PageNumber - 1) * @RowOfPage rows
	fetch next @RowOfPage rows only
end
go

selectPrisoner 2,10

insert into PRISONER(fullname,gender,birthday,day_in,update_time,prison_id,case_id,dayout_id)
values (N'Tấn Châu',1,'2003-02-06','2003-02-07','2003-02-07',99,999,9)
go 100

create proc countPrisoner
as
begin
	select COUNT(prisoner_id) total from PRISONER
end
go
