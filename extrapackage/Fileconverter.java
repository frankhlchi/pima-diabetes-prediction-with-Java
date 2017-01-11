package extrapackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fileconverter {
	
	
	
	
	
	public Fileconverter(File abc) {
		// TODO Auto-generated constructor stub
	}

	public double[][] Fileconveter(File input) throws FileNotFoundException{
		
		
		
		Scanner count  = new Scanner(input);
		int linenum = 0;
		while(count.hasNextLine()){
			linenum = linenum+1;
			count.nextLine();
		}
				
		
		
		
		double[][] data = new double[linenum][8];
		Scanner line = new Scanner(input);
		int rownum =0;
	    while(line.hasNextLine()){
	    
	    	
	    	String temp = line.nextLine();
	        Scanner scanner = new Scanner(temp);
	        scanner.useDelimiter(",");
	        int colnum =0;
	        
	        while (scanner.hasNext()) 
	        {
	        	String a = scanner.next();
	        	a= a.trim();
	            System.out.println(Double.parseDouble(a));
	            data[rownum][colnum]=Double.parseDouble(a);
	            colnum =colnum+1;
	        }
            rownum = rownum+1;
	        scanner.close();
	    }
		return data;		
	}

}
