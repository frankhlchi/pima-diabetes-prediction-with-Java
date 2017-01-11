package extrapackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Naivebayes {
	
	
	/*public static void main (String[] args) throws FileNotFoundException{
		File tra = new File("/Users/chihongliang/Desktop/ai.csv");	  
		File tes = new File("/Users/chihongliang/Desktop/test.csv");	
		Naivebayes(tra,tes);
		
	}
	*/
	
	public Naivebayes(File train, File test) throws FileNotFoundException{
		
		
		final double E =java.lang.Math.E;
		final double PI =java.lang.Math.PI;
		double x = 0;
		double mean =0.00;
		double sd =0.00;
		double pdf= (1/(sd*Math.sqrt(2*PI)))*Math.pow(E,-(x-mean)*(x-mean)/(2*sd*sd));
		
		ArrayList<Integer> prediction = new ArrayList();
		ArrayList<Integer> positivepredict = new ArrayList();
		ArrayList<Integer> negativepredict = new ArrayList();
		
		Scanner count  = new Scanner(train);
		int linenum = 0;
		while(count.hasNextLine()){
			linenum = linenum+1;
			count.nextLine();
		}
				
		double[][] data = new double[linenum][8];
		Scanner line = new Scanner(train);
		int rownum =0;
	    while(line.hasNextLine()){
	    
	    	
	    	String temp = line.nextLine();
	        Scanner scanner = new Scanner(temp);
	        scanner.useDelimiter(",");
	        
	        int colnum =0;
	        
	        while(scanner.hasNext())
	        {   
	        	if(colnum>=8){
	        	String a = scanner.next();
	        	a=a.trim();
				if(a.length()==3){
	        		prediction.add(1);
	        	}else{
	        		prediction.add(-1);
	        	}
	        		
	        		
	        	}else{
	        	String a = scanner.next();
	        	a= a.trim();
	            data[rownum][colnum]=Double.parseDouble(a);
	            colnum =colnum+1;
	        }
	        }
            rownum = rownum+1;
	        scanner.close();
	    }
	    
	    for(int i =0;i<prediction.size();i++){
	    	if(prediction.get(i)>=0){
	    		positivepredict.add(i);
	    	}else{
	    		negativepredict.add(i);
	    	}
	    	
	    }
		
	    double[] meanset  = new double [8];
	    double[] sdset = new double[8];
	    double[] negmeanset  = new double [8];
	    double[] negsdset = new double[8];
	    
	    for(int j =0 ;j<8;j++){
	    for(int i=0;i<positivepredict.size();i++){
	    	meanset[j]= meanset[j]+data[positivepredict.get(i)][j];	
	    }
	        }
	    
	    for(int j =0 ;j<8;j++){
		    for(int i=0;i<negativepredict.size();i++){
		    	negmeanset[j]= negmeanset[j]+data[negativepredict.get(i)][j];	
		    }
		    }
	    
	    
	    for(int j =0 ;j<8;j++){
		    for(int i=0;i<positivepredict.size();i++){
		    	sdset[j]= sdset[j]+(data[positivepredict.get(i)][j]-meanset[j])*(data[positivepredict.get(i)][j]-meanset[j]);	
		    }
		    sdset[j]= Math.sqrt(sdset[j]/(positivepredict.size()-1));
		    }
	    for(int j =0 ;j<8;j++){
		    for(int i=0;i<negativepredict.size();i++){
		    	negsdset[j]= negsdset[j]+(data[negativepredict.get(i)][j]-negmeanset[j])*(data[negativepredict.get(i)][j]-negmeanset[j]);	
		    }
		        negsdset[j]= Math.sqrt(negsdset[j]/(negativepredict.size()-1));
		    }	
	    
	    double positiveprob = 1.00;
	    double negtiveprob= 1.00;
	    
	    //test set input
	    Scanner testline = new Scanner(test);
		while(testline.hasNextLine()){
			
			double[] testdata= new double[8];
			String temptest = testline.nextLine();
	        Scanner testscanner = new Scanner(temptest);
	        testscanner.useDelimiter(",");
	        int colnum =0;
	        while (testscanner.hasNext())  {
	        	String a = testscanner.next();
	        	a= a.trim();
	        	testdata[colnum]=Double.parseDouble(a); 
	        	 colnum =colnum+1;
	        	}
	        
	        
	        double jointpositive = 1.00;
	        double jointnegative =1.00;
	        
	        for(int i =0; i<8;i++){
	            jointpositive = jointpositive*probability(meanset[i],sdset[i],testdata[i]);
	        }
	        for(int i =0; i<8;i++){
		        jointnegative = jointnegative*probability(negmeanset[i],negsdset[i],testdata[i]);
		    }
		        
	        if(jointpositive>=jointnegative){
	        	System.out.println("yes");
	        	
	         }else{
	        	System.out.println("no");
	
	         }
         

			
		}
			
		
	}
	
	
	public static double probability(double mean, double sd,double x){
		

		final double E =java.lang.Math.E;
		final double PI =java.lang.Math.PI;
		double pdf= (1/(sd*Math.sqrt(2*PI)))*Math.pow(E,-(x-mean)*(x-mean)/(2*sd*sd));	
		return pdf;
		
		
	}
	
	
	
	
	
	
	
	

}
