package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import auxFiles.DeepCopy;
import auxFiles.Tuple;

public class Day13_2 {

	static Integer pointer = 0;
	
	//Map<Nivel actual, tupla<profundidad, acumulador>> LinkedHashMap para mantener el orden
	static Map<Integer, Tuple<Integer, Integer>> positionOfScanner = new LinkedHashMap<Integer, Tuple<Integer, Integer>>();
	
	//List de la solucion, nivel cazado + profundidad
	public static List<Tuple<Integer, Integer>> caughtBySecurity = new ArrayList<Tuple<Integer, Integer>>();
	public static void main(String[] args) {
		Scanner sc2 = null;
		Map<Integer, Tuple<Integer, Integer>> initialFirewallLayerState = new LinkedHashMap<Integer, Tuple<Integer, Integer>>();
		List<Tuple<Integer, Integer>> initialCaughtList = new ArrayList<Tuple<Integer, Integer>>();
		Integer resultado = -1;
		
		
		try {
			sc2 = new Scanner(new File("inputs/inputDay13.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("==========Security levels=========");
		while(sc2.hasNextLine()){
			String line  = sc2.nextLine();
			System.out.println(line);
			Integer currentLevel;
			Integer currentLevelDepth;
			String[] values;
			
			values = line.split(": ");
			
			currentLevel = Integer.valueOf(values[0]);
			currentLevelDepth = Integer.valueOf(values[1])-1;
			
			
			positionOfScanner.put(currentLevel, new Tuple<Integer, Integer>(currentLevelDepth, 0));
			initialFirewallLayerState.put(currentLevel, new Tuple<Integer, Integer>(currentLevelDepth, 0));
		}
	
		System.out.println("================NIVELES EN LOS QUE HAS SIDO CAZADO=============");
		do{
	
			for (Integer layer : initialFirewallLayerState.keySet()) {
				initialFirewallLayerState.get(layer).setTupleY(initialFirewallLayerState.get(layer).getTupleY()+1);
			}
		
			caughtBySecurity  = DeepCopy.deepCopyListTuple(initialCaughtList);
			positionOfScanner = DeepCopy.deepCopyMapTuple(initialFirewallLayerState);
	
			
			for (Integer currentLevel : positionOfScanner.keySet()) {
				
				if(pointer != currentLevel){
					while(pointer < currentLevel){
						updateSecurity(currentLevel);
					}
				}
				Integer currentLevelDepth = positionOfScanner.get(currentLevel).getTupleX();
				Integer currentAcummulator = positionOfScanner.get(currentLevel).getTupleY();
				
				if(currentAcummulator%currentLevelDepth == 0){
					if(Math.floor(currentAcummulator/currentLevelDepth)%2 == 0){
						caughtBySecurity.add(new Tuple<Integer, Integer>(currentLevel,currentLevelDepth+1));
					}
				}
	
				updateSecurity(currentLevel);
			}
			resultado++;
			pointer = 0;
			System.out.println("Working.. All ok");
		}while(!caughtBySecurity.isEmpty());	
		
		System.out.println("=============SOLUCION============");

		System.out.println(resultado+1);
	}
	
	private static void updateSecurity(Integer currentLevel) {	
		for(Tuple<Integer, Integer> tuple : positionOfScanner.values()){
			tuple.setTupleY(tuple.getTupleY()+1);
		}
		pointer = pointer+1;
	}
}