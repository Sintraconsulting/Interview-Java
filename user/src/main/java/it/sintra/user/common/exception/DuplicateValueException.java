package it.sintra.user.common.exception;

import org.springframework.http.HttpStatus;

public class DuplicateValueException extends GenericSintraRuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3772596040741046729L;
	
	public DuplicateValueException(String s) {
	    super(400, s);
	  }

	  public DuplicateValueException(String s, Throwable t) {
	    super(s, t);
	    code = (HttpStatus.BAD_REQUEST.value());
	  }

}
