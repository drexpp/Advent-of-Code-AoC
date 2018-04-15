package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) { 
		Scanner sc2 = null;
		Integer contador = 0;
		Integer resultado = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
	    try {
	        sc2 = new Scanner(new File("inputDay4.txt"));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    
	    
	    while (sc2.hasNextLine()) {
	            @SuppressWarnings("resource")
				Scanner s2 = new Scanner(sc2.nextLine());
	            
	        while (s2.hasNext()) {
	        	String linea = s2.nextLine();
	        	
	        	map = new HashMap<String, Integer>();
	        	
	            for(String palabra : linea.split("\u0020")){
	            	if(!map.containsKey(palabra)){
	            		map.put(palabra, 0);
	            	}else{
	            		Integer cont_aux = map.get(palabra);
	            		cont_aux++;
	            		map.put(palabra, cont_aux);
	            	}
	            }
	            
	            
	            contador = 0;
	            for(int val : map.values()){
	            	
	            	if(val > 0)
	            	contador += val;
	            }
	            
	            if(contador == 0){
	            	resultado++;
	            }
	            
	        }
	    }
	    
	    System.out.println(resultado);
	}

}
