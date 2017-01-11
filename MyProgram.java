import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import extrapackage.*;
import extrapackage.KNN;
import extrapackage.Naivebayes;



public class MyProgram {

	
	public static void main(String[] args) throws FileNotFoundException{
		File train;
		File test;
		String classifier;
		int k = 0;
		//Scanner scan;
		
	  // ensure the three line arguments have been input
	   if (args.length==3){
		   train = new File(args[0]);
		   test = new File(args[1]);
		   classifier = args[2];
	   }else{
		   return;
	   }
	   
	   //the following code is for extract the K from input argument of KNN
	   if(classifier.length()==3){
		  char num=  classifier.charAt(0);
		  k= (int)num -(int)'0';
	   }
	   
	   if(classifier.length()==2){
		   Naivebayes NBsmarter = new Naivebayes(train,test);
	   }else{
		  //System.out.print(k);
		   KNN KNNsmarter = new KNN(train,test,k);
		   
	   }
	   
	   
	  
	}
	
	
	
	
	
	
	
	
	

}
