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

}
