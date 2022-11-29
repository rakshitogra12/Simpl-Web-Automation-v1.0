package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AbhiBusEndtoEndflow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> AbhiBusSuccessTestCode() throws Exception {

		driver.get(readconfig.getAbhiBusURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='navbarDropdown']")));

		driver.findElement(By.cssSelector("a[id='navbarDropdown']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'mobileNo']")));

		driver.findElement(By.xpath("//input[@id ='mobileNo']")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='getotp']")));

		driver.findElement(By.cssSelector("input[id='getotp']")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"signinVerify\"]"))).click();

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("input[id=\"signinVerify\"]")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='source']")));

		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Mumbai");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[id='ui-id-1']>li:nth-child(1)")));

		driver.findElement(By.cssSelector("ul[id='ui-id-1']>li:nth-child(1)")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='destination']")));

		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Delhi");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[id='ui-id-2']>li:nth-child(1)")));

		driver.findElement(By.cssSelector("ul[id='ui-id-2']>li:nth-child(1)")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='datepicker1']")));

		driver.findElement(By.cssSelector("input[id=\"datepicker1\"]")).click();

		driver.findElement(By.xpath("(//a[contains(text(),'25')])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search')]")));

		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Select Seat')])[1]")));

		driver.findElement(By.xpath("(//span[contains(text(),'Select Seat')])[1]")).click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(@class,'sleeper available')])[1]/a")));

		driver.findElement(By.xpath("(//li[contains(@class,'sleeper available')])[1]/a")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("boardingpoint_id")));

		Select boardingpt = new Select(driver.findElement(By.id("boardingpoint_id")));

		boardingpt.selectByIndex(2);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droppingpoint_id")));

		Select droppingpt = new Select(driver.findElement(By.id("droppingpoint_id")));

		droppingpt.selectByIndex(2);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='btnEnable1']")));

		driver.findElement(By.cssSelector("input[id='btnEnable1']")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='tabs']/ul/li")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@id='tabs']/ul/li"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Simpl")) {

				System.out.println("Simpl Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/ul/li]", "/ul/li");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				wait.until(ExpectedConditions.elementToBeClickable(element4));

				Thread.sleep(5000);

				Actions builder = new Actions(driver);

				Action mouseOverHome = builder.moveToElement(element4).click().build();

				mouseOverHome.perform();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "N";
				}

				String actualtext = driver.findElement(By.xpath("//div[@id='q']/h3[2]")).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Simpl Option is not present on the No." + pl_position + " position");

			}

		}
		return dataValues;

	}

}
