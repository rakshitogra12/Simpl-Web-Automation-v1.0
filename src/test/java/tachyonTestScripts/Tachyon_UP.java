package tachyonTestScripts;

import java.io.File;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.Headers;

public class Tachyon_UP {

	static int[] num = new int[3];
	static int x = 0;
	static int i = 0;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/main/Webdrivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();
		PrintStream o = new PrintStream(
				new File("/Users/mandeep/Documents/code/eclipse/appium_practice/src/test/B.txt"));
		System.setOut(o);
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request -> {
			if (request.getRequest().getUrl().contains("https://pi3-backend.getsimpl.com/api/v1/publish/events")) {
				System.out.println("Request URL:" + request.getRequest().getUrl());
				System.out.println("Request Headers:" + request.getRequest().getHeaders());
			}
		});

		devTools.addListener(Network.responseReceived(), response -> {
			if (response.getResponse().getUrl().contains("https://pi3-backend.getsimpl.com/api/v1/publish/events")) {
				Headers abc = response.getResponse().getHeaders();

				Iterator<Map.Entry<String, Object>> it = abc.entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry<String, Object> pair = it.next();
					if (pair.getKey().contains("date")) {
						Object text = pair.getValue();
						String regex = "\\s+(\\d+\\:\\d+\\:\\d+)\\s+";
						Pattern pattern = Pattern.compile(regex);
						String stringToBeMatched = (String) text;
						Matcher matcher = pattern.matcher(stringToBeMatched);
						MatchResult result = matcher.toMatchResult();

						while (matcher.find()) {
							System.out.println(matcher.group(1));
						}

					}

				}

			}

		});

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://urbanpitara.com/collections/athleisure");

		driver.findElement(By.xpath("//span[contains(text(),‘Acid Trip Leggings’)]")).click();

		driver.findElement(By.xpath("(//*[@id=‘simpl_buynow-button’])[2]")).click();

		Thread.sleep(5000);

		driver.quit();

	}
}
