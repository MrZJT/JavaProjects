package Laboratory6;

import java.io.Serializable;

public class product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1257657165030168910L;
	private category myDirectCategory;
	private String Title;
	private int Units;
	private int pricePerUnit;
	private String SeparatingFeature;
	
	public product(String string) {
		// TODO Auto-generated constructor stub
		this.Title=string;
	}
	public product(String string,int Price,int Stock) {
		this.Title=string;
		this.pricePerUnit=Price;
		this.AddToStock(Stock);
	}
	public String getTitle() {
		return this.Title;
	}
	
	public int getStock() {
		return this.Units;
	}
	public void AddToStock(int units) {
		this.Units=this.Units+units;
	}
	public void setPrice(int Price) {
		this.pricePerUnit=Price;
	}
	public int getPrice() {
		return this.pricePerUnit;
	}
	public void sold(int units) {
		if(this.Units<units) {
			System.out.println("WTF NO!??");
		}
		else {
		this.Units=this.Units-units;
		}
	}
	public void sellunits(int x) {
		this.Units=this.Units-x;
	}
	public boolean OutOfStock() {
		if(this.Units==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setMyDirectCategory(category parent) {
		// TODO Auto-generated method stub
		this.myDirectCategory=parent;
		
	}
	public category getMyDirectCategory() {
		return this.myDirectCategory;
	}
}
