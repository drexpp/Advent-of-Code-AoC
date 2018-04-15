package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day9 {

	public static void main(String[] args) {
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(new File("inputDay9.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		while(sc2.hasNextLine()){
			@SuppressWarnings("resource")
			Scanner separadorLinea = new Scanner(sc2.nextLine());
			String linea = separadorLinea.nextLine();

			System.out.println(linea);

			Map<Integer,Integer> valores = new HashMap<Integer, Integer>();
			Deque<String> stack = new ArrayDeque<String>();
			Integer actualLevel = 0;
			Integer actualValue = 0;
			Integer cont = 0;
			Boolean ignored = false;
			boolean basura = false;
			Integer sum = 0;
			Integer wut = 0;
			Boolean counterEstrella = false;
//			System.out.println(linea);
			for(char ch : linea.toCharArray()){
				System.out.print(ch);
				if(ignored){
					if(cont == 1){
						cont++;
					}else{

						ignored = false;
					}
					
				}
				if(!ignored){
					if(counterEstrella && ch != '!'){
						wut +=1;
					}
					
					if(basura != true || (ch == '!' || (ch == '>' && !ignored))){
						 switch (String.valueOf(ch)) {
				            case "{": 
					            stack.push(String.valueOf(ch));
					            Integer tamStack = stack.size();
					            
					            
								if(tamStack != 1){
									actualLevel = tamStack;
					
									actualValue = valores.get(actualLevel);
									
 									if(actualValue == null){
										actualValue = 1;
									}else{
										actualValue++;
									}
									
						
									valores.put(actualLevel, actualValue);
				
									
								}else{
									valores.put(1, 1);
								}
								break;
								
				            case "}": 
				            	stack.pop();
							break;
				            
				            case "!":
				            	if(!ignored){
				            		ignored = true;
				            		cont = 1;
				     
				            	}
				            break;
							
				            case "<":
				            	if(!ignored){
				            		basura = true;
				            	}
				            	
				            	counterEstrella = true;
				            	
				            break;
				            
				            case ">":
				            	if(!ignored){
				            		basura = false;
				            		wut -= 1;
				            	}
				            	
				            	counterEstrella = false;
		
				            default:
				            	break;
				        }
					} 
				}	 
			}
			
			System.out.println(valores.toString());
			
			for(int i = 1; i <= valores.keySet().size(); i++){
				sum += i*valores.get(i);
			}
			System.out.println(sum);
			System.out.println(wut);
		}
	}
}
