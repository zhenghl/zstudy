package com.mybatis;

import java.io.Serializable;
import java.util.*;

public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 3096154202413606831L;
	private String classEntity;
	private Date studentBirthday;
	private String studentID;
	private String studentName;
	public String getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(String classEntity) {
		this.classEntity = classEntity;
	}

	private String studentSex;
	


	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setString(String classEntity) {
		this.classEntity = classEntity;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
}

