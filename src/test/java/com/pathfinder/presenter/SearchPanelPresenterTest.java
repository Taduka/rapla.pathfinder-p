package com.pathfinder.presenter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pathfinder.model.KeyboardModel;
import com.pathfinder.view.components.Keyboard;

public class SearchPanelPresenterTest {
	KeyboardModel keyboardModel;
	Keyboard keyboard;
	SearchPanelPresenter searchPanelPresenter;

	@Before
	public void setUp() {
		keyboardModel = new KeyboardModel();
		keyboard = new Keyboard();
		searchPanelPresenter = new SearchPanelPresenter();
	}

	@Test
	public void addKeyboardKeyToSearchStringTest() {
		searchPanelPresenter.buttonClick("I");
		searchPanelPresenter.buttonClick("K");
		assertEquals("IK", keyboardModel.getSearchString());
	}

	@Test
	public void deleteKeyboardKeyFromSearchStringTest() {
		searchPanelPresenter.buttonClick("I");
		searchPanelPresenter.buttonClick("K");
		searchPanelPresenter.buttonClick("DELETE");
		assertEquals("I", keyboardModel.getSearchString());
	}

	@Test
	public void clearSearchStringTest() {
		searchPanelPresenter.buttonClick("I");
		searchPanelPresenter.buttonClick("K");
		searchPanelPresenter.clearSearchString();
		assertEquals("", keyboardModel.getSearchString());
	}

}