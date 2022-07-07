package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecking {
	private static Pattern pattern;
	private Matcher matcher;

	private static final String Pass_REGEX =   "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

	public PasswordChecking() {
		pattern = Pattern.compile(Pass_REGEX);
	}

	public boolean validate(String regex) {
		matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}
