package plTestEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class EatSureEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> EatSureSuccessTestCode() throws Exception {

		driver.get(readconfig.getEatsureURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.cssSelector("input[data-testid=\"autocomplete-input\"]")).sendKeys("Pune");

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")));

		driver.findElement(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[data-qa=\"searchOption\"]")));

		driver.findElement(By.cssSelector("p[data-qa=\"searchOption\"]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input[class=\"style__Input-sc-1nogo41-4 cbRUfa\"]")));

		driver.findElement(By.cssSelector("input[class=\"style__Input-sc-1nogo41-4 cbRUfa\"]")).sendKeys("Biryani");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div[class=\"style__ListContainer-sc-1nogo41-9 cPORqb\"]>a:nth-child(1)")));

		driver.findElement(By.cssSelector("div[class=\"style__ListContainer-sc-1nogo41-9 cPORqb\"]>a:nth-child(1)"))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-qa='addButton'])[2]")));

		driver.findElement(By.xpath("(//button[@data-qa='addButton'])[2]")).click();

//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-qa=\"addItemButton\"]")));

//		driver.findElement(By.cssSelector("button[data-qa=\"addItemButton\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[data-qa='cartOption']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("p[data-qa='cartOption']")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));

		driver.findElement(By.id("phone_number")).sendKeys("9324977971");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send_otp")));

		driver.findElement(By.id("send_otp")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[role='submit']")));

		driver.findElement(By.cssSelector("button[role='submit']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'RadioLabel')]")));

		driver.findElement(By.xpath("//div[contains(@class,'RadioLabel')]")).click();

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='sc-furvIG lkLLxz']>div")));

		List<WebElement> payMethodList = driver.findElements(By.cssSelector("div[class='sc-furvIG lkLLxz']>div"));

		Thread.sleep(5000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay later")) {

				System.out.println("Pay Later Option is present on the No. " + pl_position + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("css selector:");

				String xpathact2 = xpathact1[1].replaceAll(">div]", ">div");

				String abc = xpathact2 + ":nth-child" + "(" + pl_position + ")";

				WebElement element4 = driver.findElement(By.cssSelector(abc));

				wait.until(ExpectedConditions.elementToBeClickable(element4));

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "N";
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("div[class='flex-x9ump0-0 iAgTKA']>div:nth-child(1)")));

				String actualtext = driver
						.findElement(By.cssSelector("div[class='flex-x9ump0-0 iAgTKA']>div:nth-child(1)")).getText();

				Assert.assertEquals(actualtext, "SIMPL", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.toLowerCase();

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
