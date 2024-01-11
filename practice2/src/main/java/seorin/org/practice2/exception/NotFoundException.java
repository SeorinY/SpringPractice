package seorin.org.practice2.exception;


import seorin.org.practice2.http.ErrorType;

public class NotFoundException extends BusinessException {

	public NotFoundException(ErrorType errorType) {
		super(errorType);
	}

	public NotFoundException() {
		super(ErrorType.NOT_FOUND_RESOURCE);
	}
}
