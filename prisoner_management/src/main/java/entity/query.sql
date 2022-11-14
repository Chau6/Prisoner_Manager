use master
go

drop database if exists Prisoner_Management_System
create database Prisoner_Management_System
go

use Prisoner_Management_System
go

--Table

drop table if exists [User]
create table [User]
(
	U_Id int primary key identity, --sa always have id = 1 || level = 1 - 3
	U_Username nvarchar(50),
	U_Password nvarchar(50),
	U_Phone varchar(15),
	U_Email nvarchar(50),
	U_Level tinyint,
	Created_At date,
	Update_At date
)
go

drop table if exists Prisoner_Info
create table Prisoner_Info
(
	P_Id int primary key,
	P_Name nvarchar(50),
	P_Gender bit,
	P_Dob varchar(10), --date of birth
	P_Admit varchar(10),
	P_Release varchar(10),
	P_Crime nvarchar(max),
	P_Security_Level tinyint,
	Created_At date,
	Update_At date
)
go

drop table if exists Guard_Info
create table Guard_Info
(
	G_Id int primary key,
	G_Name nvarchar(50),
	G_Gender bit,
	G_Dob varchar(10), --date of birth
	G_Level tinyint,
	Created_At date,
	Update_At date
)
go

drop table if exists Supervision_Info
create table Supervision_Info
(
	S_Id int primary key,
	S_Name nvarchar(50),
	S_Gender bit,
	S_Dob varchar(10), --date of birth
	S_Level tinyint,
	Created_At date,
	Update_At date
)
go

drop table if exists Block_Info
create table Block_Info
(
	B_Id int primary key identity,
	B_Name nvarchar(50), --block A / B / C
	B_Cell_Room smallint, -- id room 1 -> 10
	P_Id int, --foreign key
	G_Id int, --foreign key
	S_Id int, --foreign key
	Created_At date,
	Update_At date
)
go

drop table if exists Transfer_Detail
create table Transfer_Detail
(
	T_Id int primary key identity,
	T_Old_Prison nvarchar(50),
	T_Reason nvarchar(max),
	T_Transfer_Date varchar(10),
	P_Id int, --foreign key
	Created_At date,
	Update_At date
)

drop table if exists Feedback
create table Feedback
(
	F_Id int primary key identity,
	F_CMT nvarchar(max),
	P_Id int, --foreign key
	G_Id int, --foreign key
	Created_At date,
	Update_At date
)
go

--Foreign key

alter table Block_Info
add constraint fk_Block_Info_Prisoner_Info
foreign key (P_Id)
references Prisoner_Info (P_Id)
go

alter table Block_Info
add constraint fk_Block_Info_Guard_Info
foreign key (G_Id)
references Guard_Info (G_Id)
go

alter table Block_Info
add constraint fk_Block_Info_Supervision_Info
foreign key (S_Id)
references Supervision_Info (S_Id)
go

alter table Transfer_Detail
add constraint fk_Transfer_Detail_Prisoner_Info
foreign key (P_Id)
references Prisoner_Info (P_Id)
go

alter table Feedback
add constraint fk_Feedback_Prisoner_Info
foreign key (P_Id)
references Prisoner_Info (P_Id)
go

alter table Feedback
add constraint fk_Feedback_Guard_Info
foreign key (G_Id)
references Guard_Info (G_Id)
go

create proc InsertUser
@U_Username nvarchar(50),@U_Password nvarchar(50),@U_Phone varchar(15),@U_Email nvarchar(50),@U_Level tinyint
as
begin
	insert into [User](U_Username,
	U_Password,
	U_Phone,
	U_Email,
	U_Level,
	Created_At)
	values (@U_Username,@U_Password,@U_Phone,@U_Email,@U_Level,getdate())
end
go

InsertUser 'tanchau0602','tanchau2003',01111111111,'tanchau@gmail.com',2
go 4

create proc UpdateUser
@U_Username nvarchar(50),@U_Password nvarchar(50),@U_Phone varchar(15),@U_Email nvarchar(50),@U_Level tinyint, @U_Id int
as
begin
	update [User]
	set U_Username = @U_Username,
	U_Password = @U_Password,
	U_Phone = @U_Phone,
	U_Email = @U_Email,
	U_Level = @U_Level,
	Update_At = getdate()
	where U_Id = @U_Id 
end
go

UpdateUser 'tanchau06022003','tanchau20030602',0888888888,'tanchau@gmail.com',2,5