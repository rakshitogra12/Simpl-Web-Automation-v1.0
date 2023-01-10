package plTestEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class MyJioEndToEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> MyJioSuccessTestCode() throws Exception {

		driver.get(readconfig.getJioURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("Sign-In")));

		driver.findElement(By.id("Sign-In")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='inputField']")));

		driver.findElement(By.cssSelector("input[id='inputField']")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid=\"generateOTPButton\"]")));

		driver.findElement(By.cssSelector("button[data-testid=\"generateOTPButton\"]")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label=\"button Submit\"]")));

		driver.findElement(By.cssSelector("button[aria-label=\"button Submit\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Discover')])[1]")));

		driver.findElement(By.xpath("(//a[contains(text(),'Discover')])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Recharge')])[3]")));

		driver.findElement(By.xpath("(//button[contains(text(),'Recharge')])[3]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("quick-recharge-user-number")));

		driver.findElement(By.id("quick-recharge-user-number")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'primary continue-btn')]")));

		driver.findElement(By.xpath("//button[contains(@class,'primary continue-btn')]")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='css-ujoff3']/div/div")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@class='css-ujoff3']/div/div"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.equalsIgnoreCase("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/div/div]", "/div/div");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1))));

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='css-1xij2kj']/p")));

				String actualtext = driver.findElement(By.xpath("//div[@class='css-1xij2kj']/p")).getText();

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