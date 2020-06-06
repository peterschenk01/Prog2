public class Calculator {
		
	public static void main(String[] args) {		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[2]);
		String c = args[1];
		
		switch(c) {
		case "+":	System.out.println(a + b);
					break;
		case "-":	System.out.println(a - b);
					break;
		case "x":	System.out.println(a * b);
					break;
		case "/":	System.out.println(a / b);
					break;
		case "%":	System.out.println(a % b);
					break;
		}
	}
}
