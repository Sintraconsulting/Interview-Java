package it.sintra.user.common.exception;

public class GenericSintraRuntimeException extends RuntimeException{

	private static final long serialVersionUID = -1671596057181055964L;
	protected Integer code;

	  public GenericSintraRuntimeException(String s) {
	    super(s);
	    code = 500;
	  }


	  public GenericSintraRuntimeException(String s, Throwable throwable) {
	    super(s, throwable);
	    code = 500;
	  }

	  protected GenericSintraRuntimeException(Integer code, String s) {
	    super(s);
	    this.code = code;
	  }
}
