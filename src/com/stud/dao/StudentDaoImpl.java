package com.stud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import com.stud.dto.Student;
import com.stud.utils.DBUtils;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class StudentDaoImpl implements StudentDao {
	
	private Connection conn;
	private PreparedStatement pstGetStudDetails, pstAddStudDetails, pstRemoveStudDetails;
	
	public StudentDaoImpl() throws Exception {
		this.conn = DBUtils.getConnection();
		this.pstGetStudDetails = conn.prepareStatement(QueryHelper.queryGetStudDetails);
		this.pstAddStudDetails = conn.prepareStatement(QueryHelper.queryAddStudDetails);
		this.pstRemoveStudDetails = conn.prepareStatement(QueryHelper.queryRemoveStudDetails);
	}

	public void cleanUp() throws Exception {
		
		if(null != pstRemoveStudDetails)
			pstRemoveStudDetails.close();
		if(null != pstAddStudDetails)
			pstAddStudDetails.close();
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

	@Override
	public String addStudentDetail(Student student) throws Exception {
		
		pstAddStudDetails.setString(1, student.getFullName());
		pstAddStudDetails.setString(2, student.getCourseTitle());
		pstAddStudDetails.setString(3, student.getCurrentSem());				
		pstAddStudDetails.setString(4, student.getAddress());
		pstAddStudDetails.setDate(5, new java.sql.Date(student.getBirthDate().getTime()));
		pstAddStudDetails.setLong(6, student.getContactNum());
		pstAddStudDetails.setLong(7, student.getEmergencyContact());
		
		int updateCount = pstAddStudDetails.executeUpdate();
		if(updateCount == 1)
			return QueryHelper.insertionSucceed;
		return QueryHelper.insertionFailed;
	}

	@Override
	public String removeStudentDetail(long studId, String studName) throws Exception {
		
		pstRemoveStudDetails.setLong(1, studId);
		pstRemoveStudDetails.setString(2, studName);
		
		int deleteCount = pstRemoveStudDetails.executeUpdate();
		if(deleteCount > 0) {
			return QueryHelper.deletionSucceed;
		}
		return QueryHelper.deletionFailed;
	}

}
