package com.avengers.fc.exception;

public class ForecastException extends Exception {

	private static final long serialVersionUID = 1L;

	public ForecastException() {
	}

	public ForecastException(String error) {
		super(error);
	}

	public ForecastException(Throwable cause) {
		super(cause);
	}

	public ForecastException(String error, Throwable cause) {
		super(error, cause);
	}

}
