USE easybuy;

DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS orders;

CREATE TABLE admin (
    id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(128) NOT NULL
)CHARSET=utf8;

CREATE TABLE user (
    id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(128) NOT NULL,
    phone    VARCHAR(32),
    address  VARCHAR(512)
)CHARSET=utf8;

CREATE TABLE category (
    id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(1024),
    parent      INT DEFAULT 0                                    
)CHARSET=utf8;

CREATE TABLE goods (
    id      INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cid     INT,
    name    VARCHAR(255),
    price   FLOAT,
    offset  FLOAT,
    storage INT,
    time    TIMESTAMP
)CHARSET=utf8;

CREATE TABLE image (
    id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gid  INT,
    path VARCHAR(2000)
)CHARSET=utf8;

CREATE TABLE orders (
    id    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    uid   INT,
    gid   INT,
    time  TIMESTAMP,
    sum   INT,
    state INT,
    total FLOAT
)CHARSET=utf8;