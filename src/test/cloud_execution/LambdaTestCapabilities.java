package test.cloud_execution;

import org.testng.annotations.DataProvider;

import com.google.gson.JsonObject;

public class LambdaTestCapabilities {

	@DataProvider(name = "BrowserCapabilities")
	public static Object[] getDefaultTestCapability() {
		JsonObject capabilities1 = new JsonObject();
		JsonObject ltOptions1 = new JsonObject();

		String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
		String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS");

		capabilities1.addProperty("browserName", "Chrome");
		capabilities1.addProperty("browserVersion", "latest");
		ltOptions1.addProperty("platform", "Windows 10");
		ltOptions1.addProperty("name", "Playwright Parallel Test - Chrome");
		ltOptions1.addProperty("build", "Playwright Java Parallel Cloud");
		ltOptions1.addProperty("user", username);
		ltOptions1.addProperty("accessKey", accessKey);
		capabilities1.add("LT:Options", ltOptions1);

		JsonObject capabilities2 = new JsonObject();
		JsonObject ltOptions2 = new JsonObject();
		capabilities2.addProperty("browserName", "MicrosoftEdge");
		capabilities2.addProperty("browserVersion", "latest");
		ltOptions2.addProperty("platform", "Windows 10");
		ltOptions2.addProperty("name", "Playwright Parallel Test - Edge");
		ltOptions2.addProperty("build", "Playwright Java Parallel Cloud");
		ltOptions2.addProperty("user", username);
		ltOptions2.addProperty("accessKey", accessKey);
		capabilities2.add("LT:Options", ltOptions2);
		return new Object[] { capabilities1, capabilities2 };
	}
}
