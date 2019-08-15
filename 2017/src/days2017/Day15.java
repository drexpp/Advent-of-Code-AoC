package days2017;

import java.io.File;
import java.util.Scanner;

public class Day15 {
	static Long generatorB = 0L;
	static Long generatorA = 0L;

	public static void main(String[] args) {
		Scanner sc2 = null;
		Boolean first = true;

		
		try{
			sc2 = new Scanner(new File("inputs/inputDay15.txt"));
		}catch(Throwable oops){
			oops.printStackTrace();
		}
	
		while(sc2.hasNextLine()){
			String linea = sc2.nextLine();
			if(first){
				generatorA = Long.valueOf(linea.split("with ")[1]);
				first = false;
			}
			generatorB = Long.valueOf(linea.split("with ")[1]);
		}
		
		Integer number_matched_pairs = find_matched_pairs(40000000);
		System.out.println(number_matched_pairs);
	}

	protected static Integer find_matched_pairs(int repetitions) {
		Integer res = 0;
		for(int i = 0; i < repetitions; i++){
			generatorA = (generatorA * 16807)%2147483647;
			generatorB = (generatorB * 48271)%2147483647;

			String binaryA = "0000000000"+Long.toBinaryString(generatorA);
			String binaryB = "0000000000"+Long.toBinaryString(generatorB);
			
			if(binaryA.substring(binaryA.length()-16, binaryA.length()).equals(binaryB.substring(binaryB.length()-16, binaryB.length()))){
				res++;
			}
		}	
		return res;
	}
}