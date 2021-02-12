package database.exceptions;

import java.sql.SQLException;

public class SyntaxException extends SQLException{
	/**
	 * Constructor for SyntaxException
	 */
	public SyntaxException(String message) {
		super(message);
	}
}

