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

INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Grails', 'Apache', 'M McVeigh', 'Oracle');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Play', 'Apache 2.0', 'Simon Watson', 'Play inc');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('SpringMVC', 'Apache 2.0', 'Chris Kalista', 'Spring inc');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Dropwizard', 'Apache 2.1', 'Rory Hanratty', 'Yammer');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('ASP.NET', 'Apache 2.0', 'Dave Spence', 'Microsoft');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Angular JS', 'MIT', 'Chris Kalista', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('KnockoutJS', 'MIT', 'Zoe Bryant', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Backbone.js', 'MIT', 'Matt Jamiowszki', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Ember.js', 'MIT', 'Matt Jamiowszki', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Express.js', 'MIT', 'Peader Kelly', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Unified.js', 'BSD', 'Siona Murray', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Zend Framework', 'New BSD', 'Steven Alexander', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Sinatra', 'MIT', 'James Nelson', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Ruby On Rails', 'MIT', 'Zoe Bryant', 'Alphabet');
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Drupal', 'GPLv2', 'Tom Swann', 'Alphabet');

GRANT SELECT on ktechDB.framework TO 'ktech_user'@'localhost';
GRANT INSERT on ktechDB.framework TO 'ktech_user'@'localhost';


