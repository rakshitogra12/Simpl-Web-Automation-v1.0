package tachyonTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.performance.Performance;
import org.openqa.selenium.devtools.v104.performance.model.Metric;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.devtools.DevTools;

public class GetMetrics {

	final static String PROJECT_PATH = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/main/Webdrivers/chromedriver");

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Performance.enable(java.util.Optional.empty()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://urbanpitara.com/collections/athleisure");
		driver.findElement(By.xpath("//span[contains(text() , \'Acid Trip Leggings')]")).click();
		driver.findElement(By.xpath("(//*[@id='simpl_buynow-button'])[2]")).click();
		
		List<Metric> metrics = devTools.send(Performance.getMetrics());
		List<String> metricNames = metrics.stream().map(o -> o.getName()).collect(Collectors.toList());
		devTools.send(Performance.disable());
		List<String> metricsToCheck = Arrays.asList("Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "MediaKeySessions", "Nodes", "LayoutDuration", "RecalcStyleDuration",
                "DomContentLoaded", "NavigationStart", "ScriptDuration", "TaskDuration");
		metricsToCheck.forEach(
				metric -> System.out.println(metric + " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
		
		driver.quit();
	}
}
