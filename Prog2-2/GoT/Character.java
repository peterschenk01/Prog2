public class Character {

	private final String name;
	private final House house;
	private final Character mother;
	private final Character father;
	private boolean alive;
	private int fightSkills;
	
	public Character(final Character other) {
		if(other == null) 
			throw new IllegalArgumentException("Parameter other darf nicht null sein.");
		
		name = other.getName();
        house = other.getHouse();
        father = other.getFather();
        mother = other.getMother();
        alive = other.getAlive();
        fightSkills = other.getFightSkills();
	}
	
	/**
	 * KOnstruktor mit Name, Haus, Lebensstatus und Kampfstärke.
	 * @param n Name des Charakters (darf nicht {@code null} und nicht leer sein).
	 * @param h Haus des Charakters.
	 * @param a Lebensstatus des Charakters.
	 * @param fs Kampfstärke des Charakters (von 1 bis 100).
	 */
	public Character(final String n, final House h, boolean a, final int fs) {
		if(n == null) 
			throw new IllegalArgumentException("Parameter name darf nicht null sein.");
		if(n.equals("")) 
			throw new IllegalArgumentException("Parameter name darf nicht leer sein.");
		if(fs < 0 || fs > 100) 
			throw new IllegalArgumentException("Parameter fightSkills muss zwischen 0 und 100 liegen.");
		
		name = n;
		house = h;
		mother = null;
		father = null;
		alive = a;
		fightSkills = fs;
	}
	
	/**
	 * Geburts-Konstruktor mit Name, Mutter und Vater.
	 * @param fightSkills Ist der Mittelwert der Kampfstärken der Eltern.
	 * @param house Haus wird von der Mutter vererbt (wenn Haus der Mutter nicht {@code null} ist), sonst vom Vater
	 * @param n Name des Charakters (darf nicht {@code null} und nicht leer sein).
	 * @param m Mutter (darf nicht {@code null} sein, muss leben und darf nicht {@param f} sein).
	 * @param f Vater (darf nicht {@code null} sein, muss leben und darf nicht {@param m} sein).
	 */
	public Character(final String n, final Character m, final Character f) {
		if(n == null) 
			throw new IllegalArgumentException("Parameter name darf nicht null sein.");
		if(n.equals("")) 
			throw new IllegalArgumentException("Parameter name darf nicht leer sein.");
		if(m == null || f == null) 
			throw new IllegalArgumentException("Parameter mother und father dürfen nicht null sein.");
		if(!m.getAlive() || !f.getAlive()) 
			throw new IllegalArgumentException("Vater und Mutter müssen leben.");
		if(m.equals(f)) 
			throw new IllegalArgumentException("Vater und Mutter dürfen nicht gleich sein.");
		
		name = n;
		mother = m;
		father = f;
		alive = true;
		fightSkills = (int) Math.round((m.getFightSkills() * 1.0 + f.getFightSkills() * 1.0) / 2.0);
		if(m.getHouse() != null) 
			house = m.getHouse();
		else 
			house = f.getHouse();
		
	}
	
	/**
	 * Lässt zwei Charaktere kämpfen.
	 * Der Charakter mit weniger Kampfstärke stirbt, bei Gleichstand überleben beide.
	 * @param other Gegner (darf nicht {@code null} sein).
	 * Beide Charaktere müssen leben, Charakter kann nicht gegen sich selbst kämpfen.
	 */
	public void fight(final Character other) {
		if(other == null) 
			throw new IllegalArgumentException("Charakter hat kein Gegner");
		if(!this.getAlive() || !other.getAlive()) 
			throw new IllegalArgumentException("Beide Charaktere müssen leben.");
		if(this.equals(other)) 
			throw new IllegalArgumentException("Charakter kann nicht gegen sich selbst kämpfen.");
		
		if(this.getFightSkills() < other.getFightSkills()) 
			this.setAlive(false);
		else if(this.getFightSkills() > other.getFightSkills()) 
			other.setAlive(false);
	}
	
	public String getName() {
		return name;
	}
	
	public House getHouse() {
		return house;
	}
	
	public Character getMother() {
		return mother;
	}
	
	public Character getFather() {
		return father;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setAlive(boolean a) {
		alive = a;
	}
	
	public int getFightSkills() {
		return fightSkills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alive ? 1231 : 1237);
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + fightSkills;
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Character other = (Character) obj;
		if(name == null) {
			if(other.name != null) 
				return false;
		}
		else if(!name.equals(other.name)) 
			return false;
		if(house == null) {
			if(other.house != null) 
				return false;
		}
		else if(!house.equals(other.house)) 
			return false;
		if(mother == null) {
			if(other.mother != null)
				return false;
		}
		else if(!mother.equals(other.mother))
			return false;
		if(father == null) {
			if(other.father != null)
				return false;
		}
		else if(!father.equals(other.father))
			return false;
		if(alive != other.alive)
			return false;
		if(fightSkills != other.fightSkills)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(mother == null && father == null) {
			return "Character [name = " + name + 
					", house = " + house.getName() + 
					", mother = " + mother + 
					", father = " + father + 
					", alive = " + alive + 
					", fightSkills = " + fightSkills + 
					"]";
		}
		else if(mother == null && father != null) {
			return "Character [name = " + name + 
					", house = " + house.getName() + 
					", mother = " + mother + 
					", father = " + father.getName() + 
					", alive = " + alive + 
					", fightSkills = " + fightSkills + 
					"]";
		}
		else if(mother != null && father == null) {
			return "Character [name = " + name + 
					", house = " + house.getName() + 
					", mother = " + mother.getName() + 
					", father = " + father + 
					", alive = " + alive + 
					", fightSkills = " + fightSkills + 
					"]";
		}
		else {
			return "Character [name = " + name + 
					", house = " + house.getName() + 
					", mother = " + mother.getName() + 
					", father = " + father.getName() + 
					", alive = " + alive + 
					", fightSkills = " + fightSkills + 
					"]";
		}
	}
}
