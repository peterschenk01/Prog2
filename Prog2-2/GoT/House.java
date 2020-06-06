public class House {

	private final String name;
	private final String seat;
	
	public House(final House other) {
		if(other == null) 
			throw new IllegalArgumentException("Parameter other darf nicht null sein.");
		
		name = other.getName();
		seat = other.getSeat();
	}
	
	/**
	 * KOnstruktor mit Name und Sitz.
	 * @param n Name (darf nicht {@code null} und nicht leer sein).
	 * @param s Sitz (darf nicht {@code null} und nicht leer sein).
	 */
	public House(final String n, final String s) {
		if(n == null) 
			throw new IllegalArgumentException("Parameter name darf nicht null sein.");
		if(s == null) 
			throw new IllegalArgumentException("Parameter seat darf nicht null sein.");
		if(n.equals("")) 
			throw new IllegalArgumentException("Parameter name darf nicht leer sein.");
		if(s.equals("")) 
			throw new IllegalArgumentException("Parameter seat darf nicht leer sein.");
		
		name = n;
		seat = s;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSeat() {
		return seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if(name == null) {
			if(other.name != null)
				return false;
		}
		else if(!name.equals(other.name))
			return false;
		if(seat == null) {
			if(other.seat != null)
				return false;
		}
		else if(!seat.equals(other.seat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "House [name = " + name + ", seat = " + seat + "]";
	}
}
