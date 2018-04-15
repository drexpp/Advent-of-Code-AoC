package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import aux.Tuple;

public class Day13 {

	static Integer res = 0;
	static Integer pointer = 0;
	
	//Map<Nivel actual, tripla (profundidad, posicionScanner, sumaTotal> LinkedHashMap para mantener el orden
	static Map<Integer, Tuple<Integer, Integer>> positionOfScanner = new LinkedHashMap<Integer, Tuple<Integer, Integer>>();
	
	//List de la solucion, nivel cazado + profundidad
	public static List<Tuple<Integer, Integer>> caughtBySecurity = new ArrayList<Tuple<Integer, Integer>>();
	public static void main(String[] args) {
		Scanner sc2 = null;
		
		try {
			sc2 = new Scanner(new File("inputDay13.txt"));
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
		}
		
		System.out.println("================NIVELES EN LOS QUE HAS SIDO CAZADO=============");
		for (Integer currentLevel : positionOfScanner.keySet()) {
			boolean secure = false;
			if(pointer != currentLevel){
				while(pointer < currentLevel){
					updateSecurity(currentLevel);
				}
			}
			Integer currentLevelDepth = positionOfScanner.get(currentLevel).getTupleX();
			Integer currentAcummulator = positionOfScanner.get(currentLevel).getTupleY();
			
			if(!secure){
				if(currentAcummulator%currentLevelDepth == 0){
					if(Math.floor(currentAcummulator/currentLevelDepth)%2 == 0){
						caughtBySecurity.add(new Tuple<Integer, Integer>(currentLevel,currentLevelDepth+1));
					}
				}
			}

			updateSecurity(currentLevel);
		}
		
		System.out.println(caughtBySecurity.toString());
		System.out.println("=============SOLUCION============");
		
		for ( Tuple<Integer, Integer> tuple : caughtBySecurity) {
			res += (tuple.getTupleX()*tuple.getTupleY());
		}
		
		System.out.println(res);
		System.out.println(positionOfScanner.toString());
	}
	
	private static void updateSecurity(Integer currentLevel) {	
		for(Tuple<Integer, Integer> tuple : positionOfScanner.values()){
			tuple.setTupleY(tuple.getTupleY()+1);
		}
		pointer = pointer+1;
	}
}