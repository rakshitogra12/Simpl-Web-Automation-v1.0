package testEndtoEndFlows;

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

public class MakeMyTripendtoendflow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> MakemytripSuccessfulScenarioCode() throws Exception {

		driver.get(readconfig.getMMTURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		int eventPositiononbtn = 1;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'bus-tickets')]")));

		driver.findElement(By.xpath("//a[contains(@href,'bus-tickets')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='travelDate']")));

		driver.findElement(By.cssSelector("input[id='travelDate']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[aria-label='Fri Dec 02 2022']")));

		driver.findElement(By.cssSelector("div[aria-label='Fri Dec 02 2022']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[id='search_button']")));

		driver.findElement(By.cssSelector("button[id='search_button']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='primo-popup-content']>img:nth-child(2)")));

		driver.findElement(By.cssSelector("div[class='primo-popup-content']>img:nth-child(2)")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-test-id=\"select-seats\"])[1]")));

		driver.findElement(By.xpath("(//a[@data-test-id=\"select-seats\"])[1]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@data-testid=\"seat_horizontal_sleeper_available\"]/img)[4]")));

		driver.findElement(By.xpath("(//div[@data-testid=\"seat_horizontal_sleeper_available\"]/img)[4]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'cta-book-seats')]")));

		driver.findElement(By.xpath("//div[contains(@class,'cta-book-seats')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id=\"fname\"]")));

		driver.findElement(By.cssSelector("input[id=\"fname\"]")).sendKeys("Rakshit");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id=\"age\"]")));

		driver.findElement(By.cssSelector("input[id=\"age\"]")).sendKeys("28");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='GenderDropDownContainer']")));

		driver.findElement(By.cssSelector("div[class='GenderDropDownContainer']")).click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'male')]")));

		driver.findElement(By.xpath("//span[contains(@class,'male')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id=\"contactEmail\"]")));

		driver.findElement(By.cssSelector("input[id=\"contactEmail\"]")).sendKeys("rakshit.ogra@getsimpl.com");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"contactEmail\"]")));

		driver.findElement(By.cssSelector("input[id=\"mobileNumber\"]")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'sc-kPVwWT')])[3]")));

		driver.findElement(By.xpath("(//span[contains(@class,'sc-kPVwWT')])[3]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'paymentBtn')]")));

		driver.findElement(By.xpath("//a[contains(@class,'paymentBtn')]")).click();

		Thread.sleep(10000);

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='payment__options__tab']/ul/li")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@class='payment__options__tab']/ul/li"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + pl_position + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/ul/li]", "/ul/li");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element1 = driver.findElement(By.xpath(abc1));

				element1.click();

				if (eventPositiononbtn == 1) {

					eventPositiononbtntext = "Y";
				}

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(@class,'prime__btn')])[2]")));

				driver.findElement(By.xpath("(//button[contains(@class,'prime__btn')])[2]")).click();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='partner__list']/li[2]/div[1]/p/span[contains(text(),'SIMPL')]")));
						
				String actualtext = driver.findElement(By.xpath("//ul[@class='partner__list']/li[2]/div[1]/p/span[contains(text(),'SIMPL')]")).getText();

				Assert.assertEquals(actualtext, "SIMPL", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Pay Later option is not present on the No." + pl_position + " position");

				flag++;

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

		return dataValues;

	}

}
