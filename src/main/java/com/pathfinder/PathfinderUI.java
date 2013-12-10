package com.pathfinder;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

import com.pathfinder.presenter.MainPresenter;
import com.pathfinder.translation.Translator;
import com.vaadin.annotations.Theme;
//import com.vaadin.external.org.slf4j.Logger;
//import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("rapla_pathfinder_p")
public class PathfinderUI extends UI {

	Logger logger = LogManager.getLogger(PathfinderUI.class.getName());

	// private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	protected void init(VaadinRequest request) {

		setUiLocale(request.getLocale());
		setErrorHandler(new PathfinderErrorHandler());

		/* Returns the current width of the browser window */
		Page.getCurrent().getBrowserWindowWidth();
		logger.trace("Current window width: "
				+ Page.getCurrent().getBrowserWindowWidth());

		/* Returns the max width of the browser window */
		WebBrowser browser = getPage().getWebBrowser();
		logger.trace("Max browser width: " + browser.getScreenWidth());

		if (browser.getScreenWidth() > 768) {
			// TODO
		} else {
			// TODO
		}

		/* Method 3 */
		if (request instanceof VaadinServletRequest) {
			HttpServletRequest httpRequest = ((VaadinServletRequest) request)
					.getHttpServletRequest();
			String userAgent = httpRequest.getHeader("User-Agent")
					.toLowerCase();

			logger.trace(userAgent);

			// TODO: Check user agent for all tablet matching keywords
			if (userAgent.contains("ipad")) {
				// ...
			}

		}
	}

	/**
	 * Sets locale of UI as specified in parameter; if it's not supported or
	 * null, the fallback locale will be taken
	 * 
	 * @param locale
	 */
	private void setUiLocale(Locale locale) {
		if (locale != null
				&& Translator.getInstance().isLocaleSupported(locale)) {
			setLocale(locale);
		} else {
			setLocale(Translator.getInstance().getFallbackLocale());
		}

	}

}