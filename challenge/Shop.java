package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Shop {
	
	public Shop() {
        
        ItemList = new ArrayList<item>();
        
    }
	
	private ArrayList<item> ItemList;
	
	private ArrayList<item> SearchOut= new ArrayList<item>();
	
	public void addItem(String[] str) 
	{
		
        int aShop_id;
        double aRate;
        String aProduct_Name;
        

        //System.out.println(str[0].trim()+"-"+str[1].trim()+"-"+str[2].trim());
        
        aShop_id = Integer.parseInt(str[0].trim());
        aRate = Double.parseDouble(str[1].trim());
        aProduct_Name = str[2].trim();
        item aItem = new item(aShop_id, aRate, aProduct_Name);
        ItemList.add(aItem);
        

    }
	


	public void display()
	{
		
	Iterator<item> itr = ItemList.iterator();
	//item foundItem;
    item itm1;
	    while (itr.hasNext()){
	        itm1 = new item(itr.next());	
	        System.out.println(itm1.aShop_id + "-"+itm1.aRate+"-"+itm1.aProduct_Name);
	    	
		}
	}
	
    public void display1(String[] str) 
    {
        //item foundItem;
       // System.out.println("Enter Item code:");
    	int strLength=str.length;
    	for(String st:str)
        insert(st);
        Collections.sort(SearchOut);
    	Iterator<item> itr1 = SearchOut.iterator();
    	Iterator<item> itr2 = SearchOut.iterator();
    	
    	//item foundItem;
    	
        item itm1;
        int n=0;
        int check[]= new int[SearchOut.size()];
        

    while (itr1.hasNext()){
	        itm1 = new item(itr1.next());	
	        //System.out.println(itm1.aShop_id + "-"+itm1.aRate+"-"+itm1.aProduct_Name);
	    	check[n]=itm1.aShop_id;
	    	n++;
		}
    
	        Map<Integer, Integer> countMap= new HashMap<Integer, Integer>() ;
	        HashSet<item> set = new HashSet<item>(SearchOut);
	        //set = SearchOut.
	        Iterator<item> itr3 = set.iterator();
    	    while (itr3.hasNext()){
    	        int num =0;
    	        itm1 =new item(itr3.next());
    	        int a=itm1.aShop_id;
    	        while (itr2.hasNext()){
        	        itm1 =new item(itr2.next());
        	        if(itm1.aShop_id==a)
        	        {
        	        	num++;
        	        }
        		}
    	        countMap.put(a, num);
    		}
	        

    	    //System.out.println("MAP"+countMap.toString());
    	    while (itr1.hasNext()){
    	        itm1 = new item(itr1.next());	
    	        if(countMap.containsKey(itm1.aShop_id) && countMap.get(itm1.aShop_id)==strLength)
    	        		{ 
    	        System.out.println(itm1.aShop_id + "-"+itm1.aRate+"-"+itm1.aProduct_Name);
    	    	check[n]=itm1.aShop_id;
    	    	n++;}
    		}
    	    
    	   // System.out.println("MAP");
    	    //System.out.println("SearchOut"+ Arrays.toString(check));
    	   // System.out.println("str.length"+str.length);
    	  /*  for (int x=0;x<check.length;x=x+str.length)
    	    {
    	    	for(int y=0;y<str.length;y++)
    	    	{
    	    		if (check[x]!=check[x+y])
    	    		{System.out.println(x);}
    	    		else
    	    			System.out.println("same x "+x +" y "+(x+y));
    	    	}
    	    }*/
        /*
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }*/

        //System.out.println(foundItem.toString());
    }
    
    //@SuppressWarnings("null")
	public void insert(String name) {
        Iterator<item> itr = ItemList.iterator();
        item itm1;
        //item[] ft= new item[tot];
        int n=0;
        while (itr.hasNext()) {
            itm1 = new item(itr.next());
            
            if (itm1.aProduct_Name.equals(name) ) 
            {	//System.out.println(itm1.aProduct_Name +"--"+name);
            	SearchOut.add(itm1);
            	n++;
                            }
        }
        
    }
	public void groubBy()
	{
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for(item item : SearchOut){
		    if(map.containsKey(item.aShop_id)){
		        double q = map.get(item.aShop_id) + item.aRate;
		        map.put(item.aShop_id, q);
		    } else {
		        map.put(item.aShop_id, item.aRate);
		    }
		}
		
		for (Integer key : map.keySet()) {
		   // System.out.println(key + " " + map.get(key));
		}
		
		Double min = Collections.min(map.values());
		//System.out.println(min);
		for (Integer key : map.keySet()) {
			if (map.get(key)==min)
		    System.out.println( key + ", " + map.get(key));
		}
		
	}
	
}
