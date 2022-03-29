package com.stud.dao;

import java.util.ArrayList;

import com.stud.dto.Student;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public interface StudentDao {
	
	public ArrayList<Student> getAllStudentDetails() throws Exception;
	public String addStudentDetail(Student student) throws Exception;
	public String removeStudentDetail(long studId, String studName) throws Exception;
	public String updateStudentDetails(long id, Student student) throws Exception;
	public Student searchStudent(long studId) throws Exception;
	public Boolean verifyStudent(long studId) throws Exception;
}
