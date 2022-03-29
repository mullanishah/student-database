package com.stud.dao;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class QueryHelper {
	
	public static String queryGetStudDetails = "SELECT * FROM STUDENT";
	public static String queryAddStudDetails = "INSERT INTO STUDENT (name, course, semester, address, bday, contact, emergency)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static String queryRemoveStudDetails = "DELETE FROM student WHERE id = ? and name = ?";
	
	public static String queryUpdateStudDetails = "UPDATE student" +
			" SET name=?, course=?, semester = ?, address=?, bday=?, contact=?, emergency=?" + 
			" WHERE (id= ?)";
	public static String callSearchStud = "{CALL getStudentById(?)}";
	
	public static String callVerifyStud = "{CALL searchStudentId(?, ?)}";
	
	public static String insertionFailed = "Student record insertion was failed!";
	public static String insertionSucceed = "Student record was inserted successfully!";
	
	public static String deletionFailed = "Student record deletion was failed!";
	public static String deletionSucceed = "Student record was deleted successfully!";
	
	public static String updationFailed = "Student record updation was failed!";
	public static String updationSucceed = "Student record was updated successfully!";
}
