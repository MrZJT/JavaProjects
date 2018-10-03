package Laboratory6;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Database implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private amaconEngine root;

	public Database() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		category directory=new category("root");
		this.root=new amaconEngine(directory);
	}
	public amaconEngine getRoot() {
		return this.root;
	}
//	public static void main(String[] args) throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel {
//		// 1. Administator
//		// 2. Customer
//		// 3. Quit
//			Database database_main=new Database();
//	}
	public void runagain() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		this.starter();
	}

	public void starter() throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		Scanner Cf=new Scanner(System.in);
		customer Customer=new customer(0);
		administrator Admin=new administrator();
		System.out.println(
				"1.Adminstrator\r\n"+
				"a. Insert product/category\r\n" +
				"b. Delete product/category\r\n" +
				"c. Search product\r\n" +
				"d. Modify product\r\n" +
				"e. Exit as Administrator");
		System.out.println(
				"2. As a New Customer\r\n"+
				"a. Add funds (assume all integer operations)\r\n"+
				"b. Add product to the cart\r\n"+
				"c. Check-out cart\r\n"+
				"d. Exit as Customer"
				);
		System.out.println(
				"3.Registered Customer\r\n"+
				"a. Add funds (assume all integer operations)\r\n"+
				"b. Add product to the cart\r\n"+
				"c. Check-out cart\r\n"+
				"d. Exit as Customer"
				);
		System.out.println(
				"4. To Exist the entire system.");

		int UserAccessKey=UserAccessInput();
		try{
		if(UserAccessKey==2) {
			System.out.println("Welcome New Customer :");
			customer Customer1=new customer();
			System.out.println("Set Your User Name!");
			String UserName=Cf.next();
			Customer1.setCID(UserName);
			System.out.println("Continue!");
			MainCaller(2,Admin,Customer1);
		}
		else if(UserAccessKey==3) {
			System.out.println("Please Enter your Customer ID :");
			String custIDInputValue=Cf.nextLine();
			customer RegCust=this.getRoot().getCustomer(custIDInputValue);
			System.out.println("Welcome :"+RegCust.getCID());
			MainCaller(3,Admin,RegCust);}

		else if(UserAccessKey==4) {

			}

		else {
			MainCaller(UserAccessKey,Admin,Customer);
			}

		}
		catch(CustomerNotFoundException B){
			System.out.println(B.toString());
			this.starter();
		}

	}

	public void MainCaller(int UserAccessKey,administrator Admin,customer Customer) throws CannotDeleteException, AlreadyHasException, LowOnFundsException, StockNotAvailabel, CustomerNotFoundException {
		//while(true) {

			Scanner Cf=new Scanner(System.in);
			try {
			if(UserAccessKey==1) {
//				System.out.println("a. Insert product/category\r\n" +
//						"b. Delete product/category\r\n" +
//						"c. Search product\r\n" +
//						"d. Modify product\r\n" +
//						"e. Exit as Administrator");
				//enter as admin first
				String Function=Cf.next();
				CallerFunctions(1,Function,Admin,Customer);
				//break;
			}
			else if(UserAccessKey==2) {
				//enter as customer first
				String Function=Cf.next();
				CallerFunctions(2,Function,Admin,Customer);
				//break;
			}
			else if(UserAccessKey==3) {
				String Function=Cf.next();
				CallerFunctions(2,Function,Admin,Customer);

			}

			else {
				System.out.println("You have only two choices!!");
				UserAccessKey=UserAccessInput();
				MainCaller(UserAccessKey,Admin,Customer);
				//break;
			}

			//break;
		}

		catch (CannotDeleteException X){
			System.out.println(X.toString());
//			System.out.println("Please Input valid strings!");
			MainCaller(UserAccessKey,Admin,Customer);
			return;
		}
		catch (AlreadyHasException E) {
			System.out.println(E.toString());
			MainCaller(UserAccessKey,Admin,Customer);
			return;
		}
		catch (NoProductException R) {
			System.out.println(R.toString());
			MainCaller(UserAccessKey,Admin,Customer);
			return;
		}
		catch (LowOnFundsException L) {
				System.out.println(L.toString());
				MainCaller(UserAccessKey,Admin,Customer);
				return;
		}
		catch(StockNotAvailabel G) {
			System.out.println(G.toString());
			MainCaller(UserAccessKey,Admin,Customer);
		return;
			}
		catch(ProductNotFoundException M) {
			System.out.println(M.toString());
			MainCaller(UserAccessKey,Admin,Customer);
			return;
		}
		catch(CustomerNotFoundException B) {
			System.out.println(B.toString());
			MainCaller(UserAccessKey,Admin,Customer);
			return;
		}

		return;
	}
	public void CallerFunctions(int Key,String function,administrator Admin,customer Customer) throws CannotDeleteException, AlreadyHasException, NoProductException, LowOnFundsException, StockNotAvailabel, ProductNotFoundException, CustomerNotFoundException {
		Scanner Cf=new Scanner(System.in);
		if(Key==1) {

			if(function.equals("a")) {
				//insert category/product
				String CorP=Cf.nextLine();
				System.out.println("As Category or As Product");
				String CorPActual=Cf.nextLine();
				this.getRoot().insert(CorP,CorPActual);
				MainCaller(Key,Admin,Customer);

			}
			else if(function.equals("b")) {
				String CorP=Cf.nextLine();
				this.getRoot().MakeShiftDeleteOperation(CorP);
				
				MainCaller(Key,Admin,Customer);


			}
			else if(function.equals("c")) {
				String CorP=Cf.nextLine();
				this.getRoot().searchdatabase(CorP);
				
				MainCaller(Key,Admin,Customer);


			}
			else if(function.equals("d")) {
				try {
				System.out.println("Enter Product's Title");
				String ProductOnly=Cf.nextLine();
				System.out.println("Enter Product's Price Per Unit");
				String PricePerUnit=Cf.nextLine();
				System.out.println("Enter Number of Product Units to Add to Stock");
				String StockAddition=Cf.nextLine();
				this.getRoot().modify(ProductOnly,PricePerUnit,StockAddition);
				System.out.println("The Details of "+ProductOnly+" Has Been Modified.");
				}
				catch (Exception iggi) {
					System.out.println("Numbers Only :/");
				}finally {
				MainCaller(Key,Admin,Customer);
				}

			}
			else if(function.equals("e")) {
				System.out.println("Exiting as Admin.");
				starter();
				System.out.println("database has returned!");

			}
			else {
				System.out.println("No fuctionality found for given input!");
				MainCaller(Key,Admin,Customer);


			}

		}
		else if(Key==2) {

//			customer SickCust=new customer();
//			System.out.println("You Have Been registered a new customer!");
//			System.out.println("User ID: "+SickCust.getCID());

			if(function.equals("a")) {
				try {
				//Add funds
				//handle exceptions here!
				System.out.println("Enter Funds to Add to your account!");
				int Money=Cf.nextInt();
				Customer.AddFunds(Money);
				System.out.println(Money+" has been Added to your Account.");
				}
				catch(Exception CJ) {
					System.out.println(CJ.toString());
					System.out.println("Numbers Only!?");
					}
				finally {
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
				}
			}

			else if(function.equals("b")) {
				//Add Products To Cart

				String whichProduct=Cf.nextLine();
				System.out.println("How Many Units!");
				int Howmuchofit=Cf.nextInt();

				product iffound=this.getRoot().search(whichProduct);

				if(whichProduct.equals(iffound.getTitle())) {

					Customer.AddProductToCart(iffound,Howmuchofit);
				}
				System.out.println("Product: "+iffound.getTitle()+" Has been Added. With Requested Quantity Of: "+Howmuchofit+" Units.");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
			}
			else if(function.equals("c")) {
				//Check Out Cart
				System.out.println("Checking out:");
				this.getRoot().CheckOut(Customer);
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);

			}
			else if(function.equals("d")) {
				System.out.println("Exiting as Customer.");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				this.starter();
			}
			else {
				System.out.println("No fuctionality found for given input!");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
			}

			}
		else if(Key==3) {
			if(function.equals("a")) {
				try {
				//Add funds
				//handle exceptions here!
				System.out.println("Enter Funds to Add to your account!");
				int Money=Cf.nextInt();
				Customer.AddFunds(Money);
				System.out.println(Money+" has been Added to your Account.");
				}
				catch(Exception CJ) {
					System.out.println(CJ.toString());
					System.out.println("Numbers Only!?");
					}
				finally {
					this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
				}

			}

			else if(function.equals("b")) {
				//Add Products To Cart

				String whichProduct=Cf.nextLine();

				int Howmuchofit=Cf.nextInt();
				product iffound=this.getRoot().search(whichProduct);

				if(whichProduct.equals(iffound.getTitle())) {

					Customer.AddProductToCart(iffound,Howmuchofit);
				}
				System.out.println("Product: "+iffound.getTitle()+" Has been Added. With Requested Quantity Of: "+Howmuchofit+" Units.");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
			}
			else if(function.equals("c")) {
				//Check Out Cart
				System.out.println("Checking out:");
				this.getRoot().CheckOut(Customer);
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);

			}
			else if(function.equals("d")) {
				System.out.println("Exiting as Customer.");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				starter();
			}
			else {
				System.out.println("No fuctionality found for given input!");
				this.getRoot().DatabaseOfCustomer.put(Customer.getCID(),Customer);
				MainCaller(Key,Admin,Customer);
			}
		}

		else {
			System.out.println("Invalid Input ???");
			CallerFunctions(Key,function,Admin,Customer);

		}

	}
	public int UserAccessInput() {
		Scanner Cf=new Scanner(System.in);
		try {
			int rtx=Cf.nextInt();
			return rtx;
		}
		catch (InputMismatchException x) {
			System.out.println("Please Enter Only Integers");
			return UserAccessInput();
		}
	}









}
