package Laboratory6;

import java.io.Serializable;

public class LowOnFundsException extends Exception implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		LowOnFundsException(String L){
			super(L);
		}
}
