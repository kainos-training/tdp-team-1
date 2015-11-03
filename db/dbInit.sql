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
INSERT INTO framework(frameworkName, license, expert, vendor) VALUES('Drupal', 'GPLv2', 'Tanya', 'Alphabet');

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

DROP USER 'ktech_user'@'localhost';
CREATE USER 'ktech_user'@'localhost' IDENTIFIED BY '1Password2';
GRANT SELECT on ktechDB.framework TO 'ktech_user'@'localhost';
GRANT INSERT on ktechDB.framework TO 'ktech_user'@'localhost';
