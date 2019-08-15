package aux;


public class Tuple<X, Y> { 
	  public  X x; 
	  public  Y y; 
	  
	  public Tuple(X x, Y y) { 
	    this.x = x; 
	    this.y = y; 
	  } 
	  
	  public Tuple() { 
		  super();
	  } 
	  
	  public X getTupleX(){
		  return this.x;
	  }
	  
	  public void setTupleX(final X x){
		  this.x = x;
	  }
	  
	  public Y getTupleY(){
		  return this.y;
	  }
	  
	  public void setTupleY(final Y y){
		  this.y = y;
	  }

	    @Override
	    public String toString() {
	        return "(" + x + "," + y + ")";
	    }

	    
	    
	    @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Tuple))
				return false;
			@SuppressWarnings("rawtypes")
			Tuple other = (Tuple) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}
	} 