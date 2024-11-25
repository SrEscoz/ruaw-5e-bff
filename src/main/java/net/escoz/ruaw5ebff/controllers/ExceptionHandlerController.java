package net.escoz.ruaw5ebff.controllers;

import net.escoz.ruaw5ebff.controllers.dtos.ErrorOutDTO;
import net.escoz.ruaw5ebff.exceptions.ClassNotFoundException;
import net.escoz.ruaw5ebff.exceptions.MagicSchoolNotFoundException;
import net.escoz.ruaw5ebff.exceptions.SpellConflictException;
import net.escoz.ruaw5ebff.exceptions.SpellNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {
			SpellNotFoundException.class,
			MagicSchoolNotFoundException.class,
			ClassNotFoundException.class
	})
	protected ResponseEntity<ErrorOutDTO> handleNotFoundExceptions(Exception exception) {
		return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {SpellConflictException.class})
	protected ResponseEntity<ErrorOutDTO> handleConflictExceptions(Exception exception) {
		return buildResponse(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
	                                                              @NonNull HttpHeaders headers,
	                                                              @NonNull HttpStatusCode status,
	                                                              @NonNull WebRequest request) {

		ErrorOutDTO response = ErrorOutDTO.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.BAD_REQUEST.value())
				.errors(exception.getBindingResult().getAllErrors().stream()
						.map(ObjectError::getDefaultMessage)
						.toList())
				.build();

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	private ResponseEntity<ErrorOutDTO> buildResponse(String message, HttpStatus status) {
		ErrorOutDTO response = ErrorOutDTO.builder()
				.timestamp(Instant.now().toString())
				.status(status.value())
				.error(message)
				.build();

		return ResponseEntity
				.status(status)
				.body(response);
	}
}