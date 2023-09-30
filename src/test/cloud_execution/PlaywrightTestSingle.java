package test.cloud_execution;

import java.net.URLEncoder;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;

import base.SampleTestFlow;

public class PlaywrightTestSingle {
	@Test
	public void playwrightTestSingle() {

		String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
		String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS");

		try (Playwright playwright = Playwright.create()) {
			JsonObject capabilities = new JsonObject();
			JsonObject ltOptions = new JsonObject();

			capabilities.addProperty("browsername", "Chrome");
			capabilities.addProperty("browserVersion", "latest");
			ltOptions.addProperty("platform", "Windows 10");
			ltOptions.addProperty("name", "Playwright Single Cloud Test");
			ltOptions.addProperty("build", "Playwright Java");
			ltOptions.addProperty("user", username);
			ltOptions.addProperty("accessKey", accessKey);
			capabilities.add("LT:Options", ltOptions);

			String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
			String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capabilities;
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