package org.mtd.messenger.exception;

/**
 * Class used for Exception Mapper template.
 */
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7755562844006828407L;
	
	public DataNotFoundException(String message){
		super(message);
	}
	
}
