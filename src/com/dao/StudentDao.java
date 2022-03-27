package com.dao;

import java.util.ArrayList;

import com.dto.Student;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public interface StudentDao {
	
	public ArrayList<Student> getAllStudentDetails() throws Exception;

}
