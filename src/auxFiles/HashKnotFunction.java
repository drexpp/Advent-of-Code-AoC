package aux;


import java.util.ArrayList;
import java.util.Arrays;

public class HashKnotFunction {

	public static String main(String[] args, String inputToHash) {
		int[] circularList = new int[256];
		int actualPosition = 0;
		int skipSize = 0;
		int[] sparseHash = new int[256];
		int[] auxHash = new int[16];
		int[] denseHash = new int[16];
		ArrayList<Integer> asciiCharsValue = new ArrayList<Integer>();
		
		populateCircularList(circularList);
		intializeInputToAscii(inputToHash, asciiCharsValue);
		addSuffixToAsciiCharsValues(asciiCharsValue);

		doRound(64, circularList, actualPosition, skipSize, asciiCharsValue);
	
		sparseHash = circularList;
		generateDenseHash(sparseHash, auxHash, denseHash);
		return generateResultingHash(denseHash);
	}
	
	
	//Auxiliary methods
	
	static String generateResultingHash(int[] denseHash){
		String result = "";
		for(Integer denseHashValue : denseHash){	
			result += Integer.toHexString(denseHashValue).toString().length() != 2 
					? "0"+Integer.toHexString(denseHashValue) : Integer.toHexString(denseHashValue);
		}
		return result;
	}
	
	static void generateDenseHash(int[] sparseHash, int[] auxHash,int[] denseHash){
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
	
	static void doRound(int numberRounds, int[] circularList, int actualPosition, int skipSize, ArrayList<Integer> asciiCharsValue){
		for(int i = 0; i < numberRounds; i++){
				for(Integer a : asciiCharsValue){
					reverseSublist(a, circularList, actualPosition);
					actualPosition+=skipSize+a;
					skipSize++;
				}
			}
		}
	
	static void populateCircularList(int[] circularList){
		int circularListLength = circularList.length;
		for (int i=0;i<circularListLength;i++) {
			circularList[i] = i;
		}
	}
	
	static void reverseSublist(int number, int[] circularList, int actualPosition){
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
	
	static void intializeInputToAscii(String inputToHash, ArrayList<Integer> asciiCharsValue){	
		char[] value = inputToHash.toCharArray();
		for(char c : value){
			Integer asciiValueToAdd = (int) c;
			asciiCharsValue.add(asciiValueToAdd);
		}
	
	}
	
	static void addSuffixToAsciiCharsValues(ArrayList<Integer> asciiCharsValue){
			Integer[] suffixList = {17,31,73,47,23};
			ArrayList<Integer> suffixCollection = new ArrayList<Integer>(Arrays.asList(suffixList));
			asciiCharsValue.addAll(suffixCollection);
		}
	
}