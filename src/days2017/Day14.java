package days2017;

import java.io.File;
import java.util.Scanner;

import aux.HashKnotFunction;

public class Day14 {

	public static void main(String[] args) {
		Integer res = 0;
		Scanner sc2 = null;
		
		try{
			sc2 = new Scanner(new File("inputDay14.txt"));
		}catch(Throwable oops){
			oops.printStackTrace();
		}
	
		String scannerInput = sc2.next() + "-";
		for(int i = 0; i <=127; i++){
			res += count1Values(hexToBinChar(HashKnotFunction.main(args, scannerInput + i)));
		}
		System.out.println(" ===== Número de espacios del disco en uso ===== ");
		System.out.println(res);
	}

	protected static int count1Values(String binaryValues) {
		Integer acumulator = 0;
		for (char c : binaryValues.toCharArray()) {
			acumulator = ( c != '0') ? acumulator+1 : acumulator;
		}
		return acumulator;
	}

	protected static String hexToBinChar(String hashedInputs) {
		String binary = "";
		for (char c : hashedInputs.toCharArray()) {
			switch (c){
				case '0' 	: binary += "0000";	break;
				case '1'	: binary += "0001"; break;
				case '2' 	: binary += "0010"; break;
				case '3'	: binary += "0011"; break;
				case '4' 	: binary += "0100"; break;
				case '5'	: binary += "0101"; break;
				case '6' 	: binary += "0110"; break;
				case '7'	: binary += "0111"; break;
				case '8'	: binary += "1000"; break;
				case '9'	: binary += "1001"; break;
				case 'a'	: binary += "1010"; break;
				case 'b'	: binary += "1011"; break;
				case 'c'	: binary += "1100"; break;
				case 'd'	: binary += "1101"; break;
				case 'e'	: binary += "1110"; break;
				case 'f'	: binary += "1111"; break;
			}
		}
		return binary;
	}
}