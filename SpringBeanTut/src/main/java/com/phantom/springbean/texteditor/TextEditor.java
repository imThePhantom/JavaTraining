package com.phantom.springbean.texteditor;

public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		super();
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Set Spell Checker");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
	public void init() {
		System.out.println("Init TE bean");
	}
	
	public void destroy() {
		System.out.println("Destroy TE bean");
	}
}
