package Laboratory6;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 690725180509561432L;

	public ProductNotFoundException(String XC) {
		super(XC);
	}

}
