package Laboratory6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThrowStuffProductIsAlreadyThere{
	
	@Test(expected =AlreadyHasException.class)
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException  {
		Database one=new Database();
		one.getRoot().insert("E>S>O","P");
		one.getRoot().insert("E>S>O", "P");
	}
	

}
