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

public class SerializationCheck {

	@Test(expected=AlreadyHasException.class)
	public void test() throws FileNotFoundException, IOException, CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException, ClassNotFoundException, ProductNotFoundException {
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream( new FileInputStream("C:/Users/Josef Haydn/Desktop/xkcd1.txt"));
			Database xk=(Database) in.readObject();
		
			xk.getRoot().getCustomer("Torres");
			xk.getRoot().getCustomer("Mahrez");
			xk.getRoot().insert("1>2>3","P");
			}
		catch(EOFException e) {
			
		}
		finally {
			if(in!=null) in.close();
		}
	}

}
