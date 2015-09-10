DROP TABLE IF EXISTS RESIDENT;
CREATE TABLE RESIDENT(
ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(20) NOT NULL,
LAST_NAME VARCHAR(20) NOT NULL,
AGE INT(10) DEFAULT NULL,
ADDRESS_ID INT(10) UNSIGNED NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ID)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;