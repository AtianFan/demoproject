package org.demo.annotation.validator;

import org.demo.annotation.ValidatorType;

/**
 * 生成Validator的工厂类 <br>
 * @description <br>
 * @author atian <br>
 * @date Sep 2, 2017 <br>
 */
public class ValidatorFactory {
	public static AbstractValidator createValidator(ValidatorType type) {
		switch (type) {
		case Null:
			return new NullValidator();
		case NotNull:
			return new NotNullValidator();
		case Min:
			return new MinValidator();
		case Max:
			return new MaxValidator();
		case Size:
			return new SizeValidator();
		default:
			return null;
		}
	}
}
