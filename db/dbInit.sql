DROP DATABASE IF EXISTS ktechDB;

CREATE DATABASE ktechDB;

USE ktechDB;

CREATE TABLE framework (
	id int primary key auto_increment,
	frameworkName varchar(50),
	license varchar(50),
	expert varchar(25) NOT NULL,	
	vendor varchar(25)
);

DELIMITER //
CREATE PROCEDURE insertFramework(frameworkName varchar(50), license varchar(50), expert varchar(25), vendor varchar(25))
BEGIN
	INSERT INTO framework(frameworkName, license, expert, vendor) VALUES(frameworkName, license, expert, vendor);
END //
DELIMITER ;

INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Grails', 'Apache', 'Java God', 'Oracle');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Play', 'Apache 2.0', 'Simon', 'Play inc');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('SpringMVC', 'Apache 2.0', 'Chris', 'Spring inc');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Dropwizard', 'Apache 2.1', 'Peter', 'Yammer');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('ASP.NET', 'Apache 2.0', 'Merlin', 'Microsoft');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Angular JS', 'MIT', 'James', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('KnockoutJS', 'MIT', 'Zoe', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Backbone.js', 'MIT', 'Eddy', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Ember.js', 'MIT', 'C0rmac', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Express.js', 'MIT', 'Jordan', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Unified.js', 'BSD', 'Siona', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Zend Framework', 'New BSD', 'Steven', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Sintra', 'MIT', 'James', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Ruby On Rails', 'MIT', 'Andy', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Drupql', 'GPLv2', 'Tanya', 'Alphabet');

CREATE USER 'ktech_user'@'localhost' IDENTIFIED BY '1Password2';

GRANT SELECT on ktechDB.framework TO 'ktech_user'@'localhost';
GRANT INSERT on ktechDB.framework TO 'ktech_user'@'localhost';


