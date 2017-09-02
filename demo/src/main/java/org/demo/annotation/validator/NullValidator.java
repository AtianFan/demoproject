package org.demo.annotation.validator;

import java.lang.reflect.Field;

import org.demo.annotation.customeranno.Null;
import org.demo.annotation.exception.ValidatorException;

public class NullValidator extends AbstractValidator {
	@Override
	public <T> void validateField(T t, Field f) {
		if (f.isAnnotationPresent(Null.class)) {
			try {
				f.setAccessible(true);
				if (null != f.get(t)) {
					throw new ValidatorException(f.getAnnotation(Null.class)
							.message());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
