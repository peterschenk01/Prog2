
public class PasswordChecker {
	
	public static boolean check(String password) {
		if(password == null || password.length() < 8) {
			return false;
		}
		
		boolean containsUppercase = false, containsLowercase = false, containsNumber = false, containsSpecialLetter = false;
		
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
				containsUppercase = true;
			else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
				containsLowercase = true;
			else if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
				containsNumber = true;
			else if(password.charAt(i) == '#' || password.charAt(i) == '.' || password.charAt(i) == '?' || password.charAt(i) == '!')
				containsSpecialLetter = true;
			else
				return false;
		}
		
		return containsUppercase && containsLowercase && containsNumber && containsSpecialLetter;
	}
}
