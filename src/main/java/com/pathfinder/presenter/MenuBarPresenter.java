package com.pathfinder.presenter;

import com.pathfinder.view.components.MenuBar;

public class MenuBarPresenter implements MenuBarPresenterSpec {
	private final MenuBar menuBar = new MenuBar();

	public MenuBar getMenuBar() {
		return this.menuBar;
	}

}