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

CREATE TABLE project (
	id int primary key auto_increment,
	projectName varchar(50) NOT NULL
);

CREATE TABLE developer (
	id int primary key auto_increment,
	name varchar(50) NOT NULL
);

CREATE TABLE developerFramework (
	developerId int,
	frameworkId int,
	FOREIGN KEY (developerId) REFERENCES developer(id),
	FOREIGN KEY (frameworkId) REFERENCES framework(id)
);

CREATE TABLE projectFramework (
	projectId int,
	frameworkId int,
	FOREIGN KEY (projectId) REFERENCES project(id),
	FOREIGN KEY (frameworkId) REFERENCES framework(id)
);

DELIMITER //
CREATE PROCEDURE insertFramework(frameworkName varchar(50), license varchar(50), expert varchar(25), vendor varchar(25))
BEGIN
	INSERT INTO framework(frameworkName, license, expert, vendor) VALUES(frameworkName, license, expert, vendor);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProjects(framework int)
BEGIN
	SELECT projectName FROM project JOIN projectFramework ON id = projectId WHERE frameworkId = framework;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getDevelopers(framework int)
BEGIN
	SELECT name FROM developer JOIN developerFramework ON id = developerId WHERE frameworkId = framework;
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

INSERT INTO project(projectName) VALUES('Digital Dictation');
INSERT INTO project(projectName) VALUES('Evolve Core');
INSERT INTO project(projectName) VALUES('Evolve for iPad');
INSERT INTO project(projectName) VALUES('Medical Image Viewer');
INSERT INTO project(projectName) VALUES('DVSA');
INSERT INTO project(projectName) VALUES('DFRA');
INSERT INTO project(projectName) VALUES('FCO');

INSERT INTO projectFramework(projectId, frameworkId) VALUES(3, 5);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(4, 7);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(3, 8);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(2, 6);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(7, 9);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(3, 3);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(3, 1);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(4, 4);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(4, 2);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(5, 2);
INSERT INTO projectFramework(projectId, frameworkId) VALUES(6, 2);


INSERT INTO developer(name) VALUES("Eduardo Lima");
INSERT INTO developer(name) VALUES("Zoe Bryant");
INSERT INTO developer(name) VALUES("Ghulam Abbas");
INSERT INTO developer(name) VALUES("Cormac Curran");
INSERT INTO developer(name) VALUES("Simon Watson");
INSERT INTO developer(name) VALUES("Andrew Wright");
INSERT INTO developer(name) VALUES("Thomas Swan");
INSERT INTO developer(name) VALUES("David Spence");
INSERT INTO developer(name) VALUES("Alan Jennings");
INSERT INTO developer(name) VALUES("Will Hamill");
INSERT INTO developer(name) VALUES("Kyle Thompson");


INSERT INTO developerFramework(developerId, frameworkId) VALUES(1, 6);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(2, 5);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(3, 4);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(4, 3);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(5, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(6, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(7, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(8, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(9, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(10, 1);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(2, 6);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(9, 7);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(8, 5);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(7, 4);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(7, 2);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(8, 2);
INSERT INTO developerFramework(developerId, frameworkId) VALUES(9, 2);

DROP USER 'ktech_user'@'localhost';
CREATE USER 'ktech_user'@'localhost' IDENTIFIED BY '1Password2';
GRANT SELECT on ktechDB.framework TO 'ktech_user'@'localhost';
GRANT INSERT on ktechDB.framework TO 'ktech_user'@'localhost';
