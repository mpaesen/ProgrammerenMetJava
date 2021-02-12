/** 
 *  Exercise : 		Opdracht3 : Ontwerpen met java
 *  FileName :   	Adres.java
 *  @author Pascal Sempels 
 *  @version Revision : 1.0  date : 06/02/2010
 *  
 *  DAOException.java :ExceptionClasse die wordt gebruikt voor DAO-toepassingen 
 *  // overgenomen van ondervermelde site
 */package Persistentie;

/**
 * This class represents a generic DAO exception. It should wrap any exception of the underlying
 * code, such as SQLExceptions.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */

public class DAOException extends Exception {

    // Constructors -------------------------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a DAOException with the given detail message.
     * @param message The detail message of the DAOException.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructs a DAOException with the given root cause.
     * @param cause The root cause of the DAOException.
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a DAOException with the given detail message and root cause.
     * @param message The detail message of the DAOException.
     * @param cause The root cause of the DAOException.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}

