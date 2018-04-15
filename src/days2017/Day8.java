package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Day8 {

	public static void main(String[] args) throws ScriptException {
		Scanner input = null;
		String[] splitLinea;
		String[] leftValues;
		String[] rightValues;
		String rightStringToEvaluate;
		Map<String, Integer> mapResults = new HashMap<String, Integer>();
		Integer StringLiteralValue;
		Integer valueAddToMap;
		Integer valueAddToMapSigned;
		
		try{
			input = new Scanner(new File("inputDay8.txt"));
			
		}catch(FileNotFoundException oops){
			oops.printStackTrace();
		}
		
		while(input.hasNextLine()){
			@SuppressWarnings("resource")
			Scanner separadorLinea = new Scanner(input.nextLine());
			
			while(separadorLinea.hasNext()){
				String linea = separadorLinea.nextLine();
				
				System.out.println("==========================================");
				System.out.println("linea a cambiar: "+ linea);
				
				splitLinea = linea.split(" if ");
				
				
				//Incrementar
				
				if(splitLinea[0].contains(" inc ")){
					leftValues = splitLinea[0].trim().split("inc");
					rightValues = splitLinea[1].trim().split(" ", 2);
					//Evaluar condicion derecha
					ScriptEngineManager mgr = new ScriptEngineManager();
					ScriptEngine engine = mgr.getEngineByName("JavaScript");
					
					rightStringToEvaluate = rightValues[0].trim();
			
					
					System.out.println("Valor registro antes del cambio: " + mapResults.get(leftValues[0].trim()));
					
					
					if(mapResults.containsKey(rightStringToEvaluate)){
						StringLiteralValue = mapResults.get(rightStringToEvaluate);
						
						if((boolean) engine.eval(StringLiteralValue+rightValues[1].trim())){
							if(mapResults.containsKey(leftValues[0].trim())){
								if(Integer.valueOf(leftValues[1].trim()) < 0){
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}else{
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}
							}else{
								if(Integer.valueOf(leftValues[1].trim()) < 0){
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}else{
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}
							}
						}else{
							System.out.println("Izquierda vale: "+ StringLiteralValue);
							System.out.println("Resultado evalu es: "+ (boolean) engine.eval(StringLiteralValue+rightValues[1].trim()));
						}
					}
					
					
					
					
					
					else{
						mapResults.put(rightStringToEvaluate, 0);
						StringLiteralValue = 0;
						
						if((boolean) engine.eval(StringLiteralValue+rightValues[1].trim())){
							if(mapResults.containsKey(leftValues[0].trim())){
								if(Integer.valueOf(leftValues[1].trim()) < 0){
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}else{
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}
							}else{
								if(Integer.valueOf(leftValues[1].trim()) < 0){
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}else{
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}
							}
						}else{
							System.out.println("Izquierda vale: "+ StringLiteralValue);
							System.out.println("Resultado evalu es: "+ (boolean) engine.eval(StringLiteralValue+rightValues[1].trim()));
						}
					}
				}
			
					
					
					
					
					
					
					//Decrementar
					
					
					
					
				else{
					leftValues = splitLinea[0].split(" dec ");
					rightValues = splitLinea[1].trim().split(" ", 2);
					//Evaluar condicion derecha
					ScriptEngineManager mgr = new ScriptEngineManager();
					ScriptEngine engine = mgr.getEngineByName("JavaScript");
					
					rightStringToEvaluate = rightValues[0].trim();
			
					System.out.println("Valor registro antes del cambio: " + mapResults.get(leftValues[0].trim()));
					
					if(mapResults.containsKey(rightStringToEvaluate)){
						StringLiteralValue = mapResults.get(rightStringToEvaluate);
						
						if((boolean) engine.eval(StringLiteralValue+rightValues[1])){
							if(mapResults.containsKey(leftValues[0].trim())){
								if(Integer.valueOf(leftValues[1].trim()) > 0){
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}else{
									valueAddToMap = mapResults.get(leftValues[0].trim()) - Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}
							}else{
								if(Integer.valueOf(leftValues[1].trim()) > 0){
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}else{
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}
							}
						}else{
							System.out.println("Izquierda vale: "+ StringLiteralValue);
							System.out.println("Resultado evalu es: "+ (boolean) engine.eval(StringLiteralValue+rightValues[1].trim()));
						}
					}
					
					
					
					
					
					
					
					
					
					
					else{
						mapResults.put(rightStringToEvaluate, 0);
						StringLiteralValue = 0;
						
						
						
						if((boolean) engine.eval(StringLiteralValue+rightValues[1].trim())){
							if(mapResults.containsKey(leftValues[0].trim())){
								if(Integer.valueOf(leftValues[1].trim()) > 0){
									valueAddToMap = mapResults.get(leftValues[0].trim()) + Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}else{
									valueAddToMap = mapResults.get(leftValues[0].trim()) - Integer.valueOf(leftValues[1].trim());
									mapResults.put(leftValues[0].trim(), valueAddToMap);
								}
							}else{
								if(Integer.valueOf(leftValues[1].trim()) > 0){
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}else{
									valueAddToMapSigned = Integer.valueOf(leftValues[1].trim())*-1;
									mapResults.put(leftValues[0].trim(), valueAddToMapSigned);
								}
							}
						}else{
							System.out.println("Izquierda vale: "+ StringLiteralValue);
							System.out.println("Resultado evalu es: "+ (boolean) engine.eval(StringLiteralValue+rightValues[1].trim()));
						}
					}
				}
				
				System.out.println("Valor registro despues del cambio: " + mapResults.get(leftValues[0].trim()));
				
				System.out.println("==========================================");
			}	
		}
		
		
		//Maximo
		
		Integer maxValue = 0;
		for(Integer e : mapResults.values()){
			if(e > maxValue)
				maxValue = e;
		}
		
		System.out.println(maxValue);
		System.out.println(mapResults.toString());
	}
}
