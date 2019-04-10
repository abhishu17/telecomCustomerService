package com.telecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class NumberAlreadyActivatedException extends RuntimeException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public NumberAlreadyActivatedException(String phoneNumber) {
    super("Number already activated "+ phoneNumber);
  }

}