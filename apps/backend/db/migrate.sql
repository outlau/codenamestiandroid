DROP TABLE coordinates;
DROP TABLE times;
DROP TABLE quotes;
DROP TABLE sti;

CREATE TABLE coordinates (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    latitude	float,
    longitude	float,
    PRIMARY KEY (id)
);

create table times
(
    id int NOT NULL AUTO_INCREMENT,
    datetime datetime not null,
    primary key (id)
)
;

create table quotes
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    primary key (id)
)
;

create table sti
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
)
;

INSERT INTO `times` (`datetime`) VALUES ('2019-02-22 16:00:00');
INSERT INTO `times` (`datetime`) VALUES ('2019-01-22 15:00:00');
INSERT INTO `times` (`datetime`) VALUES ('2019-03-22 14:00:00');


INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Brønshøj', '55.710532', '12.496634');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'London', '-45', '40');

INSERT INTO quotes (name) VALUES ('The love of blitzi heals');

INSERT INTO sti (name) VALUES ('sti1.wav');
