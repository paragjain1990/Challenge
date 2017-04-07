package challenge;

import java.util.Scanner;

import org.omg.CORBA.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sample_data {

	public static void main(String args[]) {
		
		
		File f=new File(args[0]);
        
		
		String csvFile = f.getAbsolutePath();
		BufferedReader ber = null;
        String line = "";
        int tot=0;
        
        Shop aShop = new Shop();
        
        try  {
        	
        	ber = new BufferedReader(new FileReader(csvFile));
            while ((line = ber.readLine()) != null)
            {

                // use comma as separator
            	line=line.replace("\"", "");
                String[] country = line.split(",");

                //System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]"+country[2]);
                aShop.addItem(country);
                tot++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] str1=new String[args.length-1] ;
        for(int x=1;x<args.length;x++)
         str1[x-1] =args[x];
        
        	//{"teddy_bear","baby_powder"};
        String[] str2 ={"pampers_diapers ","baby_soap"};
        //aShop.display();
        //System.out.println("Country [code=+\n");
		aShop.display1(str1);
		aShop.groubBy();
		
	
	}
	
	
}
