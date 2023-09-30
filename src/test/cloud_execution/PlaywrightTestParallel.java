package test.cloud_execution;

import java.net.URLEncoder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.SampleTestFlow;

public class PlaywrightTestParallel {

	@Test(dataProvider = "BrowserCapabilities", dataProviderClass = LambdaTestCapabilities.class)
	public void playwrightTestParralel(JsonObject capability) {
		try (Playwright playwright = Playwright.create()) {

			String caps = URLEncoder.encode(capability.toString(), "utf-8");
			String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capability;
			Browser browser = playwright.chromium().connect(cdpUrl);

			// Create BrowserContext object and use it to create a Page object to execute
			// cases in isolation
			BrowserContext browserContext = browser.newContext();
			Page page = browserContext.newPage();

			SampleTestFlow.playwrightTestFlow(page);

			page.close();
			browserContext.close();
			browser.close();
			playwright.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

}
