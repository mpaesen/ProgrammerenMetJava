package database.exceptions;

import java.sql.SQLException;

public class SQLSyntaxException extends SQLException {
	/**
	 * Constructor for SyntaxException
	 */
	public SQLSyntaxException(String message) {
		super(message);
	}
}

