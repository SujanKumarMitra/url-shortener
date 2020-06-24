package com.skmproject.urlshortener.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultUrlValidatorTest {
	
	static String validPatterns[] = {
			"http://www.sample.com",
			"https://www.sample.com/",
			"https://www.sample.com#",
			"http://www.sample.com/xyz",
			"http://www.sample.com/#xyz",
			"www.sample.com",
			"http://www.sample.com",
	};
	
	static String invalidPatterns[] = {
			"http://sample.com//"
	};


	@Test
	@DisplayName("Valid Patterns")
	void testValid() {
		DefaultUrlValidator obj = new DefaultUrlValidator();
		for (int i = 0; i < validPatterns.length; i++) {
			assertTrue(obj.isUrlValid(validPatterns[i]),"failed at "+ i +"'th ieration");
		}
	}

	@Test
	@DisplayName("Invalid Patterns")
	void testInvalid() {
		DefaultUrlValidator obj = new DefaultUrlValidator();
		for (int i = 0; i < invalidPatterns.length; i++) {
			assertFalse(obj.isUrlValid(invalidPatterns[i]),"failed at "+ i +"'th ieration");
		}
	}

}
