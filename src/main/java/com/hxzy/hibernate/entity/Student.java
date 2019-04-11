package com.hxzy.hibernate.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Student implements Serializable{
//	public Timestamp timestamp;

	private static final long serialVersionUID = 6667200631959489670L;
	public Integer id;
	public String name;
	public Integer age;
	
	
	
//	public Timestamp getTimestamp() {
//		return timestamp;
//	}
//	public void setTimestamp(Timestamp timestamp) {
//		this.timestamp = timestamp;
//	}
	
	public Student() {
		super();
	}
	public Student(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}
//	@Override
//	public String toString() {
//		return "Student [timestamp=" + timestamp + ", id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	



	
	
}
