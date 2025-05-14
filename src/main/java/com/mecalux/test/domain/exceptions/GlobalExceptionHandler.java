package com.mecalux.test.domain.exceptions;

import com.mecalux.test.domain.dto.ApiErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO handleIllegalArgument(IllegalArgumentException ex) {
		return new ApiErrorDTO(HttpStatus.BAD_REQUEST, "INVALID_ARGUMENT", ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
		final StringBuilder errorMessage = new StringBuilder("Validation failed for fields: ");
		ex.getBindingResult().getFieldErrors().forEach(error -> errorMessage.append(error.getField()).append(" (")
				.append(error.getDefaultMessage()).append("), "));
		if (!errorMessage.isEmpty()) {
			errorMessage.setLength(errorMessage.length() - 2);
		}
		return new ApiErrorDTO(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", errorMessage.toString());
	}

}
