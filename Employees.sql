create database Employees;
use Employees;
create table employee(
Id int(4),
Name varchar(26)not null,
Uname varchar(6),
Salary double(8,2) not null,
Pass varchar(8),
primary key(Uname,Pass,Id));