package com.back.exceptionhandler;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BackExceptionHandler extends ResponseEntityExceptionHandler{

	/** Tratamento de exceção para a tentativa de remover um usuario inexistente.
	 * Altera o status de 500 para 404 */
	@ExceptionHandler({InvalidDataAccessApiUsageException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleInvalidDataAccessApiUsageException(RuntimeException ex) {	}

}
