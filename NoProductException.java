package Laboratory6;

import java.io.Serializable;

public class NoProductException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7927111170756446236L;

	public NoProductException(String Exc) {
		super(Exc);
	}

}
