DROP TABLE `player`;

CREATE TABLE player(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	age INTEGER NOT NULL,
	Position VARCHAR(255),
	goals INTEGER
);
	