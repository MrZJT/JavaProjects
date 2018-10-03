package Laboratory6;

import java.io.Serializable;

public class StockNotAvailabel extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -815860008634838874L;

	public StockNotAvailabel(String G) {
		super(G);
	}
}
