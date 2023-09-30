package base;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SampleTestFlow {
	
	/*
	 * This function is to execute the test flow.
	 * Navigate to webpage, fill and submit data,
	 * and assert confirmation message.
	 */
	public static void playwrightTestFlow(Page page) {
		try {
			// Navigate to the Lambdatest Selenium Playground
			page.navigate("https://www.lambdatest.com/selenium-playground/");

			// Locate the Input Form Submit link and click on it.
			Locator inputForm = page.locator("text=Input Form Submit");
			inputForm.click();

			// Assert Input Form Submit page is loaded
			assertThat(page.getByText("Input form validations")).isVisible();

			// fill data in the form
			fillInputFormData(page);

			// Click Submit button to submit the form
			page.getByText("Submit").click();

			// Fetch the success message, print it on console, and assert same.
			String successMessage = page.locator("xpath=//p[@class='success-msg hidden']").textContent();
			System.out.println(successMessage);
			assertThat(page.locator("xpath=//p[@class='success-msg hidden']"))
					.hasText("Thanks for contacting us, we will get back to you shortly.");

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/*
	 * This function is to fill all the required input form fields on the webpage
	 */
	private static void fillInputFormData(Page page) 
	{
		page.locator("id=name").fill("Playwright");		
		page.locator("id=inputEmail4").fill("Playwright@example.com");
		page.locator("id=inputPassword4").fill("Playwright@123");
		page.getByPlaceholder("Company").fill("Lambdatest");
		page.getByPlaceholder("Website").fill("www.playwright.dev");
		page.locator("xpath=//select[@name='country']").selectOption("IN");
		page.locator("xpath=//input[@name='city']").fill("Gurgaon");
		page.locator("xpath=//*[@name='address_line1']").fill("House 1");
		page.locator("css=input#inputAddress2").fill("Sector 1");
		page.locator("css=#inputState").fill("Haryana");
		page.locator("id=inputState").fill("Haryana");
		page.locator("css=input[name='zip']").fill("123456");
	}
}
