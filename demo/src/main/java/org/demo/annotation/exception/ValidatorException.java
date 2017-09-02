package org.demo.annotation.exception;

public class ValidatorException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6660119654754929953L;

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ValidatorException(Throwable throwable) {
		super(throwable);
	}
}
