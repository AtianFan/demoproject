package org.demo.annotation.validator;

import java.lang.reflect.Field;

import org.demo.annotation.customeranno.Size;
import org.demo.annotation.exception.ValidatorException;

/**
 * 
 * @description <br>
 * @author atian <br>
 * @date Sep 2, 2017 <br>
 */
public class SizeValidator extends AbstractValidator {
	@Override
	public <T> void validateField(T t, Field f) {
		if (f.isAnnotationPresent(Size.class)) {
			try {
				f.setAccessible(true);
				Object value = f.get(t);
				if (value instanceof Short || value instanceof Integer
						|| value instanceof Long) {
					long max = f.getAnnotation(Size.class).max();
					long min = f.getAnnotation(Size.class).min();
					long val = Long.valueOf(value.toString());
					if (val < min || val > max) {
						throw new ValidatorException(f.getName()
								+ "'value is in the " + min + " to " + max + " range");
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
