package extrapackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KNN {
	
	public KNN(File train, File test,int k) throws FileNotFoundException {
	    k=8;
		ArrayList<Double> diss =new ArrayList();
		ArrayList<Integer>feature = new ArrayList();
		ArrayList<Double> prediction = new ArrayList();
		int rown =0;
		Scanner countfeature  = new Scanner(train);
		String lines =countfeature.nextLine();
		Scanner c =new Scanner(lines);
		c.useDelimiter(",");
		while(c.hasNext()){
			String a =c.next();
			rown =rown+1;
		}
		
		//System.out.print(rown);
		
		Scanner count  = new Scanner(train);
		int linenum = 0;
		while(count.hasNextLine()){
			linenum = linenum+1;
			count.nextLine();
		}
				
		double[][] data = new double[linenum][rown-1];
        ArrayPriorityQueue dis = new ArrayPriorityQueue();
		Scanner line = new Scanner(train);
		int rownum =0;
	    while(line.hasNextLine()){
	    
	    	
	    	String temp = line.nextLine();
	        Scanner scanner = new Scanner(temp);
	        scanner.useDelimiter(",");
	        
	        int colnum =0;
	        
	        while(scanner.hasNext())
	        {   
	        	if(colnum>=rown-1){
	        	String a = scanner.next();
	        	a=a.trim();
	        	//System.out.println(a);
	        	if(a.length()==3){
	        		prediction.add(1.00);
	        	}else{
	        		prediction.add(-1.00);
	        	}
	        	}else
	        	{
	        		
	        	String a = scanner.next();
	        	//System.out.println(a);
	        	a= a.trim();
	        	//System.out.println(a);
	            data[rownum][colnum]=Double.parseDouble(a);
	            colnum =colnum+1;
	        
	        	}
	        }
            rownum = rownum+1;
	        scanner.close();
	        
	    }
		
      /*
       for(int i=0;i<rownum;i++){
    	   System.out.print(i+1+"  ");
        	for(int j=0;j<rown-1;j++){
        		
        		System.out.print(data[i][j]);
        		System.out.print(" ");
        		
        	}
        	System.out.print(prediction.get(i));
        	  System.out.println("");
        	
        }
       */
		//input the test set 
	    Scanner testline = new Scanner(test);
		while(testline.hasNextLine()){
			
			double[] testdata= new double[rown-1];
			
			String temptest = testline.nextLine();
	        Scanner testscanner = new Scanner(temptest);
	        testscanner.useDelimiter(",");
	        int colnum =0;
	        while (testscanner.hasNext())  {
	        	String a = testscanner.next();
	        	a= a.trim();
	        	testdata[colnum]=Double.parseDouble(a); 
	        	//System.out.print(testdata[colnum]+"  ");
	        	 colnum =colnum+1;
	        	}

		    //for(int j=0;j<rown-1;j++){	    
			//	System.out.print(testdata[j]+" ");
		    //}
	        
	        //int [] equality = new int [rown-1];
	        //boolean equal =false;
	        		
	        for(int i=0;i<linenum;i++){	
		    	double distance= 0.00;	
		    	for(int j=0;j<rown-1;j++){
		    		
		    		//System.out.print("train"+ data[i][j] + "  test"+testdata[j]+"  ");
		    		distance =distance + (data[i][j]-testdata[j])*(data[i][j]-testdata[j]);
		          }  

		    	  dis.insert(i, distance); 
		    	  //
		    	  diss.add(distance);
		    }
	     
	        
	        
	    
	        
		    double pre =0.00;    
		    for(int i =0; i<k;i++){
		    	//System.out.print(i);
		    	int  a=dis.min();
		    	//System.out.println(a+" ");
		    	
		    	pre=pre+prediction.get(a);
		    
		    }   	
		    if(pre>0){
		    	//System.out.print(pre);		    	
		    	System.out.println("yes");
		    }else{
		    	System.out.println("no");
			
		}
	        }
		}


}
