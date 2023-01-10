package plTestEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class NykkaEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> NykkaSuccessTestCode() throws Exception {

		driver.get(readconfig.getNykaaURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search-suggestions-nykaa")));

		driver.findElement(By.name("search-suggestions-nykaa"))
				.sendKeys("Vaseline Intensive Care Cocoa Glow Body Lotion");

		driver.findElement(By.name("search-suggestions-nykaa")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='css-qlopj4'])[1]")));

		driver.findElement(By.xpath("(//a[@class='css-qlopj4'])[1]")).click();

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {

			String ChildWindow = iterator.next();

			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add to Bag')])[1]")));

		driver.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='css-g4vs13']")));

		driver.findElement(By.cssSelector("button[class='css-g4vs13']")).click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("css-acpm4k")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'e8tshxd0')])[2]")));

		driver.findElement(By.xpath("(//button[contains(@class,'e8tshxd0')])[2]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log In')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'login-input')]")));

		driver.findElement(By.xpath("//input[contains(@class,'login-input')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("emailMobile")));

		driver.findElement(By.name("emailMobile")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitVerification")));

		driver.findElement(By.id("submitVerification")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'verify')]")));

		driver.findElement(By.xpath("//button[contains(text(),'verify')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Deliver here')])[1]")));

		driver.findElement(By.xpath("(//button[contains(text(),'Deliver here')])[1]")).click();

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'css-11zya')]/div")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[contains(@class,'css-11zya')]/div"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Shop now & Pay later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/div]", "/div");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1))));

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[contains(text(),'Simpl')])[2]")));

				String actualtext = driver.findElement(By.xpath("(//p[contains(text(),'Simpl')])[2]")).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

			}

		}

		return dataValues;

	}

}
