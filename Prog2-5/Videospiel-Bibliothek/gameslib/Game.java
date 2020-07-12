package gameslib;

public final class Game implements Comparable<Game>{
	
	private final String name;
	private final Genre genre;
	private final Platform platform;
	private final int releaseYear;
	private final int metacriticScore;
	
	public Game(String name, Genre genre, Platform platform, int releaseYear, int metacriticScore) {
		if(name == null || name.equals("") || genre == null || platform == null || releaseYear < 1970 || metacriticScore < 0 || metacriticScore > 100)
			throw new IllegalArgumentException();
		
		this.name = name;
		this.genre = genre;
		this.platform = platform;
		this.releaseYear = releaseYear;
		this.metacriticScore = metacriticScore;
	}
	
	public int compareTo(Game g) {
		if(g == null)
			throw new IllegalArgumentException();
			
		int result = this.getName().compareTo(g.getName());
		
		if(result == 0) {
			result = this.getGenre().compareTo(g.getGenre());
			if(result == 0) {
				result = this.getPlatform().compareTo(g.getPlatform());
				if(result == 0) {
					result = this.getReleaseYear() - g.getReleaseYear();
					if(result == 0) {
						result = this.getMetacriticScore() - g.getMetacriticScore();
					}
				}
			}
		}
		
		return result;	
	}

	public String getName() {
		return name;
	}

	public Genre getGenre() {
		return genre;
	}

	public Platform getPlatform() {
		return platform;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getMetacriticScore() {
		return metacriticScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + metacriticScore;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		result = prime * result + releaseYear;
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
		Game other = (Game) obj;
		if (genre != other.genre)
			return false;
		if (metacriticScore != other.metacriticScore)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		return true;
	}
	
}
