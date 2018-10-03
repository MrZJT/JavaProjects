package Laboratory6;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ThrowStuffStockNotAvailable {
	
	@Test(expected = StockNotAvailabel.class)
	public void test() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException, IOException, ClassNotFoundException {
		Database one=new Database();
		one.getRoot().insert("C>J","P");
		product jellybean=new product("J",1,0);
		customer boy=new customer(100000);
		boy.AddProductToCart(jellybean, 2); 
		one.getRoot().CheckOut(boy);
		
	}

}
