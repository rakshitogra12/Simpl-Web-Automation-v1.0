package tachyonTestScripts;

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class Payload_New {

	public static void main(String[] args) throws InterruptedException, IOException {

		BrowserMobProxy myProxy = new BrowserMobProxyServer();

		myProxy.start(0);

		Proxy seleniumProxy = new Proxy();

		seleniumProxy.setHttpProxy("localhost:" + myProxy.getPort());
		seleniumProxy.setSslProxy("localhost:" + myProxy.getPort());

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(CapabilityType.PROXY, seleniumProxy);
		capability.acceptInsecureCerts();
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		EnumSet<CaptureType> captureTypes = CaptureType.getAllContentCaptureTypes();
		captureTypes.addAll(CaptureType.getCookieCaptureTypes());
		captureTypes.addAll(CaptureType.getHeaderCaptureTypes());
		captureTypes.addAll(CaptureType.getRequestCaptureTypes());
		captureTypes.addAll(CaptureType.getResponseCaptureTypes());

		myProxy.setHarCaptureTypes(captureTypes);

		myProxy.newHar("MyHAR");

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.merge(capability);

		WebDriver driver = new ChromeDriver(options);

		System.out.println("Driver Capabilities===> \n" + ((RemoteWebDriver) driver).getCapabilities().asMap().toString());

		driver.get("https://urbanpitara.com/collections/athleisure");

		driver.findElement(By.xpath("//span[contains(text() , 'Acid Trip Leggings')]")).click();

		driver.findElement(By.xpath("(//*[@id='simpl_buynow-button'])[2]")).click();

		driver.manage().window().maximize();

		Thread.sleep(8000);

		Har har = myProxy.getHar();

		File myHARFile = new File("/Users/rakshitogra/Documents/HAR File/googleHAR1.har");

		har.writeTo(myHARFile);

		System.out.println("HAR details has been successfully written in the file");

//		driver.close();

	}

}