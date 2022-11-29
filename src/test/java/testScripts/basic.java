package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class basic {

	@Test

	public void AppiumTest() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("PIXEL XL");

		options.setApp("/Users/rakshitogra/Downloads/app-staging (1).apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);

	}

}	
