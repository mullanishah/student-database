package com.stud.tester;

import static com.stud.utils.CommonUtils.getScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.stud.dao.StudentDao;
import com.stud.dao.StudentDaoImpl;
import com.stud.dto.Student;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class StudentMainTester {

	private static List<Student> studentList = new ArrayList<Student>();
	private static StudentDao studentDao;
	private static Scanner scanner;
	
	public StudentMainTester() throws Exception {
		scanner = getScanner();
		studentDao = new StudentDaoImpl();
	}

	public static void main(String[] args) throws Exception {
		new StudentMainTester();
		System.out.println(studentDao.getAllStudentDetails());
	}
	
//	public static void main(String[] args) {
//		int choice = 0;
//		try {
//			do {
//				
//			}while(choice != 5);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
