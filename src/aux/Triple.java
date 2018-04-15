package aux;


public class Triple<X, Y, Z> { 
	  public  Integer x; 
	  public  Integer y; 
	  public  Integer z;
	  
	  public Triple(Integer x, Integer y, Integer z) { 
	    this.x = x; 
	    this.y = y; 
	    this.z = z;
	  } 
	  
	  public Integer getX(){
		  return this.x;
	  }
	  
	  public void setX(final Integer x){
		  this.x = x;
	  }
	  
	  public Integer getY(){
		  return this.y;
	  }
	  
	  public void setY(final Integer y){
		  this.y = y;
	  }
	  
	  public Integer getZ(){
		  return this.z;
	  }
	  
	  public void setZ(final Integer z){
		  this.z = z;
	  }

	    @Override
	    public String toString() {
	    	 return "(" + x + "," + y + ","+ z + ")";
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			result = prime * result + ((z == null) ? 0 : z.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Triple))
				return false;
			@SuppressWarnings("rawtypes")
			Triple other = (Triple) obj;
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
			if (z == null) {
				if (other.z != null)
					return false;
			} else if (!z.equals(other.z))
				return false;
			return true;
		}

	} 