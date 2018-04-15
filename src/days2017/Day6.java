package days2017;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


public class Day6 {

	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>((
			Arrays.asList(11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11)
		));
		
		List<ArrayList<Integer>> oldInputs = new ArrayList<ArrayList<Integer>>();
		Integer biggestNumber;
		Integer index;
		ArrayList<Integer> inputToSave = new ArrayList<Integer>();
		Integer result = 0;

			while(!oldInputs.contains(inputs)){
				biggestNumber = findBiggestOne(inputs);
				index = inputs.indexOf(biggestNumber);
				
				inputToSave = new ArrayList<Integer>(inputs);
				oldInputs.add(inputToSave);
				
				
				inputs.set(index, 0);
				
				result++;
				
				for(int i = 0; i < biggestNumber; i++){
					
					
					
					if(index < inputs.size()-1){
						index++;
						Integer valueToChange = inputs.get(index);
						valueToChange++;
						inputs.set(index, valueToChange);
						
					}else{
						index = 0;
						Integer valueToChange = inputs.get(index);
						valueToChange++;
						inputs.set(index, valueToChange);
						
					}
					
				}
				
				
			}
			
			System.out.println(result);
			
		}	
	
	public static Integer findBiggestOne(ArrayList<Integer> input){
		Integer result = 0;
		
		for(Integer value : input){
			if(value > result)
				result = value;
		}
		
		return result;
	}

}
