package Laboratory6;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
public class customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<product,Integer> MyCart;
	private int RemainingFunds;
	private String custID;
	private int AHelpfulNumber=0;
	public customer(){
		this.MyCart=new HashMap<>();
		this.RemainingFunds=0;
		this.custID="cust"+AHelpfulNumber;
		this.AHelpfulNumber++;
	}
	public customer(int Money){
		this.MyCart=new HashMap<>();
		this.RemainingFunds=Money;
		this.custID="cust"+AHelpfulNumber;
		this.AHelpfulNumber++;
	}
	public String getCID() {
		return this.custID;
	}
	public void AddProductToCart(product LetsBuy,int quantity) {
		//handle exceptions here
		this.MyCart.put(LetsBuy,quantity);
	}
	public HashMap<product,Integer> getCart(){
		return this.MyCart;
	}
	public void CheckOut() {
		
		
	}
	public void ClearCart() {
		this.MyCart=new HashMap<>();
	}
	public int getFunds() {
		return this.RemainingFunds;
	}
	public void deductFunds(int deduction) {
		this.RemainingFunds=this.RemainingFunds-deduction;
	}
	public void AddFunds(int x) {
		this.RemainingFunds=x+this.RemainingFunds;
	}
	public void setCID(String userName) {
		// TODO Auto-generated method stub
		this.custID=userName;
	}
	public void getCartprint() {
		// TODO Auto-generated method stub
		for(Entry<product, Integer> key: this.MyCart.entrySet()) {
			System.out.println();
			System.out.print(key.getKey().getTitle()+" ");
			System.out.print(this.MyCart.get(key.getKey()));
			System.out.println();
		}
		
	}
	

		}
