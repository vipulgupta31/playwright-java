package test.local_execution;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

import base.SampleTestFlow;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightTestLocal {

	@Test
	public void playwrightTestLocal() {
		// Create a new playwright instance
		try (Playwright playwright = Playwright.create()) {
			// Create a new browser instance and launch chrome browser.
			// To execute in headless mode (non-UI) use this
			Browser browser = playwright.chromium().launch();

			// To execute in non-headless (UI) mode use this.
			// Browser browser = playwright.chromium().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));

			// Create BrowserContext object and a Page object to execute cases in isolation
			BrowserContext browserContext = browser.newContext();
			Page page = browserContext.newPage();

			SampleTestFlow.playwrightTestFlow(page);
			
			//to close all the instances to free up memory.
			page.close();
			browserContext.close();
			browser.close();
			playwright.close();
		}
	}

}
