package org.demo.annotation.validator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @description 作为校验器的基类 <br>
 * @author atian <br>
 * @date Sep 2, 2017 <br>
 */
public abstract class AbstractValidator {
	public <T, E> void validate(T t, E e) {
		if (e instanceof Field) {
			Field f = (Field) e;
			validateField(t, f);
		} else if (e instanceof Method) {
			Method m = (Method) e;
			validateMethod(t, m);
		}
	}

	public <T> void validateField(T t, Field f) {
		// TODO implements in subclass
	}

	public <T> void validateMethod(T t, Method m) {
		// TODO implements in subclass
	}
}
