package Laboratory6;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class MAIN {
	
	public static void main(String[] args) throws 
	CannotDeleteException, AlreadyHasException, 
	LowOnFundsException, StockNotAvailabel, IOException,
	ClassNotFoundException, CustomerNotFoundException 
	{
		
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
