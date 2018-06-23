package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

	public static void main(String[] args) {
		
		Scanner sc2 = null;
		ArrayList<String> inputsCleaned = new ArrayList<String>();
		String[] splitValues = null;
		ArrayList<String> leftNames = new ArrayList<String>();
		ArrayList<String> rightNames = new ArrayList<String>();
		Long timeBeforeEx = System.currentTimeMillis();
		
		try {
	        sc2 = new Scanner(new File("inputs/inputDay7.txt"));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    
	    
	    while (sc2.hasNextLine()) {
	            @SuppressWarnings("resource")
				Scanner s2 = new Scanner(sc2.nextLine());
	            
	        while (s2.hasNext()) {
	        	String linea = s2.nextLine();
	        	
	        	if(linea.contains("->")){
	        		
	        		inputsCleaned.add(linea);
	        	}
	            
	        
	        }
	    }
	    
	    for(String value : inputsCleaned){
	    	splitValues = value.split("->");
	    	
	    	String leftNameToAdd = splitValues[0].split("\\(")[0];
	    	leftNames.add(leftNameToAdd.trim());
	    	for(String namesOnRight : splitValues[1].split(",")){
	    		rightNames.add(namesOnRight.trim());
	    	}
	    }
	    
	    for(int i = 0; i < leftNames.size()-1; i++){
	    	if(!rightNames.contains(leftNames.get(i))){
	    		System.out.println("El nombre objetivo es " + leftNames.get(i));
	    		Long timeAfterEx = System.currentTimeMillis();
	    		System.out.println(timeAfterEx - timeBeforeEx);
	    	}
	    }
	}

}
