public enum LengthUnit {
	MILLIMETER("mm", 0.001), CENTIMETER("cm", 0.01), METER("m", 1), KILOMETER("km", 1000), ASTRONOMICAL_UNIT("au", 0.149e12),
	INCH("in", 0.0254), FOOT("ft", 0.305), YARD("yd", 0.914);
	
	private final String symbol;
	private final double meters;
	
	private LengthUnit(String symbol, double meters) {
		this.symbol = symbol;
		this.meters = meters;
	}
	
	public double getMeters() {
		return meters;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public boolean isSI() {
		if(symbol.equals("mm") || symbol.equals("cm") || symbol.equals("m") || symbol.equals("km") || symbol.equals("au"))
			return true;
		else
			return false;
	}
}
