drop schema keeper;
create schema keeper character set utf8;
create user keeper@'localhost' identified by 'keeper';
grant all privileges on keeper.* to 'keeper'@'localhost';	
