package Laboratory6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.SynchronousQueue;

import javax.print.StreamPrintService;

public class amaconEngine implements Serializable{
//wolfgang05
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected category root;
	protected int MyDatabaseSize;
	protected int AHelpfulNumber=0;
	protected int AnotherHelpfulNumber=0;
	
	protected HashMap<String, customer> DatabaseOfCustomer;
	amaconEngine(category skat){
		this.root=skat;
		this.DatabaseOfCustomer=new HashMap<String,customer>();
	}
	
	//1   a.insert
	public LinkedList<String> insert(String jinx,String CorP) throws AlreadyHasException {
	
		LinkedList<String> List1=new LinkedList<>();
		String atv="";
		for(int i=0;i<jinx.length();i++) {
			if(jinx.charAt(i)=='>') {
				List1.addLast(atv);
				//System.out.println(atv);
				atv="";
			}
			else {
			atv=atv+jinx.charAt(i);
			}
			
		}
		//List1.addLast(atv);
		if(CorP.equals("P")) {
		product x=new product(atv);
		add(List1,x);
		 }
		else if(CorP.equals("C")) {
			category x=new category(atv);
			add(List1,x);
			return List1; 
		}
		//System.out.println(List1);
		return List1; 
		
	
	}
	public void add(LinkedList<String> KatLocate,category x) throws AlreadyHasException{
		category found=this.searchKats(x.getTitle());
		if(found==null) {
			//System.out.println("yeh!");
			//this.add
			if(KatLocate.size()==0) {
				this.root.AddCategory(x);
			}else {
			this.add_(this.root, KatLocate, x);
			}
			}
		else {
			if(this.checktheconnection(KatLocate,found.getMyDirectCategory().getTitle(),found.getMyDirectCategory())) {
				throw new AlreadyHasException("Sorry,category is already registered under these categories!");
			}
			else {
				if(KatLocate.size()==0) {
					this.root.AddCategory(x);
				}else {
				this.add_(this.root, KatLocate, x);
				}
			}
		}
	}
	public void add(LinkedList<String> KatLocate,product x) throws AlreadyHasException {
		//If the database already has that product
		//under that category then program should raise a custom exception
		product found=this.search(x.getTitle());
	
		
		
		if(found==null) {
			System.out.println("ADDING...");
			if(KatLocate.size()==0) {
				this.root.AddProducts(x);
			}else {
			this.add_(this.root, KatLocate, x);
			}
		}
		else {
			//found.getMyDirectCategory().getTitle().equals(KatLocate.getLast())
			if(this.checktheconnection(KatLocate,found.getMyDirectCategory().getTitle(),found.getMyDirectCategory())) {
				//this.checktheconnection(KatLocate,found.getTitle(),found.getMyDirectCategory());
				throw new AlreadyHasException("Sorry,product is already registered under this category");
			}
			else {
				System.out.println("");
				
				if(KatLocate.size()==0) {
					x.setPrice(1);
					x.AddToStock(1);
					this.root.AddProducts(x);
				}
				
				else {
					this.add_(this.root, KatLocate, x);
					}
			}
		}
		
		}
	public boolean checktheconnection(LinkedList<String> KatLocate, String foundKats,category parent) {
		if(KatLocate.getLast().equals(foundKats)) {
			
			KatLocate.removeLast();
			for(int i=0;i<KatLocate.size();i++) {
				String one=KatLocate.getLast();
				String two=parent.getMyDirectCategory().getTitle();
				if(!one.equals(two)) {				
					return false;
				}
			}
			return true;
		}
		return false;
		
	}
	

	private void add_(category parent,LinkedList<String> KatLocate,Object x) {
		
		if(parent.HasElement(KatLocate.getFirst())){
			//System.out.println(parent.getTitle());
			
			
			
			String jinx=KatLocate.getFirst();
			category Katsnew=new category(jinx);
			
			
			
			
			parent=parent.getSubCategory(KatLocate.getFirst());
			
			
			KatLocate.removeFirst();
			
			
		
			if(KatLocate.size()==0) {
				if(x instanceof product) {
			
				product xy=(product) x;
				parent.AddProducts(xy);
				xy.setMyDirectCategory(parent);
				return;
				}
				else if(x instanceof category) {
					category xy=(category) x;
					parent.AddCategory(xy);
					xy.setMyDirectCategory(parent);
					return;
				}
			}
			else {
			
				this.add_(parent,KatLocate,x);
			}
			
			
		}
		else {
			String jinx=KatLocate.getFirst();
			category Katsnew=new category(jinx);
			//if(parent==this.root) System.out.println("WHATDDD!");
			parent.AddCategory(Katsnew);
			Katsnew.setMyDirectCategory(parent);
			add_(parent,KatLocate,x);
		}
	}
	

	
	public void MakeShiftDeleteOperation(String Path) throws CannotDeleteException {
		LinkedList<String> PathFinder=new LinkedList<String>();
		String atv="";
		for(int i=0;i<Path.length();i++) {
			if(Path.charAt(i)=='>') {
				PathFinder.addLast(atv);
				
				atv="";
			}
			else {
			atv=atv+Path.charAt(i);
			}
			
		}
	
		PathFinder.addLast(atv);
		System.out.println(PathFinder);
		delete(PathFinder);
	}
	public void delete(LinkedList<String> PathFinder) throws CannotDeleteException {
		
		this.Delete(this.root,PathFinder);
	}
	
	public void Delete(category parent,LinkedList<String> PathFinder) throws CannotDeleteException
	{	
		System.out.println(PathFinder);
		boolean RightThing=false;
		if(PathFinder.size()>1) {
			for(int i=0;i<parent.getMycategories().size();i++) {
				System.out.println(parent.getTitle()+" this is my title!!");
				if(parent.getMycategories().get(i).getTitle().equals(PathFinder.getFirst())) {
					RightThing=true;
					PathFinder.removeFirst();
					this.Delete(parent.getMycategories().get(i), PathFinder);
					break;
				}
			}
			if(RightThing==false) {
				throw new CannotDeleteException("We don't have this?!!");
			}
		}
		if(PathFinder.size()==1) {
			if(parent.HasProduct(PathFinder.getFirst())) {
				parent.deleteProduct(PathFinder.getFirst());
				PathFinder.removeFirst();
				System.out.println(PathFinder.size());
				System.out.println("The specified Product has been deleted!");
				
			}
			else {
				throw new CannotDeleteException("We don't have this! checked!");
			}
		}
		
	}
	
	//////////////////////////////////////////////////////
	//3 c.Search
	
	public product search(String CorP) {
		product bell=search_(this.root,CorP);
		
		return bell;
	}

	public product searchdatabase(String CorP) throws NoProductException {
		product bell=search_(this.root,CorP);
		//exception handling here :D!!
		if(bell==null) {
			throw new NoProductException("There is no such product!");
		}
		this.CallForDetails(bell);
		return bell;
	}
	private void CallForDetails(product bell) {
		// TODO Auto-generated method stub
		LinkedList<String> Path=this.CallForPath(bell);
		System.out.println(
				"Product Name :"+bell.getTitle()+"\r\n"+
				"Price Per Unit :"+bell.getPrice()+"\r\n"+
				"Stock Availabel :"+bell.getStock()+"\r\n"
				);
		for(int i=0;i<Path.size();i++) {
			System.out.print(Path.get(i)+"=>");
		}
		System.out.println(" END");
		
	}

	private LinkedList<String> CallForPath(product bell) {
		// TODO Auto-generated method stub
		LinkedList<String> Path=new LinkedList<String>();
		Path.addFirst(bell.getTitle());
		category bella=bell.getMyDirectCategory();
		while(true) {
			if(bella.getTitle().equals(this.root.getTitle())) {
				break;
			}
			Path.addFirst(bella.getTitle());
			bella=bella.getMyDirectCategory();
			
		}
		return Path;
		
	}

	public product search_(category parent,String CorP) {
		if(parent.HasProduct(CorP) || parent.HasElement(CorP)) {
			//System.out.println("IS SOMETHING HERE???!!");
			return parent.getProduct(CorP);
		}
		else {
			if(parent.getMycategories().size()!=0) {
				
				product minix1=null;
				int sz=parent.getMycategories().size();
				for(int i=0;i<sz;i++) 
				{	minix1= this.search_(parent.getMycategories().get(i),CorP);
					if(minix1!=null) {
						return minix1;
					}
				}
				
				
				return null;
				}			
		
		return null;	
		}
		
		
		
	}
	/////////////////////////////////////////////////////////////////
	
	public void modify(String Title,String PricePerUnit,String NumberOfUnitsToAdd) throws ProductNotFoundException {
		product bell=this.search(Title);
		if(bell==null) {
			throw new ProductNotFoundException("not allowed!");
		}
		else {
			
		bell.AddToStock(Integer.parseInt(NumberOfUnitsToAdd));
		bell.setPrice(Integer.parseInt(PricePerUnit));
		// this.modify_(this.root,CORP);
		}
	}
	
	public int sale(product x,int quantity, int remaining_funds_with_customer) throws StockNotAvailabel, LowOnFundsException {
		int Price=x.getPrice();
		int Availabel=x.getStock();
		int MoneyToBuy=remaining_funds_with_customer;
		if( (Availabel> quantity && quantity*Price<MoneyToBuy )|| 
				(Availabel == quantity && quantity*Price<MoneyToBuy )	||
	(Availabel> quantity && quantity*Price==MoneyToBuy )|| 
	(Availabel == quantity && quantity*Price==MoneyToBuy )
				) {
			this.search(x.getTitle()).sellunits(quantity);
			return 1;
		}
		else if(Availabel<quantity){
			return -1;
			
		}
		else if((Availabel>quantity && MoneyToBuy<quantity*Price )|| (Availabel==quantity && MoneyToBuy<quantity*Price)) {
			return -2;
			
		}
		else {
			return 0;
		}
		
	}
	
	public category searchKats(String sKat) {
		return this.find_(this.root,sKat);
	}
	
	
	private category find_(category Kat,String sKat) {
		
		if(Kat.HasElement(sKat) //|| Kat.HasProduct(sKat)
				) {
			return Kat.HasElementR(sKat);
		}
		else {
			if(Kat.getMycategories().size()!=0) {
				for(int i=0;i<Kat.getMycategories().size();i++) {
					//System.out.println(Kat.getTitle());
				return this.find_(Kat.getMycategories().get(i),sKat);
				} 
			}
			
			else {
				return null;
					}
		} 
		return null;  }
	

	
	public void CheckifIhave(customer Customer) throws CustomerNotFoundException {
		boolean dosomething=false;
		for(Entry<String, customer> Key: this.DatabaseOfCustomer.entrySet()) {
			if(Key.getValue().getCID().equals(Customer.getCID())) {
				dosomething=true;
			}
		
		}
		if(dosomething==false) {
			throw new CustomerNotFoundException("No associated customer found");
		}
	}
	
	
	public void CheckOut(customer customer) throws LowOnFundsException, StockNotAvailabel {
		// TODO Auto-generated method stub
		
		for(product key: customer.getCart().keySet()) {
			System.out.println("This is here!");
			int Decide=this.sale(key,customer.getCart().get(key).intValue(), customer.getFunds());
			if(Decide==1) {
				System.out.println(customer.getFunds());
				customer.deductFunds(key.getPrice()*customer.getCart().get(key).intValue());
				//dedcutfundsss!!
				System.out.println(customer.getFunds());
				
			}
			else if(Decide==-1) {
				customer.CheckOut();
				customer.ClearCart();
				throw new StockNotAvailabel("Stock Not Available!"); 
			}
			else if(Decide==-2) {
				//System.out.println("Hello this is here!!!!!");
				customer.CheckOut();
				customer.ClearCart();
				throw new LowOnFundsException("Customer is Low on funds!");
			}
		}
		//customer.ClearCart();
		customer.CheckOut();
	}

	public customer getCustomer(String custIDInputValue) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		for(String key: this.DatabaseOfCustomer.keySet()) {
			if(this.DatabaseOfCustomer.get(key).getCID().equals(custIDInputValue)) {
				return this.DatabaseOfCustomer.get(key);
			}
		}
		throw new CustomerNotFoundException("Customer Not Found,Boards Of Canada Reference is Invalid here");
	}

	public void AddProductToThisCustomersCart(customer x, String product, int quantity) throws ProductNotFoundException {
		product prox=this.search(product);
		if(prox==null) {
			throw new ProductNotFoundException("Invalid Product!");
		}
		else {
			this.DatabaseOfCustomer.get(x.getCID()).AddProductToCart(prox, quantity);
		}

		
	}
	
	
	

}
