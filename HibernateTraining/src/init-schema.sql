CREATE TABLE IF NOT EXISTS Client (
	ID integer not null auto_increment primary key,
	FIRSTNAME varchar(255) not null,
	LASTNAME varchar(255) not null,
	TELEPHONE varchar(9),
	EMAIL varchar(255)
);

CREATE TABLE IF NOT EXISTS Pet (
	ID integer not null auto_increment primary key,
	NAME varchar(255) not null,
	BIRTHDATE timestamp,
	OWNER_ID integer not null
);

CREATE TABLE IF NOT EXISTS Visit (
	ID integer not null auto_increment primary key,
	PET_ID integer not null,
	DATE timestamp,
	DESCRIPTION varchar(1024)
);

