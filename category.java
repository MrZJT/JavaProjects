package Laboratory6;

import java.io.Serializable;
import java.util.ArrayList;

public class category implements Comparable<category> , Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private int maincate;
	
	
	private category MyDirectCategory;
	
	
	
	private String Title;
	
	
	
	private String cID;
	
	
	private ArrayList<category> MySubCategories;
	
	
	private ArrayList<product> MyProducts;
	
	
	
	private int AHelpfulNumber=0;
	 
	String PredTitle;
	 
	public category(String Title) {
		
		this.Title=Title;
		this.cID="cate"+AHelpfulNumber;
		this.MySubCategories=new ArrayList<>();
		this.MyProducts=new ArrayList<>();
		this.AHelpfulNumber++;
	}
	
	public ArrayList<category> getMycategories(){
		return this.MySubCategories;
	}
	public ArrayList<product> getMyproducts(){
		return this.MyProducts;
	}
	public category getSubCategory(String title){
		
		for(int i=0;i<this.getMycategories().size();i++){
			if(this.getMycategories().get(i).getTitle().equals(title)) {
				return this.getMycategories().get(i);
			}
		}
		return null;
		
	}
	public String getID() {
		return this.cID;
	}
	public String getTitle() {
		return this.Title;
	}
	public void AddCategory(category other) {
		this.MySubCategories.add(other);
	}
	public void AddProducts(product product) {
		this.MyProducts.add(product);
	}
	public boolean HasElement(String subTitle) {
		for(int i=0;i<this.MySubCategories.size();i++) {
			if(this.MySubCategories.get(i).getTitle().equals(subTitle)) {
				return true;
			}
		}
		return false;
	}
	public category HasElementR(String subTitle) {
		for(int i=0;i<this.MySubCategories.size();i++) {
			if(this.MySubCategories.get(i).getTitle().equals(subTitle)) {
				return this.MySubCategories.get(i);
			}
		}
		return null;
	}

	public void printproducts() {
		for(int i=0;i<this.MyProducts.size();i++) {
			System.out.println(this.MyProducts.get(i).getTitle());
		}
	}
	public boolean HasProduct(String product) {
		for(int i=0;i<this.MyProducts.size();i++) {
			if(this.MyProducts.get(i).getTitle().equals(product)){
				return true;
			}
		}
		return false;
	}

	public void deleteProduct(String CORP) {
		for(int i=0;i<this.MyProducts.size();i++) {
			if(this.MyProducts.get(i).getTitle().equals(CORP)) {
				this.MyProducts.remove(i);
				//this.MyProducts.remove(this.MyProducts.get(i));
			}
		}
		
	}
	
	public product getProduct(String CORP) {
		for(int i=0;i<this.MyProducts.size();i++) {
			if(this.MyProducts.get(i).getTitle().equals(CORP)) {
				return this.MyProducts.get(i);
			}
		}
		return null;
	}
	public void deleteCategory(String CORP) {
		for(int i=0;i<this.getMycategories().size();i++) {
			if(this.getMycategories().get(i).getTitle().equals(CORP)) {
				this.getMycategories().remove(i);
				//this.getMyproducts().remove(this.getMycategories().get(i));
				}
		}
	}

	public void setMyDirectCategory(category parent) {
		this.MyDirectCategory=parent;
	}
	public category getMyDirectCategory() {
		return this.MyDirectCategory;
	}
	
	@Override
	public int compareTo(category other) {
		// TODO Auto-generated method stub
		if(this.getTitle().compareTo(other.getTitle())==1) {
			return 1;
		}
		else if(this.getTitle().compareTo(other.getTitle())==0) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	
	
	
	
	
	
}
