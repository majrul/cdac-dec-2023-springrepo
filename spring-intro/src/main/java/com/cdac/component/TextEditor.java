package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

	@Autowired
	private SpellChecker sp;
	
	public void load(String document) {
		System.out.println("text editor loaded " + document);
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(document);
	}
}
