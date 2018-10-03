package Laboratory6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThrowStuffCustomerNotFound {

	@Test(expected =CustomerNotFoundException.class)
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		
		Database one=new Database();
		customer xkcd=new customer();
		one.getRoot().CheckifIhave(xkcd);
		
		}

}
