package it.sintra.user.common.exception;

import org.springframework.http.HttpStatus;

public class CorruptImageException extends GenericSintraRuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -558518616893013845L;
	
	public CorruptImageException(String s) {
	    super(400, s);
	  }

	  public CorruptImageException(String s, Throwable t) {
	    super(s, t);
	    code = (HttpStatus.BAD_REQUEST.value());
	  }

}
