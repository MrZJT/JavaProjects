package Laboratory6;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class CheckSerializationforCustomerCart {

	@Test
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException, FileNotFoundException, IOException {

		ObjectOutputStream out=null;
		ObjectInputStream in=null;
		Database xk=new Database();
		xk.runagain();
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

}
