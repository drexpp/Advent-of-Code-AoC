package days2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import aux.Tuple;

import java.util.Objects;

public class Day3 {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		Map<Tuple, Integer> map = getPosicionamiento();
		
		@SuppressWarnings("rawtypes")
		Tuple prueba = getKeyByValue(map, 347991);
		
		

		Integer distanciaAlCentro = getDistanciaAlCentro(prueba);
		
		
		System.out.println(distanciaAlCentro);

	}
	
	
	//Sacar la clave de un valor (One to One)
	@SuppressWarnings("unchecked")
	public static Tuple<Integer, Integer>  getKeyByValue(@SuppressWarnings("rawtypes") Map<Tuple, Integer> map, Integer value) {
	    for (@SuppressWarnings("rawtypes") Entry<Tuple, Integer> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	
	//Calcular distancia manhattan
	public static Integer getDistanciaAlCentro(@SuppressWarnings("rawtypes") Tuple pos_tuple_final){
		Integer res = 0;
		
		Integer val_pos_final_X = Math.abs((Integer) pos_tuple_final.getTupleX());
		Integer val_pos_final_Y = Math.abs((Integer) pos_tuple_final.getTupleY());
		
		res = val_pos_final_X + val_pos_final_Y;
		
		return res;
		
	}
	
	//Construir memoria circular
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Tuple,Integer> getPosicionamiento(){
		Map<Tuple, Integer> map = new HashMap<Tuple, Integer>();
		Integer aux_X=0, aux_Y = 0;
		
		Tuple<Integer, Integer> test = new Tuple(aux_X,aux_Y);
		
		map.put(test, 1);
		
		Integer valAct = 1;
		Integer valObj = 347991;
		
		valAct++;
		aux_X++;
		map.put(new Tuple(aux_X,aux_Y), valAct);
		
		while(valAct < valObj){
			while(valAct < valObj && map.containsKey(new Tuple(aux_X-1,aux_Y))){
					valAct++;
					aux_Y++;
					map.put(new Tuple(aux_X,aux_Y), valAct);
			}
			
			while(valAct < valObj && map.containsKey(new Tuple(aux_X,aux_Y-1))){
				valAct++;
				aux_X--;
				map.put(new Tuple(aux_X,aux_Y), valAct);
			}
			
			while(valAct < valObj && map.containsKey(new Tuple(aux_X+1, aux_Y))){
				valAct++;
				aux_Y--;
				map.put(new Tuple(aux_X,aux_Y), valAct);
			}
			
			while(valAct < valObj && map.containsKey(new Tuple(aux_X, aux_Y+1))){
				valAct++;
				aux_X++;
				map.put(new Tuple(aux_X, aux_Y), valAct);
			}
		
		}

		
		return map;
		
		}
		
}
	

