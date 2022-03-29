# student-database
An assignment or prototype example to utilize and study functionalities provided by Java JDBC framework. Here we are considering an imaginary student database  system and have considered useful features around it.

The overall objective of this activity is to exercise basic CRUD operations such as record insertion, updation, deletion and search. 

Apart from standard SQL queries which can be found in com.stud.dao.StudentDaoImpl.java, Stored-procedures have been utilised to gain in-depth experience. The details are as follows: 

``` To search if studId is present or not
CREATE DEFINER=`****`@`*******` PROCEDURE `searchStudentId`(
	  IN studId INT,
    OUT isPresent tinyint
)
BEGIN
  declare outputId INT DEFAULT 0;
  IF(studId IS NOT NULL) THEN
	   SELECT id into outputId FROM `students_db`.STUDENT where id = studId;
      IF(outputId > 0) THEN
			 SET isPresent = 1;
      ELSE
			 SET isPresent = 0;
      END IF;
  END IF;
END
```
``` To get student by id:
CREATE DEFINER=`****`@`*******` PROCEDURE `getStudentById`(
	  IN studId INT
)
BEGIN
	IF(studId IS NOT NULL) THEN
		SELECT * FROM `students_db`.STUDENT where id = studId LIMIT 1;
  END IF;
END
```
