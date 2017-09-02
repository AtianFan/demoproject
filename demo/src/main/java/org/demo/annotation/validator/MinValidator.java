package org.demo.annotation.validator;

import java.lang.reflect.Field;

import org.demo.annotation.customeranno.Min;
import org.demo.annotation.exception.ValidatorException;

public class MinValidator extends AbstractValidator {
	
	@Override
	public <T> void validateField(T t, Field f) {
		if (f.isAnnotationPresent(Min.class)) {
			try {
				f.setAccessible(true);
				Object obj = f.get(t);
				if (obj instanceof Short || obj instanceof Integer 
						|| obj instanceof Long) {
					long minValue = f.getAnnotation(Min.class).value();
					if (Long.valueOf(obj.toString()) > minValue) {
						throw new ValidatorException(f.getName()+"'value is not greater than " + minValue);
					}
				} else {
					throw new ValidatorException(f.getName()
							+ " is not number.");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
