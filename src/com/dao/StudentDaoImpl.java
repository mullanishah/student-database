package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.dto.Student;
import com.utils.DBUtils;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class StudentDaoImpl implements StudentDao {
	
	private Connection conn;
	private PreparedStatement pstGetStudDetails;
	
	private String queryGetStudDetails = "Select * from STUDENT";
	
	public StudentDaoImpl() throws Exception {
		this.conn = DBUtils.getConnection();
		this.pstGetStudDetails = conn.prepareStatement(queryGetStudDetails);
	}

	public void cleanUp() throws Exception {
		
		if(null != pstGetStudDetails)
			pstGetStudDetails.close();
		if(null != conn)
			conn.close();
	}

	@Override
	public ArrayList<Student> getAllStudentDetails() throws Exception {
		
		ArrayList<Student> studentList = new ArrayList<Student>(5);
		try(ResultSet rst = pstGetStudDetails.executeQuery();){
			while(rst.next() != false) {
				long studId = rst.getLong("id");
				String fullName = rst.getString("name");
				String courseTitle = rst.getString("course");
				String currentSem = rst.getString("semester");
				String address = rst.getString("address");
				Date birthDate = rst.getDate("bday");
				long contactNum = rst.getLong("contact");
				long emergencyContact = rst.getLong("emergency");
				studentList.add(new Student(studId, fullName, courseTitle, currentSem, address, birthDate, contactNum, emergencyContact));			
			}
		}
		return studentList;
	}

}
