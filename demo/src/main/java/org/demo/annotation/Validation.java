package org.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.demo.annotation.validator.AbstractValidator;
import org.demo.annotation.validator.ValidatorFactory;


public class Validation {
	public static <T> void validate(T t) {
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field f : fields) {
			Annotation[] as = f.getAnnotations();
			for (Annotation a : as) {
				String typeName = a.annotationType().getSimpleName();
				AbstractValidator validator = ValidatorFactory
						.createValidator(ValidatorType.valueOf(typeName));
				validator.validate(t, f);
			}
		}
	}
}
