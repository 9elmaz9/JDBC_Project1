
CREATE TABLE  People
 (
     ID    INT UNIQUE AUTO_INCREMENT,
     FirstName VARCHAR(100) NOT NULL
 );


INSERT INTO  People(ID, FirstName)
VALUES(0,'Tom'),
      (1,'Mike');
