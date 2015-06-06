CREATE DATABASE danawara;
USE danawara;

CREATE TABLE IF NOT EXISTS cpu(
  id int(11) NOT NULL AUTO_INCREMENT,
  socket int(1) NOT NULL,
  name varchar(60) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO cpu(socket, name) VALUES
(1, 'Intel cpu 1'),
(1, 'Intel cpu 2'),
(2, 'AMD cpu 1'),
(2, 'AMD cpu 2');


CREATE TABLE IF NOT EXISTS mainboard(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(60) NOT NULL,
  socket int(1) NOT NULL,
  size int(1) NOT NULL, 
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO mainboard(name, socket, size) VALUES
('ASUS M-ATX MAINBOARD Intel', 1, 1),
('MSI  ATX MAINBOARD Intel', 1, 2),
('GIGABYTE Extended-ATX MAINBOARD Intel', 1, 3),
('ZOTAC M-ATX MAINBOARD AMD', 2, 1),
('ASs rock  ATX MAINBOARD AMD', 2, 2),
('ECS Extended-ATX MAINBOARD AMD', 2, 3);


CREATE TABLE IF NOT EXISTS vga(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(60) NOT NULL,
  size int(1) NOT NULL, 
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO vga(name, size) VALUES
('GyeePorce 220 GT (for M-ATX)', 1),
('MSI ADI 9900 (for ATX)', 2),
('BOODOO 224 (for Extended-ATX)', 3);


CREATE TABLE IF NOT EXISTS pc_case(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(60) NOT NULL,
  size int(1) NOT NULL, 
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO pc_case(name, size) VALUES
('InCase (M-ATX)', 1),
('MyeeCronicks (ATX)', 2),
('GB (Extended-ATX)', 3);


select * from cpu;
select * from mainboard;
select * from vga;
select * from pc_case;