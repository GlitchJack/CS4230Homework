CREATE TABLE CONTACT    (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    PHONE_NUMBER VARCHAR(50),
    HOME_ADDR VARCHAR(100),
    BUSI_ADDR VARCHAR(100)
) ENGINE=INNODB;