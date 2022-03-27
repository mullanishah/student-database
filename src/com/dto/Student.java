package com.dto;

import java.util.Date;
import static com.utils.CommonUtils.*;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class Student {
	
	private long studId; 		//idCardNum; 
	private String fullName;
	private String courseTitle;
	private String currentSem;
	private String address;
	private Date birthDate;
	private long contactNum;
	private long emergencyContact;
	
	
	public Student() {
		super();
	}

	public Student(long studId, String fullName, String courseTitle, String currentSem, String address, Date birthDate,
			long contactNum, long emergencyContact) {
		super();
		this.studId = studId;
		this.fullName = fullName;
		this.courseTitle = courseTitle;
		this.currentSem = currentSem;
		this.address = address;
		this.birthDate = birthDate;
		this.contactNum = contactNum;
		this.emergencyContact = emergencyContact;
	}

	public Student(String fullName, String courseTitle, String currentSem, String address, Date birthDate,
			long contactNum, long emergencyContact) {
		super();
		this.fullName = fullName;
		this.courseTitle = courseTitle;
		this.currentSem = currentSem;
		this.address = address;
		this.birthDate = birthDate;
		this.contactNum = contactNum;
		this.emergencyContact = emergencyContact;
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCurrentSem() {
		return currentSem;
	}

	public void setCurrentSem(String currentSem) {
		this.currentSem = currentSem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return getSdf().format(birthDate);
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getContactNum() {
		return contactNum;
	}

	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}

	public long getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	@Override
	public String toString() {
		return "Student [Id: " + studId + ", Name: " + fullName + ", Course: " + courseTitle + ", Current Sem: "
				+ currentSem + ", Address: " + address + ", Birth Date: " + getSdf().format(birthDate) + ", Contact: " + contactNum
				+ ", Emergency Contact=" + emergencyContact + "]";
	}
}
