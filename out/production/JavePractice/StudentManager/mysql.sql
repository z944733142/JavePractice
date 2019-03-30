

// 学生信息表
create table studentInfo (
id int(11) NOT NULL ,
stuUser varchar(16) NOT NULL ,
stuName varchar(10) NOT NULL,
stuPwd varchar (16),
stuCla int (2) NOT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

// 学生成绩表
create table studentMark (
id int(11) not null,
english int(3) default 0,
math int(3) default 0,
chinese int(3) default 0,
java int(3) default 0,
stuname varchar(16) not null,
PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
// 老师信息表
create table teacher (
id int NOT NULL ,
tchUser varchar (16) NOT NULL,
tchName varchar (10) NOT NULL,
tchPwd varchar (16) NOT NULL,
tchCla int (2),
PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

// 管理员信息表
create table manager (
id int NOT NULL ,
mngUser varchar (16) NOT  NULL ,
mngPwd varchar  (16) NOT NULL ,
PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
