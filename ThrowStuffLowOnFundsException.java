package Laboratory6;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.junit.Test;

public class ThrowStuffLowOnFundsException {

	@Test(expected = LowOnFundsException.class)
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException, IOException, ClassNotFoundException {
		Database one=new Database();
		one.getRoot().insert("C>J","P");
		product jellybean=new product("J",1,300);
		customer boy=new customer(0);
		boy.AddProductToCart(jellybean, 1); 
		one.getRoot().CheckOut(boy);
		
	}
}
