package days2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_2 {

	static int[] circularList = new int[256];
	static int actualPosition = 0;
	static int skipSize = 0;
	static int[] sparseHash = new int[256];
	static int[] auxHash = new int[16];
	static int[] denseHash = new int[16];
	static ArrayList<Integer> asciiCharsValue = new ArrayList<Integer>();

	public static void main(String[] args) {
		populateCircularList();
		intializeInputToAscii();
		addSuffixToAsciiCharsValues();

		doRound(64);
	
		sparseHash = circularList;
		generateDenseHash();
		System.out.println("Resulting hash");
		System.out.println(generateResultingHash());
	}
	
	
	//Auxiliary methods
	
	static String generateResultingHash(){
		String result = "";
		for(Integer denseHashValue : denseHash){	
			result += Integer.toHexString(denseHashValue).toString().length() != 2 
					? "0"+Integer.toHexString(denseHashValue) : Integer.toHexString(denseHashValue);
		}
		return result;
	}
	
	static void generateDenseHash(){
		Integer offset = 0;
		for(int i = 0; i < 16; i++){
			for(int j = 0+offset; j < 16+offset; j++){
				auxHash[j%16] = sparseHash[j];
			}
			Integer resultXOR = 0;
			for(Integer valueToBeXOR : auxHash){
				resultXOR = resultXOR ^ valueToBeXOR;
			}
			denseHash[i] = resultXOR;
			offset += 16;
		}
	}
	
	static void doRound(int numberRounds){
		for(int i = 0; i < numberRounds; i++){
				for(Integer a : asciiCharsValue){
					reverseSublist(a);
					actualPosition+=skipSize+a;
					skipSize++;
				}
			}
		}
	
	
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
	
	
	static void intializeInputToAscii(){
		Scanner scanner = null;
			
			
			try {
				scanner = new Scanner(new File("inputs/inputDay10.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			while (scanner.hasNext()) {
				char[] value = scanner.nextLine().toCharArray();
				for(char c : value){
					Integer asciiValueToAdd = (int) c;
					asciiCharsValue.add(asciiValueToAdd);
				}
			}
		}
	
	static void addSuffixToAsciiCharsValues(){
			Integer[] suffixList = {17,31,73,47,23};
			ArrayList<Integer> suffixCollection = new ArrayList<Integer>(Arrays.asList(suffixList));
			asciiCharsValue.addAll(suffixCollection);
		}
	
}