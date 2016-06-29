CREATE DATABASE IF NOT EXISTS easybuy CHARACTER SET utf8;
CREATE USER gentlemen@localhost IDENTIFIED BY 'gentlemen';
GRANT ALL ON easybuy.* TO gentlemen@localhost;