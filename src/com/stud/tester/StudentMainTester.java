package com.stud.tester;

import static com.stud.utils.CommonUtils.*;
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
		int choice = 0;
		try {
			do {
				System.out.println("===========MENU===========\n"
						+ "1.Display all students \t\t2.Add new student record\n"
						+ "3.Update student record \t4.Delete student record\n"
						+ "5.Exit");
				System.out.println("Enter your preference: ");
				choice = scanner.nextInt();
				switch(choice) {
				case 1:
					getStudents();
					break;
				case 2:
					addStudent();
					break;
				case 3: break;
				case 4:
					removeStudent();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Incorrect choice!");
				}
			}while(choice != 5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getStudents() throws Exception {
		//System.out.println(studentDao.getAllStudentDetails());
		System.out.printf("%-8s %-20s %-16s %-14s %-16s %-16s %-16s %-20s %n", "Id", "Name", "Course", "Semester", "Birthdate", "Contact No", "Emergency No", "Address");
		System.out.println("====================================================================================================================================================");		
		for(Student s : studentDao.getAllStudentDetails()) {
			System.out.printf("%-8s %-20s %-16s %-14s %-16s %-16s %-16s %-20s %n", 
					s.getStudId(), s.getFullName(), s.getCourseTitle(), s.getCurrentSem(), s.getBirthDate(), s.getContactNum(), s.getEmergencyContact(), s.getAddress());
		}
		System.out.println("===================================================================================================================================================");	
	}
	
	private static void addStudent() throws Exception {
		System.out.println("Enter student details (Name, Course, Semester, Address, B'day(dd/MM/yyyy), Contact Num, Emergency Num): ");
		Student student = new Student(scanner.next(), scanner.next(), scanner.next(), scanner.next(), getSdf().parse(scanner.next()), scanner.nextLong(), scanner.nextLong());
		System.out.println("Insertion Status: " + studentDao.addStudentDetail(student));
	}

	private static void removeStudent() throws Exception {
		System.out.println("Enter stud id and name to be removed: ");
		long studId = scanner.nextLong();
		String name = scanner.next();
		System.out.println("Deletion status: " + studentDao.removeStudentDetail(studId, name));
	}
}
