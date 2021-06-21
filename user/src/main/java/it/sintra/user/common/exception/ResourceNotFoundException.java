package it.sintra.user.common.exception;

public class ResourceNotFoundException  extends RuntimeException{



    /**
	 * 
	 */
	private static final long serialVersionUID = -6126841385351397791L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
