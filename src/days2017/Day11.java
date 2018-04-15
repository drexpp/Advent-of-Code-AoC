package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import auxFiles.Triple;

public class Day11 {

	
	@SuppressWarnings("rawtypes")
	static Map<String, Triple> map = new HashMap<String, Triple>();
	
	static ArrayList<Integer> largestPosition = new ArrayList<Integer>();
	
	@SuppressWarnings("rawtypes")
	static Triple initialVector = new Triple(0, 0, 0);
	
	public static void main(String[] args) {
		generateInitialCoordinateMap();
		
		
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(new File("inputDay11.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sc2.useDelimiter(",");
		while(sc2.hasNext()){
			String coordinate = sc2.next();
			
			updateInitialVectorPosition(coordinate);
		}
		
		System.out.println("=========LAST POSITION=======");
		System.out.println(initialVector.toString());
		
		System.out.println("=========RESULT=======");
		System.out.println(maxValue());
		
		System.out.println("=========LARGEST POSITION=======");
		System.out.println(Collections.max(largestPosition));

	}

	private static Integer maxValue() {
		Integer value = 0;
		
		value =  Math.abs(initialVector.getX());
		Integer valueY = Math.abs(initialVector.getY());
		Integer valueZ = Math.abs(initialVector.getZ());
		if(valueY > value)
			value = valueY;
		if(valueZ > value)
			value = valueZ;
		
		return value;
	}

	private static void updateInitialVectorPosition(String coordinate) {
		@SuppressWarnings("rawtypes")
		Triple coordinateTriple = map.get(coordinate);
		
		initialVector.setX(initialVector.getX() + coordinateTriple.getX());
		initialVector.setY(initialVector.getY() + coordinateTriple.getY());
		initialVector.setZ(initialVector.getZ() + coordinateTriple.getZ());
		
		saveDistancesFromCenter();
		
	}

	private static void saveDistancesFromCenter() {
		
		largestPosition.add(maxValue());
		
	}

	@SuppressWarnings("rawtypes")
	public static void generateInitialCoordinateMap() {
		
		map.put("n", new Triple(0,1,-1));
		map.put("ne", new Triple(1,0,-1));
		map.put("nw", new Triple(-1,1,0));
		
		map.put("s", new Triple(0,-1,1));
		map.put("sw", new Triple(-1,0,1));
		map.put("se", new Triple(1,-1,0));
	}

}
