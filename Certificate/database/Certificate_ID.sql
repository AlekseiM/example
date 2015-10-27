DROP TABLE IF EXISTS DATE_ISSUE;
DROP TABLE IF EXISTS SERIES;
DROP TABLE IF EXISTS NUMBER;
DROP TABLE IF EXISTS MIDDLE_NAME;
DROP TABLE IF EXISTS FIRST_NAME;
DROP TABLE IF EXISTS LAST_NAME;
DROP TABLE IF EXISTS ORGANIZATION_REGISTRATION;
DROP TABLE IF EXISTS PASSPORT;
DROP TABLE IF EXISTS REGISTRATION_DATE;
DROP TABLE IF EXISTS CERTIFICATE_REGISTRATION;

CREATE TABLE CERTIFICATE_REGISTRATION(
CERTIFICATE_REGISTRATION_ID INT (10) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (CERTIFICATE_REGISTRATION_ID)
);

CREATE TABLE REGISTRATION_DATE(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
CERTIFICATE_REGISTRATION_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (CERTIFICATE_REGISTRATION_ID) REFERENCES CERTIFICATE_REGISTRATION(CERTIFICATE_REGISTRATION_ID)
);

CREATE TABLE ORGANIZATION_REGISTRATION(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
CERTIFICATE_REGISTRATION_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (CERTIFICATE_REGISTRATION_ID) REFERENCES CERTIFICATE_REGISTRATION(CERTIFICATE_REGISTRATION_ID)
);

CREATE TABLE PASSPORT(
PASSPORT_ID INT(10) NOT NULL AUTO_INCREMENT,
CERTIFICATE_REGISTRATION_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (PASSPORT_ID),
FOREIGN KEY (CERTIFICATE_REGISTRATION_ID) REFERENCES CERTIFICATE_REGISTRATION(CERTIFICATE_REGISTRATION_ID)
);

CREATE TABLE LAST_NAME(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);

CREATE TABLE FIRST_NAME(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);

CREATE TABLE MIDDLE_NAME(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);

CREATE TABLE NUMBER(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);

CREATE TABLE SERIES(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);

CREATE TABLE DATE_ISSUE(
ID INT(10) NOT NULL AUTO_INCREMENT,
INFORMATION VARCHAR(40) NULL,
PASSPORT_ID INT(10) NULL DEFAULT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(PASSPORT_ID)
);
