package org.demo.annotation.validator;

import java.lang.reflect.Field;

import org.demo.annotation.customeranno.NotNull;
import org.demo.annotation.exception.ValidatorException;

public class NotNullValidator extends AbstractValidator {
	
	@Override
	public <T> void validateField(T t, Field f) {
		if (f.isAnnotationPresent(NotNull.class)) {
			try {
				f.setAccessible(true);
				if (null == f.get(t)) {
					throw new ValidatorException(f.getAnnotation(NotNull.class).message());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
