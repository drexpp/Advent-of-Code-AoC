package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10 {

	static int[] circularList = new int[256];
	static int actualPosition = 0;
	static int skipSize = 0;
	static int actualPositionBeforeRounds = 0;
	static int skipSizeBeforeRounds = 0;
	static ArrayList<Integer> asciiCharsValue = new ArrayList<Integer>();

	public static void main(String[] args) {
		intialize();
		
		actualPositionBeforeRounds 	= actualPosition%5;
		skipSizeBeforeRounds	    = skipSize;
		
		
	}
	
	
	//Auxiliary methods
	
	static void populateCircularList(){
		int circularListLength = circularList.length;
		for (int i=0;i<circularListLength;i++) {
			circularList[i] = i;
		}
	}
	
	static void reverseSublist(int number){
		String portion = "";
		Integer aux = actualPosition;
		for (int i = actualPosition; i < number+actualPosition; i++) {
			Integer wrappedPosition = i%circularList.length;
			portion += String.valueOf(circularList[wrappedPosition])+",";
		}
		
		int[] result = new int[number];
		int k=0;
		for(int i = 0; i < number; i++){
			String[] portions = portion.split(",");
			if(portions[i] != ""){
				result[k] = Integer.parseInt(portions[i]);
				k++;
			}
		}
		
		int portionLength = result.length;

		int[] temporalresult = new int[number];
		k=0;
		for(int i = portionLength-1; i >= 0; i--){
				temporalresult[k] = result[i];
				k++;
		}
				
		result=temporalresult;
		
		k=0;
		for (int i = aux; i < number+actualPosition; i++) {
			Integer wrappedPosition = i%circularList.length;
			circularList[wrappedPosition] = result[k++];
		}
	}
	

	
	static void intialize(){
	Scanner scanner = null;
		
		
		try {
			scanner = new Scanner(new File("inputs/inputDay10.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		populateCircularList();
		scanner.useDelimiter(",");
		while (scanner.hasNextInt()) {
			
			int number = scanner.nextInt();
			reverseSublist(number);
			actualPosition+=skipSize+number;
			skipSize++;
		}
		
		System.out.println(actualPosition);
		System.out.println(skipSize);
		System.out.println("Result: ");
		for (int c : circularList) {
			System.out.print(c+",");
		}
	}	
}