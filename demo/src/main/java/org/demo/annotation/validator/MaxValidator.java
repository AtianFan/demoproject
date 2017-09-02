package org.demo.annotation.validator;

import java.lang.reflect.Field;

import org.demo.annotation.customeranno.Max;
import org.demo.annotation.exception.ValidatorException;

public class MaxValidator extends AbstractValidator {

	@Override
	public <T> void validateField(T t, Field f) {
		if (f.isAnnotationPresent(Max.class)) {
			try {
				f.setAccessible(true);
				Object value = f.get(t);
				if (value instanceof Short || value instanceof Integer
						|| value instanceof Long) {
					long val = f.getAnnotation(Max.class).value();
					if (Long.valueOf(value.toString()) > val) {
						throw new ValidatorException(f.getName()
								+ "value is greater than " + val);
					}
				} else {
					throw new ValidatorException(f.getName() + " is not number.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
