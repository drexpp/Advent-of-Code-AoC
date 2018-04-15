package aux;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeepCopy<X, Y, Z> { 
	
	public static <K1, K2, V> Map<K1, Tuple<K2, V>> deepCopyMapTuple(Map<K1, Tuple<K2, V>> original){

		    Map<K1, Tuple<K2, V>> copy = new LinkedHashMap<K1, Tuple<K2, V>>();
		    for(Entry<K1, Tuple<K2, V>> entry : original.entrySet()){
		        copy.put(entry.getKey(), new Tuple<K2, V>(entry.getValue().getTupleX(),entry.getValue().getTupleY()));
		    }
		    return copy;
		}
	
	public static <K1, K2> List<Tuple<K1, K2>> deepCopyListTuple(List<Tuple<K1, K2>> original){

		List<Tuple<K1, K2>> copy = new ArrayList<Tuple<K1, K2>>();
		
	    for(Tuple<K1, K2> entry : original){
	        copy.add(entry);
	    }
	    return copy;
	}

} 