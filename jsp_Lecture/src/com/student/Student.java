package com.student;

public class Student {
	
	private String name = null;
	private String student_id = null;
	private String phone = null;
	private String subject = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Student(String name, String student_id, String phone, String subject) {
		super();
		this.name = name;
		this.student_id = student_id;
		this.phone = phone;
		this.subject = subject;
	}

	
}
