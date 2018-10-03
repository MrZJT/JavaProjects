package Laboratory6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DEMAIN {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream( new FileInputStream("C:/Users/Josef Haydn/Desktop/xkcd1.txt"));
			Database xk=(Database) in.readObject();
			xk.runagain();
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
