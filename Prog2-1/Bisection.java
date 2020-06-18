public class Bisection {
	
	private static double f(double x) {
		return Math.cos(x);
	}

	public static void main(String[] args) {
		double l, r, c = 0;
		l = Double.parseDouble(args[0]);
		r = Double.parseDouble(args[1]);
		if(l > r) {
			System.out.println("Error: l > r.");
			System.exit(1);
		}
		if(f(l) <= 0 || f(r) >= 0) {
			System.out.println("Error: f(l) <= 0 oder f(r) >= 0.");
			System.exit(1);
		}
		for(int i = 1; i <= 10; i++) {
			c = (l + r) / 2;
			System.out.printf("Iteration " + i + ": f(%.6f) = %.6f\n", c, f(c));
			if(f(c) > 0) l = c;
			else r = c;
		}
		System.out.printf("Ergebnis: f(%.6f) = %.6f\n", c, f(c));
	}

}

