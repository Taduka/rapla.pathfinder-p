/**
 * 
 */
package com.pathfinder.translation;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

/**
 * @author tim
 * 
 */
public class TranslatorTest {

	private TranslatorSpec translator;

	@Before
	public void initialize() {
		this.translator = Translator.getInstance();
	}

	@Test
	public void translateTest() {
		String translation = translator.translate(TranslationKeys.ROOM,
				Locale.GERMAN);

		assertEquals("Raum", translation);

		translation = translator.translate(TranslationKeys.PERSON,
				Locale.GERMAN);
		assertEquals("Person", translation);

		translation = translator.translate(TranslationKeys.COURSE,
				Locale.ENGLISH);
		assertEquals("Class", translation);
	}

	@Test
	public void translateTestForCurrentLocale() {
		String translation = translator.translate(TranslationKeys.ROOM);

		assertEquals("Raum", translation);

		translation = translator.translate(TranslationKeys.PERSON);
		assertEquals("Person", translation);
	}

	@Test
	public void getDefaultLocaleTest() {
		assertEquals(Locale.GERMAN, translator.getDefaultLocale());
	}

	@Test
	public void translateNotSupportedLanguageTest() {
		String translation = translator.translate(TranslationKeys.COURSE,
				Locale.CHINESE);
		assertEquals("", translation);
	}

	@Test(expected = AssertionError.class)
	public void tranlateMissingKey() {
		translator.translate(TranslationKeys.INVALID_KEY);
	}

	@Test(expected = AssertionError.class)
	public void tranlateMissingKeyWhenLocaleSpecified() {
		translator.translate(TranslationKeys.INVALID_KEY, Locale.ENGLISH);
	}
}