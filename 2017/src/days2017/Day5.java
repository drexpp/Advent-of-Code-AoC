package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	
	public static void main(String[] args){
		Scanner sc2 = null;
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		Integer stepsResult = 0;
		
		try {
	        sc2 = new Scanner(new File("inputs/inputDay5.txt"));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    
	    
	    while (sc2.hasNextLine()) {
	            @SuppressWarnings("resource")
				Scanner s2 = new Scanner(sc2.nextLine());
	            
	        while (s2.hasNext()) {
	        	String linea = s2.nextLine();
	        	Integer lineaAInteger = Integer.parseInt(linea);
	            
	        	inputs.add(lineaAInteger);
	            
	        }
	    }
	    
	    	Integer initialValue = inputs.get(0);
	    	Integer updateFirstPosition = initialValue;
	    	updateFirstPosition++;
	    	inputs.set(0, updateFirstPosition);
	    	Integer index = initialValue;
	    	
	    	while(index < inputs.size()){
	    		Integer nextValue = inputs.get(index);
	    		nextValue++;
	    		inputs.set(index, nextValue);

	    		nextValue--;
	    		index = index + nextValue;
	    		stepsResult++;
	    	}
	
	    //Último paso para salir
	    stepsResult++;
	    System.out.println(stepsResult);
	    
	}

}
