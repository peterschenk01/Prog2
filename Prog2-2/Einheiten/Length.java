public final class Length {
	private double value;
	private LengthUnit unit;
	
	public Length(double value, LengthUnit unit) {
		if(value < 0)
			throw new IllegalArgumentException("Parameter value darf nicht negativ sein.");
		if(unit == null)
			throw new IllegalArgumentException("Parameter unit darf nicht null sein.");
		this.value = value;
		this.unit = unit;
	}
	
	public double getValue() {
		return value;
	}
	
	public LengthUnit getUnit() {
		return unit;
	}
	
	public Length as(LengthUnit unit) {
		return new Length((value * this.unit.getMeters()) / unit.getMeters(), unit);
	}
	
	public Length add(Length other) {
		if(other == null)
			throw new IllegalArgumentException("Parameter other darf nicht null sein.");
		return new Length(this.value + other.as(this.unit).value, unit);
	}
	
	@Override
	public String toString() {
		return "" + value + unit;
	}
}
