package gameslib;

public final class Platform implements Comparable<Platform>{
	
	private final String name;
	private final String company;
	
	public Platform(String name, String company) {
		if(name == null || company == null || name.equals("") || company.equals(""))
			throw new IllegalArgumentException();
		
		this.name = name;
		this.company = company;
	}
	
	@Override
	public int compareTo(Platform p) {
		if(p == null)
			throw new IllegalArgumentException();
		
		int result = this.getName().compareTo(p.getName());
		
		if(result == 0)
			result = this.getCompany().compareTo(p.getCompany());
		
		return result;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
