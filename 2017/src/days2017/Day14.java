package days2017;

import java.io.File;
import java.util.Scanner;

import auxFiles.HashKnotFunction;

public class Day14 {

	public static void main(String[] args) {
		Integer res = 0;
		Scanner sc2 = null;
		
		try{
			sc2 = new Scanner(new File("inputs/inputDay14.txt"));
		}catch(Throwable oops){
			oops.printStackTrace();
		}
	
		String scannerInput = sc2.next() + "-";
		for(int i = 0; i <=127; i++){
			res += hexToBinChar(HashKnotFunction.main(args, scannerInput + i));
		}
		
		System.out.println(" ===== Número de espacios del disco en uso ===== ");
		System.out.println(res);
	}

	protected static Integer hexToBinChar(String hashedInputs) {
		Integer binary = 0;
		for (char c : hashedInputs.toCharArray()) {
			switch (c){
				case '0' 	: binary += 0;	break;
				case '1'	: binary += 1; break;
				case '2' 	: binary += 1; break;
				case '3'	: binary += 2; break;
				case '4' 	: binary += 1; break;
				case '5'	: binary += 2; break;
				case '6' 	: binary += 2; break;
				case '7'	: binary += 3; break;
				case '8'	: binary += 1; break;
				case '9'	: binary += 2; break;
				case 'a'	: binary += 2; break;
				case 'b'	: binary += 3; break;
				case 'c'	: binary += 2; break;
				case 'd'	: binary += 3; break;
				case 'e'	: binary += 3; break;
				case 'f'	: binary += 4; break;
			}
		}
		return binary;
	}
}