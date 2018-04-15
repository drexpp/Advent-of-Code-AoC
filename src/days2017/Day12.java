package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day12 {
	
	static Map<Integer, Set<Integer>> mapOfPipes = new HashMap<Integer, Set<Integer>>();
	static Set<Integer> solucion = new HashSet<Integer>();
	static Set<Integer> rightSavingNumbers = new HashSet<Integer>();
	static Set<Integer> aux = new HashSet<Integer>();
	public static void main(String[] args) {
		Scanner sc2 = null;
		
		try {
			sc2 = new Scanner(new File("inputDay12.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(sc2.hasNextLine()){
			String line  = sc2.nextLine();
			String[] parts;
			rightSavingNumbers = new HashSet<Integer>();
			parts = line.split("<->");
			Integer leftHalf = Integer.valueOf(parts[0].trim());
			String rightHalf = parts[1].trim();
			String[] rightHalfInParts = rightHalf.split(", ");
			for (String rightIndividualNumber : rightHalfInParts) {
				
				rightSavingNumbers.add(Integer.valueOf(rightIndividualNumber));
			}
			mapOfPipes.put(leftHalf, rightSavingNumbers);			
		}
		Long timeBefore = System.currentTimeMillis();
		connectedProgramsForIndex(0);
		Long timeAfter = System.currentTimeMillis();
		
		System.out.println("==========Array programas conectados con 0=========");
		System.out.println(solucion.toString());
		System.out.println("==========Programas conectados con 0=========");
		System.out.println(solucion.size());
		System.out.println("==========Tiempo que tarda (ms)=========");
		System.out.println(timeAfter-timeBefore);
		
	}
	
	private static void connectedProgramsForIndex(int index){
		solucion.add(index);
		aux = mapOfPipes.get(index);
		for(Integer val : aux)
			if(!solucion.contains(val))
				añadirResultado(val);
	}
	
	private static void añadirResultado(int mapIndex) {
		Set<Integer> aux2 = new HashSet<Integer>();
		aux2 = mapOfPipes.get(mapIndex);
		solucion.add(mapIndex);
		for(Integer val : aux2)
			if(!solucion.contains(val) && val != 0)
				añadirResultado(val);
	}
}