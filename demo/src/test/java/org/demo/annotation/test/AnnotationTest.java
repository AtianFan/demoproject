package org.demo.annotation.test;

import org.demo.annotation.Student;
import org.demo.annotation.Validation;
import org.junit.Test;

public class AnnotationTest {

	@Test
	public void testValidation() {
		Student stu = new Student();
		stu.setStudentName("Jack");
		stu.setAge(10);
		Validation.validate(stu);
	}
}
