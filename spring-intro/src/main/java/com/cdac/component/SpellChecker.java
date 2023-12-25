package com.cdac.component;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

	//private String[] dict = {};
	
	public void checkSpellingMistakes(String document) {
		System.out.println("spell checker executed for " + document);
	}
}
