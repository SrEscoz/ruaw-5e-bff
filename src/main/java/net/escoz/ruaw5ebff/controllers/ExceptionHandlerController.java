package net.escoz.ruaw5ebff.controllers;

import net.escoz.ruaw5ebff.controllers.dtos.ErrorDTO;
import net.escoz.ruaw5ebff.exceptions.SpellNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {SpellNotFoundException.class})
	protected ResponseEntity<ErrorDTO> handleNotFoundException(Exception exception) {
		ErrorDTO response = ErrorDTO.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.NOT_FOUND.value())
				.error(exception.getMessage())
				.build();

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(response);
	}

}