package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	
	private String studentId;
	private ArrayList<Course> coursesTaken;
	private HashMap<String, Integer> semestersByYearAndSemester;
	
	public Student(String studentId) {
		this.studentId = studentId;
		this.coursesTaken = new ArrayList<Course>();
		this.semestersByYearAndSemester = new HashMap<String, Integer>();
	}
	
	public void addCourse(Course newRecord) {
		//add a Course instance created while reading line to the CourseTaken ArrayList in the Student instance
		coursesTaken.add(newRecord);
	}
	
	public int getNumCourseInNthSementer(int semester) {
		int count = 0;
		
		for(Course course: coursesTaken) {
			//save the number of subjects in the semester if you enter the sequential semester number
			String data = (Integer.toString(course.getYearTaken()) + "-" + Integer.toString(course.getSemesterCourseTaken())).trim();
			if(semester == getSemestersByYearAndSemester().get(data)) {
				count += 1;
			}
		}
		
		return count;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public HashMap<String, Integer> getSemestersByYearAndSemester() {
		//creates a hashmap to store the student’s sequential semester information by using strong year and semester information
		semestersByYearAndSemester = new HashMap<String,Integer>();
		int semesterInt = 1;
		for(Course course: coursesTaken) {
			String key = (Integer.toString(course.getYearTaken()) + "-" + Integer.toString(course.getSemesterCourseTaken())).trim();
			
			if(semestersByYearAndSemester.containsKey(key)) {
				continue;
			}else {
				semestersByYearAndSemester.put(key, semesterInt);
				semesterInt += 1;
			}
		}		
		return semestersByYearAndSemester;
	}
	
	public ArrayList<Course> getCoursesTaken() {
		return coursesTaken;
	}
	
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setCoursesTaken(ArrayList<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
	public void setSemestersByYearAndSemester(HashMap<String, Integer> semestersByYearAndSemester) {
		this.semestersByYearAndSemester = semestersByYearAndSemester;
	}


}
