package Laboratory6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThrowStuffCannotBeDelete {

	@Test(expected=CannotDeleteException.class)
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		Database one=new Database();
		one.getRoot().MakeShiftDeleteOperation("E>S>O");
		one.getRoot().MakeShiftDeleteOperation("E>S");
		one.getRoot().MakeShiftDeleteOperation("E>S>O");
		
	
	}

}
