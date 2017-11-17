package intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {

		System.out.println(match("abcdef^%!&$%@$s5", "@$??"));
	}

	public static boolean match(String s, String p) {
		StringBuilder pBuilder = new StringBuilder("");
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '?')
				pBuilder.append('.');
			else if (p.charAt(i) == '*')
				pBuilder.append(".*");
			else
				pBuilder.append(p.charAt(i));
		}
		String escaped = pBuilder.toString().replaceAll("([\\\\\\[\\{\\(\\+\\?\\^\\$\\|‌​])", "\\\\$1");
		Pattern pattern = Pattern.compile(escaped);
		Matcher str = pattern.matcher(s);
		return str.find();
	}

	
}


/*
symbol:   variable PatternMatcher
location: class PatternMatcherTests
01/PatternMatcherTests.java:74: error: cannot find symbol
assertTrue(PatternMatcher.match("%&%$%^&^hjgewkjhdedhhjdewewghjgdewhjgdewhjg", "%??$*jg"));
           
           symbol:   variable PatternMatcher
location: class PatternMatcherTests
01/PatternMatcherTests.java:99: error: cannot find symbol
assertTrue(PatternMatcher.match("abcdef^%!&$%@$s5", "@$??"));
           ^
           symbol:   variable PatternMatcher
location: class PatternMatcherTests
01/PatternMatcherTests.java:114: error: cannot find symbol
assertFalse(PatternMatcher.match("abc", "abc+"));
            ^
           */