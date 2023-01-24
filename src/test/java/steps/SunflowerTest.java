package steps;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SunflowerTest {

	private AppiumDriver appiumDriver;
	private static By addPlant = By.id("add_plant");

	@When("User launch Sunflower app")
	public void user_launch_sunflower_app() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("deviceName", "Nexus 6");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("newCommandTimeout", 120);

		// Launches the below android virtual device and waits for 120 seconds for AVD
		// to be ready
		capabilities.setCapability("avd", "Nexus6_API_30");
		capabilities.setCapability("avdReadyTimeout", 120000);
		// Launches the Android App
		capabilities.setCapability("appPackage", "com.google.samples.apps.sunflower");
		capabilities.setCapability("appActivity", "com.google.samples.apps.sunflower.GardenActivity");

		appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Then("User sees My Garden screen with {string} text")
	public void user_sees_my_garnden_screen_with_text(String expTxt) {
		String actualTxt = appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/empty_garden"))
				.getText();
		System.out.println(actualTxt);
		expTxt = "Your garden is empty";
		if (expTxt.equals(actualTxt)) {
			System.out.println("Correct message is displayed!!!");
		}

	}

	@Then("User sees My Garden screen with {string} button")
	public void user_sees_my_garnden_screen_with_button(String expBtnTxt) {

		expBtnTxt = "ADD PLANT";

		if (appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant")).isDisplayed()) {

			System.out.println("ADD PLANT Button is Displayed!");

		} else {

			System.out.println("ADD PLANT Button is missing!");
		}

		String actBtnTxt = appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant")).getText();

		if (expBtnTxt.equals(actBtnTxt)) {

			System.out.println("Button text is displayed correctly!");

		} else {

			System.out.println("Button text is incorrect!");
		}

	}

	@Then("User click Plant List and My Garden tab")
	public void user_click_plant_list_and_my_garden_tab() {
		if (appiumDriver.findElement(MobileBy.AccessibilityId("Plant list")).isDisplayed()) {
			appiumDriver.findElement(MobileBy.AccessibilityId("Plant list")).click();
			System.out.println("PLANT LIST tab is clicked!");
		}
		if (appiumDriver.findElement(MobileBy.AccessibilityId("My garden")).isDisplayed()) {
			appiumDriver.findElement(MobileBy.AccessibilityId("My garden")).click();
			System.out.println("MY GARDEN tab is clicked!");
		}

		WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
		// verify that the ADD PLANT button is displayed when MY GARDEN tab clicked
		wait.until(ExpectedConditions.presenceOfElementLocated(addPlant)).isDisplayed();

	}

	@When("User clicks ADD PLANT button")
	public void user_clicks_add_plant_button() {

		appiumDriver.findElement(addPlant).click();

	}

	@Then("User navigates to the Plant List tab")
	public void user_navigates_to_the_plant_list_tab() {

		if (appiumDriver.findElement(MobileBy.AccessibilityId("Plant list")).isDisplayed()) {

			System.out.println("Navigated to the PLANT LIST tab!");
		} else {

			System.out.println("Something Wrong!");

		}

	}

	@After
	public void cleanup() {
		appiumDriver.quit();
	}

}
