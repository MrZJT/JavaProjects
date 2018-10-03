package Laboratory6;

import java.io.Serializable;

public class CustomerNotFoundException extends Exception implements Serializable{
		public CustomerNotFoundException(String XJ) {
			super(XJ);
		}
}
