package org.demo.annotation;

import org.demo.annotation.customeranno.Max;
import org.demo.annotation.customeranno.NotNull;
import org.demo.annotation.customeranno.Size;

public class Student {
	@NotNull(message="studentName can not null.")
	private String studentName;
	
	@NotNull(message="age can not null.")
    @Max(value = 32)
    @Size(max=100, min=10)
	private Integer age;
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setStudentName("Jack");
		stu.setAge(10);
		Validation.validate(stu);
	}
}
