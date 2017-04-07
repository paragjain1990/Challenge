package challenge;

public class item implements Comparable<item>{

	int aShop_id;
    double aRate;
    String aProduct_Name;
    
    public item(int aShop_id,double aRate,String aProduct_Name)
    {
    	
    	this.aShop_id=aShop_id;
        this.aRate=aRate;
        this.aProduct_Name=aProduct_Name;
    }
    
    public item(item itm) 
    {
    	this.aShop_id = itm.aShop_id;
        this.aRate = itm.aRate;
        this.aProduct_Name = itm.aProduct_Name;
    }
    
    
    public double getShopId() {
        return aShop_id;
    }

    public void setShopId(int aShop) {
        this.aRate = aShop;
        }
    
    
    public double getRate() {
        return aRate;
    }

    public void setRate(double rate) {
        this.aRate = rate;
        }
    
    public String getName() {
        return aProduct_Name;
    }

    public void setName(String name) {
        this.aProduct_Name = name;
    }
    
    @Override
    public String toString() {
        return "Item [Shop_id=" + aShop_id + ", rate=" + aRate + ", Product_Name=" + aProduct_Name + "]";
    }
    
    public int compareTo(item it){  
    	if(aShop_id==it.aShop_id)  
    	return 0;  
    	else if(aShop_id>it.aShop_id)  
    	return 1;  
    	else  
    	return -1;  
    	}  

}
