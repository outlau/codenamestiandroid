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

INSERT INTO `times` (`datetime`) VALUES ('2019-02-6 22:22:00');
INSERT INTO `times` (`datetime`) VALUES ('2019-01-24 22:22:00');


INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Brønshøj', '55.710532', '12.496634');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Norrköping', '58.594489', '16.179629');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Cabo San Lucas', '22.925584', '-109.912899');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'San Francisco', '37.939032', '-122.338607');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Istanbul', '42.774469', '29.275495');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Læsø', '57.276634', '10.938507');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Skagen', '57.725237', '10.577372');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Legoland', '55.735650', '9.126837');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Stockholm', '59.334624', '18.071394');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Göteborg', '57.770045', '11.966827');
INSERT INTO `coordinates` (`id`, `name`, `latitude`, `longitude`) VALUES (NULL, 'Rya', '55.958631', '13.998931');



INSERT INTO quotes (name) VALUES ('The love of blitzi is eternal');

INSERT INTO sti (name) VALUES ('sti1.wav');
