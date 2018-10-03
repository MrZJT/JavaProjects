package Laboratory6;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SerialCustomerCartCheck {

	@Test
	public void test() throws FileNotFoundException, IOException, CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException, ClassNotFoundException {
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream( new FileInputStream("C:/Users/Josef Haydn/Desktop/xkcd1.txt"));
			Database xk=(Database) in.readObject();
			//xk.runagain();
			xk.getRoot().getCustomer("Torres").getCartprint();
			xk.getRoot().getCustomer("Mahrez").getCartprint();
			//ThrowCannotDeleteException T1=new ThrowCannotDeleteException(xk,"E>S>O");
			ObjectOutputStream out=null;
			try {
				
				out=new ObjectOutputStream(
						new FileOutputStream("C:/Users/Josef Haydn/Desktop/xkcd1.txt"));
				out.writeObject(xk);
			}
			catch(EOFException e) {
				
			}
			finally {
				if(out!=null) {
					out.close();
				}
			}
		}
		catch(EOFException e) {
			
		}
		finally {
			if(in!=null) in.close();
		}
		
	}

}
